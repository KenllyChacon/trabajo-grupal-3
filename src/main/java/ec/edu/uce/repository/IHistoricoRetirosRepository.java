package ec.edu.uce.repository;

import ec.edu.uce.model.HistoricoRetiros;
import ec.edu.uce.model.ReporteHistoricoTo;

import java.util.List;

public interface IHistoricoRetirosRepository {

    //CRUD
    void insertarHistoricoRetiros(HistoricoRetiros historicoRetiros);
    HistoricoRetiros buscarHistoricoRetiros(Integer id);
    void actualizarHistoricoRetiros(HistoricoRetiros historicoRetiros);
    void borrarHistoricoRetiros(Integer id);

    List<ReporteHistoricoTo> buscarTodosHistoricoRetiros();

}
