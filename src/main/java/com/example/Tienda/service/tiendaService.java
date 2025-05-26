package com.example.Tienda.service;

import com.example.Tienda.model.tienda;
import com.example.Tienda.model.horario;
import com.example.Tienda.model.empleado;
import com.example.Tienda.repository.tiendaRepository;
import com.example.Tienda.repository.horarioRepository;
import com.example.Tienda.repository.empleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class tiendaService {
    private final tiendaRepository tiendaRepository;
    private final horarioRepository horarioRepository;
    private final empleadoRepository empleadoRepository;
    @Autowired
    public tiendaService(tiendaRepository tiendaRepository, horarioRepository horarioRepository, empleadoRepository empleadoRepository) {
        this.tiendaRepository = tiendaRepository;
        this.horarioRepository = horarioRepository;
        this.empleadoRepository = empleadoRepository;
    }
    public List<tienda> buscarTodas() {
        return tiendaRepository.findAll();
    }
    public Optional<tienda> buscarPorId(Long id) {
        return tiendaRepository.findById(id);
    }
    public tienda guardar(tienda tienda) {
        return tiendaRepository.save(tienda);
    }
    public void eliminarPorId(Long id) {
        tiendaRepository.deleteById(id);
    }
    public List<horario> buscarHorariosPorTiendaId(Long tiendaId) {
        return horarioRepository.findByTiendaId(tiendaId);
    }
    public List<empleado> buscarEmpleadosPorTiendaId(String idTienda) {
        return empleadoRepository.buscarPorIdTienda(idTienda);
    }
    public horario guardarHorario(horario horario) {
        return horarioRepository.save(horario);
    }   

}
