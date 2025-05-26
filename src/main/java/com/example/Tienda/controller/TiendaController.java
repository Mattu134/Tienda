package com.example.tienda.controller;


import com.example.tienda.model.tienda;
import com.example.tienda.service.tiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tiendas")
public class TiendaController {

    @Autowired
    private tiendaService tiendaService;
    @GetMapping
    public List<tienda> obtenerTodasLasTiendas(){
        return tiendaService.obtenerTodas();
    }

    @PostMapping
    public tienda creaTienda(@RequestBody tienda nuevaTienda) {
        return tiendaService.guardarTienda(nuevaTienda);
    }
    @DeleteMapping("/{id}")
    public void eliminarTienda(@PathVariable int id) {
        tiendaService.eliminarTienda(id);
    }

}
