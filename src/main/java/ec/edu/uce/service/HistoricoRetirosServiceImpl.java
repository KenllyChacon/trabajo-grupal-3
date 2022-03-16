package ec.edu.uce.service;

import ec.edu.uce.model.HistoricoRetiros;
import ec.edu.uce.model.ReporteHistoricoTo;
import ec.edu.uce.repository.IHistoricoRetirosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class HistoricoRetirosServiceImpl implements IHistoricoRetirosService{

    @Autowired
    private IHistoricoRetirosRepository historicoRetirosRepository;

    @Override
    public void insertarHistoricoRetiros(HistoricoRetiros historicoRetiros) {
        this.historicoRetirosRepository.insertarHistoricoRetiros(historicoRetiros);
    }

    @Override
    public HistoricoRetiros buscarHistoricoRetiros(Integer id) {
        return this.historicoRetirosRepository.buscarHistoricoRetiros(id);
    }

    @Override
    public void actualizarHistoricoRetiros(HistoricoRetiros historicoRetiros) {
        this.historicoRetirosRepository.actualizarHistoricoRetiros(historicoRetiros);
    }

    @Override
    public void borrarHistoricoRetiros(Integer id) {
        this.historicoRetirosRepository.borrarHistoricoRetiros(id);
    }

    @Override
    public List<ReporteHistoricoTo> buscarTodosHistoricoRetiros() {
        return this.historicoRetirosRepository.buscarTodosHistoricoRetiros();
    }

}
