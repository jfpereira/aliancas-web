package pt.web.al2022.service;

import pt.web.al2022.model.Player;

import java.util.Collection;

public interface IPlayerService {
    Collection<Player> findAllPlayers();

    Player savePlayer(Player player);
}
