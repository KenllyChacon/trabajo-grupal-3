package ec.edu.uce.repository;

import ec.edu.uce.model.CuentaHabienteVIPTo;
import ec.edu.uce.model.HistoricoRetiros;
import ec.edu.uce.model.ReporteHistoricoTo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class HistoricoRetirosRepositoryImpl implements IHistoricoRetirosRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertarHistoricoRetiros(HistoricoRetiros historicoRetiros) {
        this.entityManager.persist(historicoRetiros);
        //throw new NullPointerException();
    }

    @Override
    public HistoricoRetiros buscarHistoricoRetiros(Integer id) {
        return this.entityManager.find(HistoricoRetiros.class, id);
    }

    @Override
    public void actualizarHistoricoRetiros(HistoricoRetiros historicoRetiros) {
        this.entityManager.merge(historicoRetiros);
    }

    @Override
    public void borrarHistoricoRetiros(Integer id) {
        HistoricoRetiros historicoRetirosBorrar = this.buscarHistoricoRetiros(id);
        this.entityManager.remove(historicoRetirosBorrar);
    }

    @Override
    public List<ReporteHistoricoTo> buscarTodosHistoricoRetiros() {
        TypedQuery<ReporteHistoricoTo> miTypedQuery =  this.entityManager.createQuery(
                "select new ec.edu.uce.model.ReporteHistoricoTo(h.cedula, h.nombre, h.apellido, c.montoRetiro, c.fechaRetiro) from CuentaHabiente h, HistoricoRetiros c where h=c.cuentaHabiente",ReporteHistoricoTo.class);
        return miTypedQuery.getResultList();
    }

}
