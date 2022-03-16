package ec.edu.uce.service;

import ec.edu.uce.model.CuentaBancaria;
import ec.edu.uce.model.CuentaHabienteVIPTo;

import java.math.BigDecimal;
import java.util.List;

public interface ICuentaBancariaService {

    //CRUD
    void insertarCuentaBancaria(CuentaBancaria cuentaBancaria);
    CuentaBancaria buscarCuentaBancaria(Integer id);
    void actualizarCuentaBancaria(CuentaBancaria cuentaBancaria);
    void borrarCuentaBancaria(Integer id);

    CuentaBancaria buscarCuentaBancariaPorNumeroCuenta(Integer numeroCuenta);
    List<CuentaBancaria> buscarCuentaBancariaPorSaldo(BigDecimal saldo);

}
