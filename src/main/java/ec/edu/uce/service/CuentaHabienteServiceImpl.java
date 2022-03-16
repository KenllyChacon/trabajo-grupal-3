package ec.edu.uce.service;

import ec.edu.uce.model.CuentaBancaria;
import ec.edu.uce.model.CuentaHabiente;
import ec.edu.uce.model.CuentaHabienteVIPTo;
import ec.edu.uce.repository.ICuentaHabienteRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CuentaHabienteServiceImpl implements ICuentaHabienteService{

    @Autowired
    private ICuentaHabienteRespository cuentaHabienteRespository;

    @Override
    public void insertarCuentaHabiente(CuentaHabiente cuentaHabiente) {
        this.cuentaHabienteRespository.insertarCuentaHabiente(cuentaHabiente);
    }

    @Override
    public CuentaHabiente buscarCuentaHabiente(Integer id) {
        return this.cuentaHabienteRespository.buscarCuentaHabiente(id);
    }

    @Override
    public void actualizarCuentaHabiente(CuentaHabiente cuentaHabiente) {
        this.cuentaHabienteRespository.actualizarCuentaHabiente(cuentaHabiente);
    }

    @Override
    public void borrarCuentaHabiente(Integer id) {
        this.cuentaHabienteRespository.borrarCuentaHabiente(id);
    }

    @Override
    public List<CuentaBancaria> consultarCuentasBancarias(String cedula) {
        return this.cuentaHabienteRespository.consultarCuentasBancarias(cedula);
    }

    @Override
    public List<CuentaHabienteVIPTo> reporteCuentaHabientes() {
        return this.cuentaHabienteRespository.reporteCuentaHabientes();
    }


}
