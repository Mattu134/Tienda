package com.example.Tienda.repository;

import com.example.Tienda.model.empleado;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class empleadoRepository {

    private final ConcurrentHashMap<String, empleado> empleados = new ConcurrentHashMap<>();
    private final AtomicLong contadorId = new AtomicLong();

    public List<empleado> buscarTodos() {
        return new ArrayList<>(empleados.values());
    }

    public Optional<empleado> buscarPorId(String id) {
        return Optional.ofNullable(empleados.get(id));
    }

    public empleado guardar(empleado empleado) {
        if (empleado.getId() == null || empleado.getId().isEmpty()) {
            empleado.setId(String.valueOf(contadorId.incrementAndGet()));
        }
        empleados.put(empleado.getId(), empleado);
        return empleado;
    }

    public void eliminarPorId(String id) {
        empleados.remove(id);
    }

    public List<empleado> buscarPorIdTienda(String idTienda) {
        return empleados.values().stream()
                .filter(empleado -> idTienda.equals(empleado.getIdTienda()))
                .collect(Collectors.toList());
    }
}