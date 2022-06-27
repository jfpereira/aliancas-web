package pt.web.al2022.service;

import pt.web.al2022.model.Alianca;
import pt.web.al2022.model.User;

import java.util.Optional;

public interface IUserService {
    Optional<User> findByEmail(String email);

    User saveUser(User user);

    User promoteAdmin(User user);

    User saveUserAlianca(Alianca alianca);

    void deleteById(Long id);
}
