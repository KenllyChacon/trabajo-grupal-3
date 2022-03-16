package ec.edu.uce.service;

import ec.edu.uce.model.CuentaHabienteVIPTo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Rollback
class GestorBancoServiceImplTest {

    @Autowired
    IGestorBancoService gestor;

    @Test
    void retirarDinero() {
        //assertEquals: comparar valores
        //assertNotNull: para saber si la buscaquea no es NULA
        assertNotNull(this.gestor.buscarCuentaBancariaPorNumeroCuenta(1000002).getSaldo());
        BigDecimal correcto =this.gestor.buscarCuentaBancariaPorNumeroCuenta(1000002).getSaldo();
        BigDecimal valorRetiro = new BigDecimal(10.00);
        this.gestor.retirarDinero(1000002,valorRetiro);

        assertEquals(correcto.subtract(valorRetiro),this.gestor.buscarCuentaBancariaPorNumeroCuenta(1000002).getSaldo());
    }

    /*@Test
    void retirarDineroError() {
        //assertEquals: comparar valores
        BigDecimal correcto = this.gestor.buscarCuentaBancariaPorNumeroCuenta(1000002).getSaldo();
        BigDecimal valorRetiro = new BigDecimal(10.00);
        this.gestor.retirarDinero(1000002,valorRetiro);

        assertEquals(correcto,this.gestor.buscarCuentaBancariaPorNumeroCuenta(1000002).getSaldo());
    }*/

    @Test
    void consultarSaldo() {
        //isEqualTo: Comparar valores
        assertThat(this.gestor.consultarSaldo(1000003)).isEqualTo(new BigDecimal("200.00"));
    }

    /*@Test
    void consultarSaldoError() {
        //isEqualTo: Comparar valores
        assertThat(this.gestor.consultarSaldo(1000003)).isEqualTo(200.00);
    }*/

    @Test
    void reporteCuentaHabientes() {
        //Para saber si NO es Nulo
        assertNotNull(this.gestor.reporteCuentaHabientes(new BigDecimal(500.00)));
    }

   /* @Test
    void reporteCuentaHabientesError() {
        //Para saber que SI es Nulo
        assertNull(this.gestor.reporteCuentaHabientes(new BigDecimal(500.00)));
    }*/

    @Test
    void reporteCuentaHabientesPrueba() {
        //Para saber si falso
        Stream<CuentaHabienteVIPTo> s = this.gestor.reporteCuentaHabientes(new BigDecimal(500.00));
        assertFalse(s.anyMatch(cuentaHabienteVIPTo -> cuentaHabienteVIPTo.getSaldo().compareTo(new BigDecimal(700.00))<-1));
    }

   /* @Test
    void reporteCuentaHabientesPruebaError() {
        //Para saber si falso
        Stream<CuentaHabienteVIPTo> s = this.gestor.reporteCuentaHabientes(new BigDecimal(500.00));
        assertFalse(s.anyMatch(cuentaHabienteVIPTo -> cuentaHabienteVIPTo.getSaldo().compareTo(new BigDecimal(700.00))<1));
    }*/

    @Test
    void reporteHistoricoRetiros() {
        //isGreaterThan devuelve booleano > es menor
        assertThat(this.gestor.reporteHistoricoRetiros(LocalDateTime.of(1991, Month.AUGUST, 8, 12, 45),
                new BigDecimal(25)).count()).isGreaterThan(8);
    }

    /*@Test
    void reporteHistoricoRetirosError() {
        //isGreaterThan devuelve booleano > es menor
        assertThat(this.gestor.reporteHistoricoRetiros(LocalDateTime.of(1991, Month.AUGUST, 8, 12, 45),
                new BigDecimal(25)).count()).isGreaterThan(20);
    }*/

    @Test
    void buscarCuentaBancariaPorNumeroCuenta() {
        //Si no es Nulo
        assertThat(this.gestor.buscarCuentaBancariaPorNumeroCuenta(1000003).getSaldo()).isNotNull();

    }

   /* @Test
    void buscarCuentaBancariaPorNumeroCuentaError() {
        //Si es Nulo
        assertThat(this.gestor.buscarCuentaBancariaPorNumeroCuenta(1000003).getSaldo()).isNull();
    }*/

    @Test
    void consultarCuentasBancarias() {
        //Para saber si es una lista
        assertThat(this.gestor.consultarCuentasBancarias("1726464686")).asList();
    }

  /*  @Test
    void consultarCuentasBancariasError() {
        //Para saber si es una lista
        assertThat(this.gestor.consultarCuentasBancarias("1726464686").size()).asList();
    }*/

}