package pt.web.al2022.service;

import pt.web.al2022.model.Alianca;

import java.util.Collection;

public interface IPlayerService {
    Collection<Alianca> findAllPlayers();

    Alianca savePlayer(Alianca alianca);
}
