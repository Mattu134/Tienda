package com.example.Tienda.repository;

import com.example.Tienda.model.Tienda;
import com.example.Tienda.model.tienda;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;


@Repository
public class tiendaRepository {

    private final ConcurrentHashMap<Long, tienda> tiendas = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong();

    public List<tienda> findAll() {
        return new ArrayList<>(tiendas.values());
    }

    public Optional<tienda> findById(Long id) {
        return Optional.ofNullable(tiendas.get(id));
    }

    public tienda save(tienda tienda) {
        if (tienda.getId() == null) {
            tienda.setId(idCounter.incrementAndGet());
        }
        tiendas.put(tienda.getId(), tienda);
        return tienda;
    }

    public void deleteById(Long id) {
        tiendas.remove(id);
    }

}
