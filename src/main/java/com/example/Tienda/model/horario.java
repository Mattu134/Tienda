package com.example.tienda.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.DayOfWeek;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class horario {
    @Id
    private int id;
    private DayOfWeek dia;
    private LocalTime horaApertura;
    private LocalTime horaCierre;
    @ManyToOne
    @JoinColumn(name = "tienda_id")
    private tienda tienda;
}
