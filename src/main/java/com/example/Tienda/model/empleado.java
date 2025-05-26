package com.example.Tienda.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class empleado {
    private String id;
    private String nombre;
    private String apellido;
    private String cargo;
    private String telefono;
    private String email;
    private String tiendaId; 
}
