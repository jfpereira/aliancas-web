
import javax.persistence.*;

@Entity
@Table(name = "t_quotas")
public class TQuotas {
    @Id
    @Column(name = "id_quota")
    private Long idQuota;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "data_inicio")
    private java.sql.Date dataInicio;

    @Column(name = "data_fim")
    private java.sql.Date dataFim;

    @Column(name = "valor")
    private Integer valor;

    @Column(name = "id_epoca")
    private Long idEpoca;

    public Long getIdQuota() {
        return this.idQuota;
    }

    public void setIdQuota(Long idQuota) {
        this.idQuota = idQuota;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public Integer getValor() {
        return this.valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Long getIdEpoca() {
        return this.idEpoca;
    }

    public void setIdEpoca(Long idEpoca) {
        this.idEpoca = idEpoca;
    }
}
