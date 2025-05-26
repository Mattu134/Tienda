package com.example.tienda.service;

import com.example.tienda.model.tienda;
import com.example.tienda.repository.tiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class tiendaService {

    @Autowired
    private tiendaRepository tiendaRepository;

    public List<tienda> obtenerTodas(){
        return tiendaRepository.findAll();
    }

    public tienda guardarTienda(tienda nuevaTienda){
        if(tiendaRepository.existsById(nuevaTienda.getId())){
            throw new RuntimeException("ya existe una tienda con el ID: " + nuevaTienda.getId());
        }
        return tiendaRepository.save(nuevaTienda);
    }
    public void eliminarTienda(int id){
        tiendaRepository.deleteById(id);
    }

}
