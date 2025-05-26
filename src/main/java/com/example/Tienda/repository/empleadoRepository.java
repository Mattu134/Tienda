package com.example.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tienda.model.empleado;

import java.util.List;
@Repository
public interface empleadoRepository extends JpaRepository<empleado, Integer> {
    List<empleado> findByTiendaId(int tiendaId);
    List<empleado> findByCargo(String cargo);
    List<empleado> findByNombreContaining(String nombre);
    List<empleado> findByApellidoContaining(String apellido);

    
} 
