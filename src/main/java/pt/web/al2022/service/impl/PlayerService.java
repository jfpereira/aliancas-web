package pt.web.al2022.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.web.al2022.model.Alianca;
import pt.web.al2022.repository.AliancaRepo;
import pt.web.al2022.service.IPlayerService;
import pt.web.al2022.service.IUserService;

import java.util.Collection;

@Service
public class PlayerService implements IPlayerService {

    private final AliancaRepo aliancaRepo;
    private final IUserService userService;

    public PlayerService(@Autowired AliancaRepo aliancaRepo, @Autowired IUserService userService) {
        this.aliancaRepo = aliancaRepo;
        this.userService = userService;
    }


    @Override
    public Collection<Alianca> findAllPlayers() {

        return aliancaRepo.findAll();
    }

    @Override
    public Alianca savePlayer(Alianca alianca) {

        userService.saveUserAlianca(alianca);

        return aliancaRepo.save(alianca);
    }
}
