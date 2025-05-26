package com.example.tienda.repository;


import com.example.tienda.model.tienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface tiendaRepository extends JpaRepository<tienda, Integer> {}
