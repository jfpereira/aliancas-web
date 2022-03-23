
import javax.persistence.*;

@Entity
@Table(name = "t_jogo")
public class TJogo {
    @Id
    @Column(name = "id_jogo")
    private Long idJogo;

    @Column(name = "equipa_home")
    private Long equipaHome;

    @Column(name = "equipa_away")
    private Long equipaAway;

    @Column(name = "data_jogo")
    private java.sql.Timestamp dataJogo;

    @Column(name = "golos_home")
    private Integer golosHome;

    @Column(name = "golos_away")
    private Integer golosAway;

    @Column(name = "id_epoca")
    private Long idEpoca;

    public Long getIdJogo() {
        return this.idJogo;
    }

    public void setIdJogo(Long idJogo) {
        this.idJogo = idJogo;
    }

    public Long getEquipaHome() {
        return this.equipaHome;
    }

    public void setEquipaHome(Long equipaHome) {
        this.equipaHome = equipaHome;
    }

    public Long getEquipaAway() {
        return this.equipaAway;
    }

    public void setEquipaAway(Long equipaAway) {
        this.equipaAway = equipaAway;
    }

    public java.sql.Timestamp getDataJogo() {
        return this.dataJogo;
    }

    public void setDataJogo(java.sql.Timestamp dataJogo) {
        this.dataJogo = dataJogo;
    }

    public Integer getGolosHome() {
        return this.golosHome;
    }

    public void setGolosHome(Integer golosHome) {
        this.golosHome = golosHome;
    }

    public Integer getGolosAway() {
        return this.golosAway;
    }

    public void setGolosAway(Integer golosAway) {
        this.golosAway = golosAway;
    }

    public Long getIdEpoca() {
        return this.idEpoca;
    }

    public void setIdEpoca(Long idEpoca) {
        this.idEpoca = idEpoca;
    }
}
