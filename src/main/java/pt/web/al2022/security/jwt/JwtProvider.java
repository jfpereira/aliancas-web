package pt.web.al2022.security.jwt;

import com.sun.security.auth.UserPrincipal;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import pt.web.al2022.security.CustomUser;
import pt.web.al2022.utils.SecurityUtils;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class JwtProvider implements IJwtProvider {

    @Value("${app.jwt.secret}")
    private String JWT_SECRET;

    @Value("${app.jwt.expiration.in-ms}")
    private Long JWT_EXPIRATION_IN_MS;

    @Override
    public String generateToken(CustomUser auth) {

        String authorities = auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

        return Jwts.builder()
                .setSubject(auth.getUsername())
                .claim("roles", authorities)
                .claim("userId", auth.getId())
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION_IN_MS))
                .signWith(key)
                .compact();
    }

    /**
     * Set authentication
     *
     * @param request
     * @return
     */
    @Override
    public Authentication getAuthentication(HttpServletRequest request) {

        Claims claims = extractClaims(request);
        if (null == claims) {
            return null;
        }

        String username = claims.getSubject();
        if (null == username) {
            return null;
        }

        Long userId = claims.get("userId", Long.class);

        Set<GrantedAuthority> authoritySet = Arrays.stream(claims.get("roles").toString().split(","))
                .map(SecurityUtils::convertToAuthority)
                .collect(Collectors.toSet());

        UserDetails userDetails = CustomUser.builder()
                .username(username)
                .authorities(authoritySet)
                .id(userId)
                .build();

        return new UsernamePasswordAuthenticationToken(userDetails, null, authoritySet);
    }

    /**
     * Validate if token expires
     *
     * @param request
     * @return
     */
    @Override
    public boolean validateToken(HttpServletRequest request) {

        Claims claims = extractClaims(request);
        if(claims == null) {
            return false;
        }
        if(claims.getExpiration().before(new Date())) {
            return false;
        }
        return true;
    }

    private Claims extractClaims(HttpServletRequest request) {

        String token = SecurityUtils.extractAuthTokenFromRequest(request);

        if(null == token) {
            return null;
        }

        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }


    /**
     *
     * @return
     */
    private Key generateKey() {

        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(JWT_SECRET);
        return new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS512.getJcaName());
    }
}
