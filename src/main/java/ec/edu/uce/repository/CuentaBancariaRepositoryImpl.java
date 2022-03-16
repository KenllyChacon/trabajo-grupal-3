package ec.edu.uce.repository;

import ec.edu.uce.model.CuentaBancaria;
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
public class CuentaBancariaRepositoryImpl implements ICuentaBancariaRepository{

    private static final Log LOG = LogFactory.getLog(CuentaBancariaRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertarCuentaBancaria(CuentaBancaria CuentaBancaria) {
        this.entityManager.persist(CuentaBancaria);
    }

    @Override
    public CuentaBancaria buscarCuentaBancaria(Integer id) {
        return this.entityManager.find(CuentaBancaria.class, id);
    }

    @Override
    public void actualizarCuentaBancaria(CuentaBancaria CuentaBancaria) {
        this.entityManager.merge(CuentaBancaria);
    }

    @Override
    public void borrarCuentaBancaria(Integer id) {
        CuentaBancaria cuentaBancariaBorrar = this.buscarCuentaBancaria(id);
        this.entityManager.remove(cuentaBancariaBorrar);
    }

    @Override
    public CuentaBancaria buscarCuentaBancariaPorNumeroCuenta(Integer numeroCuenta) {
        TypedQuery<CuentaBancaria> miTypedQuery =  this.entityManager.createQuery(
                "select c from CuentaBancaria c where c.numeroCuenta =:numeroCuenta",CuentaBancaria.class);
        miTypedQuery.setParameter("numeroCuenta",numeroCuenta);
        return miTypedQuery.getSingleResult();
    }

    @Override
    public List<CuentaBancaria> buscarCuentaBancariaPorSaldo(BigDecimal saldo) {
        TypedQuery<CuentaBancaria> miTypedQuery =  this.entityManager.createQuery("select c from CuentaBancaria c where c.saldo <=: saldo",CuentaBancaria.class);
        miTypedQuery.setParameter("saldo",saldo);

        //Bajo demanda
        List<CuentaBancaria> listaCuentaBancaria = miTypedQuery.getResultList();
        LOG.info("Longitud de la lista de CuentaBancaria es: " + listaCuentaBancaria.size());
        for (CuentaBancaria i: listaCuentaBancaria){
        LOG.info(i.toString());
        }
        return listaCuentaBancaria;

    }


}
