package com.universidad.reservashotelapi.repository;

import com.universidad.reservashotelapi.model.Reserva;

import java.util.List;
import java.util.Optional;

public interface ReservaRepository {
    Reserva guardar(Reserva reserva);
    List<Reserva> buscarTodos();
    Optional<Reserva> buscarPorId(Long id);
    Optional<Reserva> actualizar(Long id, Reserva reservaActualizada);
    Optional<Reserva> cancelar(Long id);
}