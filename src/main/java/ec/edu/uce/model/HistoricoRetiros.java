package ec.edu.uce.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "historico_retiros")
public class HistoricoRetiros {

    @Id
    @Column(name = "hire_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_hire_id")
    @SequenceGenerator(name= "sec_hire_id", sequenceName = "sec_hire_id", allocationSize = 1)
    private Integer id;

    @Column(name = "hire_monto_retiro")
    private BigDecimal montoRetiro;

    @Column(name = "hire_fecha_retiro")
    private LocalDateTime fechaRetiro;

    @ManyToOne
    @JoinColumn(name = "cuenta_habiente_cuha_id")
    private CuentaHabiente cuentaHabiente;

    @ManyToOne
    @JoinColumn(name = "cuenta_bancaria_cuba_id")
    private CuentaBancaria cuentaBancaria;

    //Metodos get y set
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getMontoRetiro() {
        return montoRetiro;
    }

    public void setMontoRetiro(BigDecimal montoRetiro) {
        this.montoRetiro = montoRetiro;
    }

    public LocalDateTime getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(LocalDateTime fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    public CuentaHabiente getCuentaHabiente() {
        return cuentaHabiente;
    }

    public void setCuentaHabiente(CuentaHabiente cuentaHabiente) {
        this.cuentaHabiente = cuentaHabiente;
    }

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    @Override
    public String toString() {
        return "HistoricoRetiros{" +
                "id=" + id +
                ", montoRetiro=" + montoRetiro +
                ", fechaRetiro=" + fechaRetiro +
                '}';
    }
}

