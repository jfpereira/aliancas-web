package pt.web.al2022.service;

import pt.web.al2022.model.User;

public interface IAuthenticationService {
    User signIn(User signInRequest);
}
