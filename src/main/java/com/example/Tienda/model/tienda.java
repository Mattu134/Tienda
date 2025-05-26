package com.example.Tienda.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class tienda 
 {   private String id;
    private String nombre;
    private String direccion;
    private String telefono;
    private List<empleado> empleados;
    private List<horario> horarios;

}
