package com.example.tienda.controller;

import com.example.tienda.model.tienda;
import com.example.tienda.service.horarioService;
import com.example.tienda.service.tiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/horarios")
public class HorarioController {
    @Autowired
    private horarioService horarioService;
    @GetMapping
    public List<com.example.tienda.model.horario> obtenerTodosLosHorarios() {
        return horarioService.obtenerTodos();
    }
    @PostMapping
    public com.example.tienda.model.horario crearHorario(@RequestBody com.example.tienda.model.horario nuevoHorario) {
        return horarioService.guardarHorario(nuevoHorario);
    }
    @DeleteMapping("/{id}")
    public void eliminarHorario(@PathVariable int id) {
        horarioService.eliminarHorario(id);
    }
    @GetMapping("/tienda/{id}")
    public List<com.example.tienda.model.horario> obtenerHorariosPorTienda(@PathVariable int id) {
        tienda tienda = new tienda();
        tienda.setId(id);
        return horarioService.obtenerHorariosPorTienda(tienda);
    }
    @PostMapping("/tienda/{id}")
    public com.example.tienda.model.horario crearHorarioParaTienda(@PathVariable int id, @RequestBody com.example.tienda.model.horario nuevoHorario) {
        tienda tienda = new tienda();
        tienda.setId(id);
        nuevoHorario.setTienda(tienda);
        return horarioService.guardarHorario(nuevoHorario);
    }
    @DeleteMapping("/tienda/{id}/horario/{horarioId}")
    public void eliminarHorarioDeTienda(@PathVariable int id, @PathVariable int horarioId) {
        tienda tienda = new tienda();
        tienda.setId(id);
        com.example.tienda.model.horario horario = new com.example.tienda.model.horario();
        horario.setId(horarioId);
        horario.setTienda(tienda);
        horarioService.eliminarHorario(horarioId);
    }

}
