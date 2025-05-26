package com.example.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tienda.model.horario;

import java.util.List;
@Repository
public interface horarioRepository extends JpaRepository<horario, Integer> {
    List<horario> findByTiendaId(int tiendaId);
    List<horario> findByDia(String dia);
    List<horario> findByHoraAperturaBetween(String horaInicio, String horaFin);
    List<horario> findByHoraCierreBetween(String horaInicio, String horaFin);

    
} 
