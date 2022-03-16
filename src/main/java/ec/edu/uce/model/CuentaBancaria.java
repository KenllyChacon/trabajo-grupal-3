package ec.edu.uce.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "cuenta_bancaria")
public class CuentaBancaria {
    
    @Id
    @Column(name = "cuba_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_cuba_id")
    @SequenceGenerator(name= "sec_cuba_id", sequenceName = "sec_cuba_id", allocationSize = 1)
    private Integer id;

    @Column(name = "cuba_numero_cuenta")
    private Integer numeroCuenta;

    @Column(name = "cuba_saldo")
    private BigDecimal saldo;

    @Column(name = "cuba_tipo")
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "cuenta_habiente_cuha_id")
    private CuentaHabiente cuentaHabiente;

    @OneToMany(mappedBy = "cuentaBancaria", cascade = CascadeType.ALL)
    private List<HistoricoRetiros> historicoRetiros;

    //Metodos get y set
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Integer numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public CuentaHabiente getCuentaHabiente() {
        return cuentaHabiente;
    }

    public void setCuentaHabiente(CuentaHabiente cuentaHabiente) {
        this.cuentaHabiente = cuentaHabiente;
    }

    public List<HistoricoRetiros> getHistoricoRetiros() {
        return historicoRetiros;
    }

    public void setHistoricoRetiros(List<HistoricoRetiros> historicoRetiros) {
        this.historicoRetiros = historicoRetiros;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "id=" + id +
                ", numeroCuenta=" + numeroCuenta +
                ", saldo=" + saldo +
                ", tipo='" + tipo + '\'' +
                ", historicoRetiros=" + historicoRetiros +
                '}';
    }
}
