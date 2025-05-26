package com.example.Tienda.repository;

import com.example.Tienda.model.horario;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
@Repository
public class horarioRepository {

    private final ConcurrentHashMap<Long, horario> horarios = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong();

    public List<horario> findAll() {
        return new ArrayList<>(horarios.values());
    }

    public Optional<horario> findById(Long id) {
        return Optional.ofNullable(horarios.get(id));
    }

    public horario save(horario horario) {
        if (horario.getId() == null) {
            horario.setId(idCounter.incrementAndGet());
        }
        horarios.put(horario.getId(), horario);
        return horario;
    }

    public void deleteById(Long id) {
        horarios.remove(id);
    }

    public List<horario> findByTiendaId(Long tiendaId) {
        return horarios.values().stream()
                .filter(h -> h.getTiendaId().equals(tiendaId))
                .collect(Collectors.toList());
    }

}
