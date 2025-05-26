package com.example.tienda.controller;


import com.example.tienda.model.empleado;
import com.example.tienda.service.empleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/empleados")
public class EmpleadoController {

    @Autowired
    private empleadoService empleadoService;
    @GetMapping
    public List<empleado> obtenerTodosLosEmpleados(){
        return empleadoService.obtenerTodos();
    }
    @PostMapping
    public empleado crearEmpleado(@RequestBody empleado nuevoEmpleado) {
        return empleadoService.guardarEmpleado(nuevoEmpleado);
    }
    @DeleteMapping("/{id}")
    public void eliminarEmpleado(@PathVariable int id) {
        empleadoService.eliminarEmpleado(id);
    }
    
}
