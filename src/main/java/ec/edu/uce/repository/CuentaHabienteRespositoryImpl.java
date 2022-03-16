package ec.edu.uce.repository;

import ec.edu.uce.model.CuentaBancaria;
import ec.edu.uce.model.CuentaHabiente;
import ec.edu.uce.model.CuentaHabienteVIPTo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Repository
@Transactional
public class CuentaHabienteRespositoryImpl implements ICuentaHabienteRespository{

    private static final Log LOG = LogFactory.getLog(CuentaHabienteRespositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertarCuentaHabiente(CuentaHabiente cuentaHabiente) {
        this.entityManager.persist(cuentaHabiente);
    }

    @Override
    public CuentaHabiente buscarCuentaHabiente(Integer id) {
        return this.entityManager.find(CuentaHabiente.class, id);
    }

    @Override
    public void actualizarCuentaHabiente(CuentaHabiente cuentaHabiente) {
        this.entityManager.merge(cuentaHabiente);
    }

    @Override
    public void borrarCuentaHabiente(Integer id) {
        CuentaHabiente cuentaHabienteBorrar = this.buscarCuentaHabiente(id);
        this.entityManager.remove(cuentaHabienteBorrar);
    }

    @Override
    public List<CuentaBancaria> consultarCuentasBancarias(String cedula) {
        TypedQuery<CuentaBancaria> miTypedQuery =  this.entityManager.createQuery(
        //select * from cuenta_habiente c, cuenta_bancaria b where c.cuha_id = b.cuenta_habiente_cuha_id AND c.cuha_cedula = '1726464686'
        "select b from CuentaHabiente c, CuentaBancaria b where c = b.cuentaHabiente AND c.cedula =: cedula",CuentaBancaria.class);
        miTypedQuery.setParameter("cedula",cedula);

        //Bajo demanda
        List<CuentaBancaria> listaCuentaBancaria = miTypedQuery.getResultList();
        LOG.info("Longitud de la lista de cuentas bancarias es: " + listaCuentaBancaria.size());
        for (CuentaBancaria i: listaCuentaBancaria){
            LOG.info(i.toString());
        }
        return listaCuentaBancaria;
    }

    @Override
    public List<CuentaHabienteVIPTo> reporteCuentaHabientes() {
        TypedQuery<CuentaHabienteVIPTo> miTypedQuery =  this.entityManager.createQuery(
                //select * from cuenta_habiente c, cuenta_bancaria b where c.cuha_id = b.cuenta_habiente_cuha_id AND c.cuha_cedula = '1726464686'
                //String cedula, String nombre, String apellido, String numeroCuenta, String tipo, BigDecimal saldo
                "select new ec.edu.uce.model.CuentaHabienteVIPTo(c.cedula, c.nombre, c.apellido, b.numeroCuenta, b.tipo, b.saldo) from CuentaHabiente c, CuentaBancaria b where c=b.cuentaHabiente", CuentaHabienteVIPTo.class);

        return miTypedQuery.getResultList();
    }

}
