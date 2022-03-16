package ec.edu.uce.service;

import ec.edu.uce.model.CuentaBancaria;
import ec.edu.uce.model.CuentaHabienteVIPTo;
import ec.edu.uce.repository.ICuentaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ICuentaBancariaServiceImpl implements ICuentaBancariaService{

    @Autowired
    private ICuentaBancariaRepository cuentaBancariaRepository;

    @Override
    public void insertarCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancariaRepository.insertarCuentaBancaria(cuentaBancaria);
    }

    @Override
    public CuentaBancaria buscarCuentaBancaria(Integer id) {
        return this.cuentaBancariaRepository.buscarCuentaBancaria(id);
    }

    @Override
    public void actualizarCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancariaRepository.actualizarCuentaBancaria(cuentaBancaria);
    }

    @Override
    public void borrarCuentaBancaria(Integer id) {
        this.cuentaBancariaRepository.borrarCuentaBancaria(id);
    }

    @Override
    public CuentaBancaria buscarCuentaBancariaPorNumeroCuenta(Integer numeroCuenta) {
        return this.cuentaBancariaRepository.buscarCuentaBancariaPorNumeroCuenta(numeroCuenta);
    }

    @Override
    public List<CuentaBancaria> buscarCuentaBancariaPorSaldo(BigDecimal saldo) {
        return this.cuentaBancariaRepository.buscarCuentaBancariaPorSaldo(saldo);
    }


}
