package ec.edu.uce.service;

import ec.edu.uce.model.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

public interface IGestorBancoService {

    void insertarCuentaHabiente(CuentaHabiente cuentaHabiente);
    CuentaBancaria buscarCuentaBancariaPorNumeroCuenta(Integer numeroCuenta);
    List<CuentaBancaria> consultarCuentasBancarias(String cedula);
    void retirarDinero(Integer numeroCuenta, BigDecimal valorRetirar);

    BigDecimal consultarSaldo(Integer numeroCuenta);
    void guardarRegistroHistorico(CuentaBancaria miCuentaBancaria, BigDecimal valorRetirar);
    Stream<CuentaHabienteVIPTo> reporteCuentaHabientes(BigDecimal saldo);
    Stream<ReporteHistoricoTo> reporteHistoricoRetiros(LocalDateTime fecha, BigDecimal monto);

}
