package pt.web.al2022.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import pt.web.al2022.model.User;
import pt.web.al2022.security.CustomUser;
import pt.web.al2022.security.jwt.IJwtProvider;
import pt.web.al2022.service.IAuthenticationService;

@Service
public class AuthenticationService implements IAuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final IJwtProvider iJwtProvider;

    public AuthenticationService(@Autowired AuthenticationManager authenticationManager, @Autowired IJwtProvider iJwtProvider) {
        this.authenticationManager = authenticationManager;
        this.iJwtProvider = iJwtProvider;
    }

    /**
     * Sign In and return JWT
     *
     * @return
     */
    @Override
    public User signIn(User signInRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getEmail(), signInRequest.getPassword())
        );

        CustomUser customUser = (CustomUser) authentication.getPrincipal();

        String jwt = iJwtProvider.generateToken(customUser);

        User signUser = customUser.getUser();
        signUser.setToken(jwt);

        return signUser;
    }
}
