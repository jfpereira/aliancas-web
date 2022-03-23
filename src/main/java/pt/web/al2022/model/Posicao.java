package pt.web.al2022.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_posicao")
public class Posicao {
    @Id
    @Column(name = "id_pos")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPos;

    @Column(name = "desc")
    private String desc;

    @Column(name = "lado")
    private String lado;

    @Column(name = "jogador")
    private Boolean jogador;
}
