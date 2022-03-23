package pt.web.al2022.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.web.al2022.model.User;
import pt.web.al2022.service.IAuthenticationService;
import pt.web.al2022.service.IUserService;

@RestController
@RequestMapping("api/authentication")
public class AuthenticationController {

    private final IAuthenticationService authenticationService;
    private final IUserService userService;

    public AuthenticationController(@Autowired IAuthenticationService authenticationService, @Autowired IUserService userService) {
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    @PostMapping("sign-up")
    public ResponseEntity<?> signUp(@RequestBody User user) {

        if(userService.findByEmail(user.getEmail()).isPresent()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @PostMapping("sign-in")
    public ResponseEntity<?> signIn(@RequestBody User user) {
        return new ResponseEntity<>(authenticationService.signIn(user), HttpStatus.OK);
    }
}
