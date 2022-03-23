
import javax.persistence.*;

@Entity
@Table(name = "t_utilisador_jogo")
public class TUtilisadorJogo {
    @Id
    @Column(name = "id_alianca")
    private Long idAlianca;

    @Id
    @Column(name = "id_jogo")
    private Long idJogo;

    @Column(name = "golo")
    private Integer golo;

    public Long getIdAlianca() {
        return this.idAlianca;
    }

    public void setIdAlianca(Long idAlianca) {
        this.idAlianca = idAlianca;
    }

    public Long getIdJogo() {
        return this.idJogo;
    }

    public void setIdJogo(Long idJogo) {
        this.idJogo = idJogo;
    }

    public Integer getGolo() {
        return this.golo;
    }

    public void setGolo(Integer golo) {
        this.golo = golo;
    }
}
