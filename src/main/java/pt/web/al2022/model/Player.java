package pt.web.al2022.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "T_PLAYER")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PLAYER", columnDefinition = "INT UNSIGNED")
    private Long id;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "NUMBER")
    private Integer number;

    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "HEIGHT")
    private Integer height;

    @Column(name = "WEIGHT")
    private Integer weight;

    @Enumerated(EnumType.STRING)
    @Column(name = "PLAYER_ROLE")
    private PlayerRole playerRole;
}
