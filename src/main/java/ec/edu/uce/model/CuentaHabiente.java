package ec.edu.uce.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cuenta_habiente")
public class CuentaHabiente {

    @Id
    @Column(name = "cuha_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_cuha_id")
    @SequenceGenerator(name= "sec_cuha_id", sequenceName = "sec_cuha_id", allocationSize = 1)
    private Integer id;

    @Column(name = "cuha_nombre")
    private String nombre;

    @Column(name = "cuha_apellido")
    private String apellido;

    @Column(name = "cuha_cedula")
    private String cedula;

    @OneToMany(mappedBy = "cuentaHabiente", cascade = CascadeType.ALL)
    private List<CuentaBancaria> cuentasBancarias;

    @OneToMany(mappedBy = "cuentaHabiente", cascade = CascadeType.ALL)
    private List<HistoricoRetiros> historicosRetiros;

    //Metodos get y set
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public List<CuentaBancaria> getCuentasBancarias() {
        return cuentasBancarias;
    }

    public void setCuentasBancarias(List<CuentaBancaria> cuentasBancarias) {
        this.cuentasBancarias = cuentasBancarias;
    }

    public List<HistoricoRetiros> getHistoricosRetiros() {
        return historicosRetiros;
    }

    public void setHistoricosRetiros(List<HistoricoRetiros> historicosRetiros) {
        this.historicosRetiros = historicosRetiros;
    }

    @Override
    public String toString() {
        return "CuentaHabiente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cedula='" + cedula + '\'' +
                '}';
    }
}
