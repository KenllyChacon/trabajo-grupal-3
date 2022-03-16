package ec.edu.uce.repository;

import ec.edu.uce.model.CuentaBancaria;
import ec.edu.uce.model.CuentaHabienteVIPTo;

import java.math.BigDecimal;
import java.util.List;

public interface ICuentaBancariaRepository {

    //CRUD
    void insertarCuentaBancaria(CuentaBancaria CuentaBancaria);
    CuentaBancaria buscarCuentaBancaria(Integer id);
    void actualizarCuentaBancaria(CuentaBancaria CuentaBancaria);
    void borrarCuentaBancaria(Integer id);

    CuentaBancaria buscarCuentaBancariaPorNumeroCuenta(Integer numeroCuenta);
    List<CuentaBancaria> buscarCuentaBancariaPorSaldo(BigDecimal saldo);
}
