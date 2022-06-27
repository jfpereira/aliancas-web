package pt.web.al2022.mapper;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pt.web.al2022.model.Alianca;
import pt.web.al2022.model.Role;
import pt.web.al2022.model.User;
import pt.web.al2022.utils.SecurityUtils;

import java.time.LocalDateTime;

@Component
public class UserMapper {

    private final PasswordEncoder passwordEncoder;

    public UserMapper(@Lazy PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public User aliancaToUser(Alianca alianca) {

        return User.builder()
                .email(alianca.getEmail())
                .password(passwordEncoder.encode(SecurityUtils.generateRandomPassword()))
                .dataInicio(LocalDateTime.now())
                .role(Role.USER)
                .build();
    }
}
