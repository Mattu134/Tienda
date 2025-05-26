package com.example.Tienda.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.DayOfWeek;
import java.time.LocalTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class horario {
    private String id;
    private DayOfWeek dia;
    private LocalTime horaApertura;
    private LocalTime horaCierre;
}
