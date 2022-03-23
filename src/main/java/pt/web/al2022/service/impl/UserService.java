package pt.web.al2022.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pt.web.al2022.model.Role;
import pt.web.al2022.model.User;
import pt.web.al2022.repository.UserRepo;
import pt.web.al2022.service.IUserService;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserService(@Autowired UserRepo userRepo, @Lazy PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> findByEmail(String email) {

        return userRepo.findByEmail(email);
    }

    @Override
    public User saveUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setDataInicio(LocalDateTime.now());

        if(null != user.getRole()) {
            user.setRole(Role.USER);
        }
        return userRepo.save(user);
    }

    @Override
    public User promoteAdmin(User user) {

        user.setRole(Role.ADMIN);

        return userRepo.save(user);
    }
}
