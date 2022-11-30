package pt.web.al2022.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.web.al2022.model.Player;

public interface PlayerRepo extends JpaRepository<Player, Long> {
}
