package pt.web.al2022.security.jwt;

import org.springframework.security.core.Authentication;
import pt.web.al2022.security.CustomUser;

import javax.servlet.http.HttpServletRequest;

public interface IJwtProvider {
    String generateToken(CustomUser auth);

    Authentication getAuthentication(HttpServletRequest request);

    boolean validateToken(HttpServletRequest request);
}
