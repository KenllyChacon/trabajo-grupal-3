package ec.edu.uce;

import ec.edu.uce.model.CuentaBancaria;
import ec.edu.uce.model.CuentaHabiente;
import ec.edu.uce.service.IGestorBancoService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@SpringBootApplication
public class SeisApplication implements CommandLineRunner {

    @Autowired
    private IGestorBancoService gestorBancoService;

    private static final Log LOG = LogFactory.getLog(SeisApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SeisApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//----------------------------------------------------------------------------------------------------------------------
      /*  //Insertar 2 Cuenta Habientes con una Cuenta Bancaria cada uno
        CuentaHabiente miCuentaHabiente = new CuentaHabiente();
        miCuentaHabiente.setNombre("Kenlly");
        miCuentaHabiente.setApellido("Chacon");
        miCuentaHabiente.setCedula("1725646549");

        CuentaBancaria miCuentaBancaria = new CuentaBancaria();
        miCuentaBancaria.setNumeroCuenta(1000001);
        miCuentaBancaria.setSaldo(new BigDecimal(500.0));
        miCuentaBancaria.setTipo("Ahorros");

        List<CuentaBancaria> listCuentaBancaria = new ArrayList<>();
        listCuentaBancaria.add(miCuentaBancaria);

        miCuentaHabiente.setCuentasBancarias(listCuentaBancaria);
        miCuentaBancaria.setCuentaHabiente(miCuentaHabiente);

        this.gestorBancoService.insertarCuentaHabiente(miCuentaHabiente);

        CuentaHabiente miCuentaHabiente2 = new CuentaHabiente();
        miCuentaHabiente2.setNombre("Fabiana");
        miCuentaHabiente2.setApellido("Jaramillo");
        miCuentaHabiente2.setCedula("1726464686");

        CuentaBancaria miCuentaBancaria2 = new CuentaBancaria();
        miCuentaBancaria2.setNumeroCuenta(1000002);
        miCuentaBancaria2.setSaldo(new BigDecimal(750.0));
        miCuentaBancaria2.setTipo("Corriente");

        CuentaBancaria miCuentaBancaria3 = new CuentaBancaria();
        miCuentaBancaria3.setNumeroCuenta(1000003);
        miCuentaBancaria3.setSaldo(new BigDecimal(250.0));
        miCuentaBancaria3.setTipo("Ahorros");

        List<CuentaBancaria> listCuentaBancaria2 = new ArrayList<>();
        listCuentaBancaria2.add(miCuentaBancaria3);
        listCuentaBancaria2.add(miCuentaBancaria2);

        miCuentaHabiente2.setCuentasBancarias(listCuentaBancaria2);
        miCuentaBancaria2.setCuentaHabiente(miCuentaHabiente2);
        miCuentaBancaria3.setCuentaHabiente(miCuentaHabiente2);

        this.gestorBancoService.insertarCuentaHabiente(miCuentaHabiente2);*/

//----------------------------------------------------------------------------------------------------------------------
        //Consultar cuentas bancarias que tiene una cuenta habiente
        //this.gestorBancoService.consultarCuentasBancarias("1725646549");

//----------------------------------------------------------------------------------------------------------------------
        //Retiro de dinero
        //this.gestorBancoService.retirarDinero(1000002, new BigDecimal(10.00));

//----------------------------------------------------------------------------------------------------------------------
        //Consultar saldo
        //LOG.info("El saldo de la cuenta ingresada es: " + this.gestorBancoService.consultarSaldo(1000003));

//----------------------------------------------------------------------------------------------------------------------
        //1.Reporte de cuenta habientes
        //this.gestorBancoService.reporteCuentaHabientes(new BigDecimal(500.00)).forEach(System.out::println);

//----------------------------------------------------------------------------------------------------------------------
        //2.Reporte de histórico de retiros
        //this.gestorBancoService.reporteHistoricoRetiros(LocalDateTime.of(1991, Month.AUGUST, 8, 12, 45),
          //      new BigDecimal(25)).forEach(System.out::println);

//----------------------------------------------------------------------------------------------------------------------

    }

}
