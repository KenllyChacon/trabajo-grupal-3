package ec.edu.uce.service;

import ec.edu.uce.model.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.stream.Stream;

@Service
public class GestorBancoServiceImpl implements IGestorBancoService{

    private static final Log LOG = LogFactory.getLog(GestorBancoServiceImpl.class);

    @Autowired
    private ICuentaHabienteService cuentaHabienteService;

    @Autowired
    private ICuentaBancariaService cuentaBancariaService;

    @Autowired
    private IHistoricoRetirosService historicoRetirosService;

    @Override
    public void insertarCuentaHabiente(CuentaHabiente cuentaHabiente) {
        this.cuentaHabienteService.insertarCuentaHabiente(cuentaHabiente);
    }

    @Override
    @Transactional(value = Transactional.TxType.NOT_SUPPORTED)
    public CuentaBancaria buscarCuentaBancariaPorNumeroCuenta(Integer numeroCuenta) {
        return this.cuentaBancariaService.buscarCuentaBancariaPorNumeroCuenta(numeroCuenta);
    }

    @Override
    @Transactional(value = Transactional.TxType.NOT_SUPPORTED)
    public List<CuentaBancaria> consultarCuentasBancarias(String cedula) {
        return this.cuentaHabienteService.consultarCuentasBancarias(cedula);
    }

    @Override
    @Transactional
    public void retirarDinero(Integer numeroCuenta, BigDecimal valorRetirar) {
        try {
            CuentaBancaria miCuentaBancaria = this.buscarCuentaBancariaPorNumeroCuenta(numeroCuenta);
            miCuentaBancaria.setSaldo(miCuentaBancaria.getSaldo().subtract(valorRetirar));

            this.guardarRegistroHistorico(miCuentaBancaria,valorRetirar);

        }catch (NullPointerException e){
            LOG.info("No se pudo realizar el registro de historico retiros, !REVERSANDO!");
        }

    }

    @Override
    @Transactional(value = Transactional.TxType.NOT_SUPPORTED)
    public BigDecimal consultarSaldo(Integer numeroCuenta) {
        CuentaBancaria miCuentaBancaria = this.buscarCuentaBancariaPorNumeroCuenta(numeroCuenta);
        return miCuentaBancaria.getSaldo();
    }

    @Override
    public void guardarRegistroHistorico(CuentaBancaria miCuentaBancaria, BigDecimal valorRetirar) {
        HistoricoRetiros miHistoricoRetiros = new HistoricoRetiros();
        miHistoricoRetiros.setMontoRetiro(valorRetirar);
        miHistoricoRetiros.setFechaRetiro(LocalDateTime.of(2020, Month.AUGUST, 8, 12, 45));
        miHistoricoRetiros.setCuentaBancaria(miCuentaBancaria);
        miHistoricoRetiros.setCuentaHabiente(miCuentaBancaria.getCuentaHabiente());
        this.historicoRetirosService.insertarHistoricoRetiros(miHistoricoRetiros);
    }

    @Override
    public Stream<CuentaHabienteVIPTo> reporteCuentaHabientes(BigDecimal saldo) {
        List<CuentaHabienteVIPTo> list = this.cuentaHabienteService.reporteCuentaHabientes();
        Stream<CuentaHabienteVIPTo> lista2 = list.stream().filter(valor -> valor.getSaldo().compareTo(saldo) >= 1);
        return lista2;

    }

    @Override
    public Stream<ReporteHistoricoTo> reporteHistoricoRetiros(LocalDateTime fecha, BigDecimal monto) {
        List<ReporteHistoricoTo> listHistoricoRetiros = this.historicoRetirosService.buscarTodosHistoricoRetiros();
        Stream<ReporteHistoricoTo> lista2 =listHistoricoRetiros.stream().filter(m -> m.getFechaRetiro().compareTo(fecha)>=-1 && m.getMontoRetiro().compareTo(monto) <=-1);
        return lista2;
    }


}
