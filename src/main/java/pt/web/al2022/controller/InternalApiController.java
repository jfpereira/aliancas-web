package pt.web.al2022.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.web.al2022.model.User;
import pt.web.al2022.service.IUserService;

import java.util.Optional;

@RestController
@RequestMapping("api/internal")
public class InternalApiController {

    private final IUserService userService;

    public InternalApiController(@Autowired IUserService userService) {
        this.userService = userService;
    }

    @PutMapping("make-admin/{email}")
    public ResponseEntity<?> makeAdmin(@PathVariable String email) {

        Optional<User> user = userService.findByEmail(email);

        if(!user.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(userService.promoteAdmin(user.get()), HttpStatus.OK);
    }
}
