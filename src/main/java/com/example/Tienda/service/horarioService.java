package com.example.tienda.service;

import com.example.tienda.model.horario;
import com.example.tienda.model.tienda;
import com.example.tienda.repository.horarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class horarioService {
    @Autowired
    private horarioRepository horarioRepository;

    public List<horario>obtenerTodos(){
        return horarioRepository.findAll();
    }
    public horario guardarHorario(horario nuevoHorario){
        if(horarioRepository.existsById(nuevoHorario.getId())){
            throw new RuntimeException("ya existe un horario con el ID: " + nuevoHorario.getId());
        }
        return horarioRepository.save(nuevoHorario);
    }
    public void eliminarHorario(int id){
        horarioRepository.deleteById(id);
    }
    public List<horario> obtenerHorariosPorTienda(tienda tienda){
        return horarioRepository.findByTiendaId(tienda.getId());
    }
    

}
