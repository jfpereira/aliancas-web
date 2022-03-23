
import javax.persistence.*;

@Entity
@Table(name = "t_epoca")
public class TEpoca {
    @Id
    @Column(name = "id_epoca")
    private Long idEpoca;

    @Column(name = "data_inicio")
    private java.sql.Date dataInicio;

    @Column(name = "data_fim")
    private java.sql.Date dataFim;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "epoca_curso")
    private java.lang.Byte epocaCurso;

    public Long getIdEpoca() {
        return this.idEpoca;
    }

    public void setIdEpoca(Long idEpoca) {
        this.idEpoca = idEpoca;
    }

    public java.sql.Date getDataInicio() {
        return this.dataInicio;
    }

    public void setDataInicio(java.sql.Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public java.sql.Date getDataFim() {
        return this.dataFim;
    }

    public void setDataFim(java.sql.Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public java.lang.Byte getEpocaCurso() {
        return this.epocaCurso;
    }

    public void setEpocaCurso(java.lang.Byte epocaCurso) {
        this.epocaCurso = epocaCurso;
    }
}
