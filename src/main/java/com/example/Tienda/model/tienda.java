package com.example.tienda.model;


import lombok.Data;
import lombok.*;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class tienda
{   
    @Id
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
    @OneToMany(mappedBy = "tienda", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<empleado> empleados;
    @OneToMany(mappedBy = "tienda", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<horario> horarios;

}
