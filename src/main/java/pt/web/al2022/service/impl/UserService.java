package pt.web.al2022.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pt.web.al2022.mapper.UserMapper;
import pt.web.al2022.model.Alianca;
import pt.web.al2022.model.Role;
import pt.web.al2022.model.User;
import pt.web.al2022.repository.UserRepo;
import pt.web.al2022.service.IUserService;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Slf4j
public class UserService implements IUserService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserService(@Autowired UserRepo userRepo, @Lazy PasswordEncoder passwordEncoder, @Autowired UserMapper userMapper) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    @Override
    public Optional<User> findByEmail(String email) {

        return userRepo.findByEmail(email);
    }

    @Override
    public User saveUser(User user) {

        log.info("Create new user {}", user.getEmail());

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setDataInicio(LocalDateTime.now());

        if(null != user.getRole()) {
            user.setRole(Role.USER);
        }

        log.info("New user {} successfully created", user.getEmail());
        return userRepo.save(user);
    }

    @Override
    public User promoteAdmin(User user) {

        user.setRole(Role.ADMIN);

        return userRepo.save(user);
    }

    @Override
    public User saveUserAlianca(Alianca alianca) {

        log.info("Create new user by alianca email {}", alianca.getEmail());

        User user = userRepo.save(userMapper.aliancaToUser(alianca));

        log.info("New user id {} successfully created for alianca {}", user.getId(), alianca.getEmail());

        return user;
    }

    @Override
    public void deleteById(Long id) throws EmptyResultDataAccessException {
        userRepo.deleteById(id);
    }
}
