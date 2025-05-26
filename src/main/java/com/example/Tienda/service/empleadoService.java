package com.example.tienda.service;

import com.example.tienda.model.empleado;
import com.example.tienda.repository.empleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class empleadoService {
    @Autowired
    private empleadoRepository empleadoRepository;

    public List<empleado> obtenerTodos(){
        return empleadoRepository.findAll();
    }
    public empleado guardarEmpleado(empleado nuevoEmpleado){
        if(empleadoRepository.existsById(nuevoEmpleado.getId())){
            throw new RuntimeException("ya existe un empleado con el ID: " + nuevoEmpleado.getId());
        }
        return empleadoRepository.save(nuevoEmpleado);
    }
    public void eliminarEmpleado(int id){
        empleadoRepository.deleteById(id);
    }
    

}
