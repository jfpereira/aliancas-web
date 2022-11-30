package pt.web.al2022.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.web.al2022.model.Player;
import pt.web.al2022.repository.PlayerRepo;
import pt.web.al2022.service.IPlayerService;
import pt.web.al2022.service.IUserService;

import java.util.Collection;

@Service
public class PlayerService implements IPlayerService {

    private final PlayerRepo playerRepo;
    private final IUserService userService;

    public PlayerService(@Autowired PlayerRepo playerRepo, @Autowired IUserService userService) {
        this.playerRepo = playerRepo;
        this.userService = userService;
    }


    @Override
    public Collection<Player> findAllPlayers() {

        return playerRepo.findAll();
    }

    @Override
    public Player savePlayer(Player player) {

        userService.saveUserAlianca(player);

        return playerRepo.save(player);
    }
}
