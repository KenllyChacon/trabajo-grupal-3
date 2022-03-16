package ec.edu.uce.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ReporteHistoricoTo {

    private String cedula;
    private  String nombre;
    private  String apellido;
    private BigDecimal montoRetiro;
    private LocalDateTime fechaRetiro;

    public ReporteHistoricoTo() {
    }

    public ReporteHistoricoTo(String cedula, String nombre, String apellido, BigDecimal montoRetiro, LocalDateTime fechaRetiro) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.montoRetiro = montoRetiro;
        this.fechaRetiro = fechaRetiro;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    @Override
    public String toString() {
        return "ReporteHistoricoTo{" +
                "cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", montoRetiro=" + montoRetiro +
                ", fechaRetiro=" + fechaRetiro +
                '}';
    }

}
