
import javax.persistence.*;

@Entity
@Table(name = "t_alianca_quota")
public class TAliancaQuota {
    @Id
    @Column(name = "id_alianca")
    private Long idAlianca;

    @Id
    @Column(name = "id_quota")
    private Long idQuota;

    @Column(name = "data_pagamento")
    private java.sql.Timestamp dataPagamento;

    @Column(name = "pago")
    private java.lang.Byte pago;

    public Long getIdAlianca() {
        return this.idAlianca;
    }

    public void setIdAlianca(Long idAlianca) {
        this.idAlianca = idAlianca;
    }

    public Long getIdQuota() {
        return this.idQuota;
    }

    public void setIdQuota(Long idQuota) {
        this.idQuota = idQuota;
    }

    public java.sql.Timestamp getDataPagamento() {
        return this.dataPagamento;
    }

    public void setDataPagamento(java.sql.Timestamp dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public java.lang.Byte getPago() {
        return this.pago;
    }

    public void setPago(java.lang.Byte pago) {
        this.pago = pago;
    }
}
