package ec.edu.uce.service;

import ec.edu.uce.model.CuentaBancaria;
import ec.edu.uce.model.CuentaHabiente;
import ec.edu.uce.model.CuentaHabienteVIPTo;

import java.math.BigDecimal;
import java.util.List;

public interface ICuentaHabienteService {

    //CRUD
    void insertarCuentaHabiente(CuentaHabiente cuentaHabiente);
    CuentaHabiente buscarCuentaHabiente(Integer id);
    void actualizarCuentaHabiente(CuentaHabiente cuentaHabiente);
    void borrarCuentaHabiente(Integer id);

    List<CuentaBancaria> consultarCuentasBancarias(String cedula);
    List<CuentaHabienteVIPTo> reporteCuentaHabientes();


}
