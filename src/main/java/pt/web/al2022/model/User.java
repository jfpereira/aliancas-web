package pt.web.al2022.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)//to store string
    @Column(name = "role")
    private Role role;

    @Column(name = "data_inicio")
    private LocalDateTime dataInicio;

    @Transient
    private String token;
}
