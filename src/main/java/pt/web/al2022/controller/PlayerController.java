package pt.web.al2022.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.web.al2022.model.Alianca;
import pt.web.al2022.service.IPlayerService;
import pt.web.al2022.service.IUserService;

@RestController
@RequestMapping("api/player")
@Slf4j
public class PlayerController {

    private final IPlayerService iPlayerService;
    private final IUserService userService;

    public PlayerController(@Autowired IPlayerService iPlayerService, @Autowired IUserService userService) {
        this.iPlayerService = iPlayerService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> getAllPlayers() {

        return new ResponseEntity<>(iPlayerService.findAllPlayers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> savePlayer(@RequestBody Alianca alianca) {

        if(userService.findByEmail(alianca.getEmail()).isPresent()) {
            log.info("User with email {} already exists!", alianca.getEmail());
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return  new ResponseEntity<>(iPlayerService.savePlayer(alianca), HttpStatus.CREATED);
    }

    @DeleteMapping("{idPlayer}")
    public ResponseEntity<?> deletePlayer(@PathVariable Long idPlayer) {

        try {
            userService.deleteById(idPlayer);

        } catch (EmptyResultDataAccessException e) {
            log.error("Error on trying delete player wiyh id {}", idPlayer);
            log.error("Error -> {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
