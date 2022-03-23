
import javax.persistence.*;

@Entity
@Table(name = "t_equipas")
public class TEquipas {
    @Id
    @Column(name = "id_equipa")
    private Long idEquipa;

    @Column(name = "nome")
    private String nome;

    @Column(name = "localizacao")
    private String localizacao;

    @Column(name = "golos_marcados")
    private Integer golosMarcados;

    @Column(name = "golos_sofridos")
    private Integer golosSofridos;

    public Long getIdEquipa() {
        return this.idEquipa;
    }

    public void setIdEquipa(Long idEquipa) {
        this.idEquipa = idEquipa;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return this.localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Integer getGolosMarcados() {
        return this.golosMarcados;
    }

    public void setGolosMarcados(Integer golosMarcados) {
        this.golosMarcados = golosMarcados;
    }

    public Integer getGolosSofridos() {
        return this.golosSofridos;
    }

    public void setGolosSofridos(Integer golosSofridos) {
        this.golosSofridos = golosSofridos;
    }
}
