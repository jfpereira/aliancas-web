package pt.web.al2022.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "t_alianca")
public class Alianca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alianca")
    private Long idAlianca;

    @Column(name = "email")
    private String email;

    @Column(name = "nome")
    private String nome;

    @Column(name = "apelido")
    private String apelido;

    @Column(name = "num")
    private Integer num;

    @Column(name = "data_nasc")
    private Date dataNasc;

    @Column(name = "idade")
    private Integer idade;

    @Column(name = "altura")
    private Integer altura;

    @Column(name = "peso")
    private Integer peso;

    @ManyToOne
    @JoinColumn(name = "id_pos", referencedColumnName = "id_pos")
    private Posicao posicao;

}
