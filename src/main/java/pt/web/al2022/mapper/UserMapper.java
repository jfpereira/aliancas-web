package pt.web.al2022.mapper;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pt.web.al2022.model.Player;
import pt.web.al2022.model.Role;
import pt.web.al2022.model.User;
import pt.web.al2022.utils.SecurityUtils;

@Component
public class UserMapper {

    private final PasswordEncoder passwordEncoder;

    public UserMapper(@Lazy PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public User playerToUser(Player player) {

        return User.builder()
                .email(player.getEmail())
                .password(passwordEncoder.encode(SecurityUtils.generateRandomPassword()))
                .role(Role.USER)
                .build();
    }
}
