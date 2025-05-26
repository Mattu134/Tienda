package com.example.tienda.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class empleado {
    @Id
    private int id;
    private String nombre;
    private String apellido;
    private String cargo;
    private String telefono;
    private String email;
    
    @ManyToOne
    @JoinColumn(name = "tienda_id")
    private tienda tienda;
}
