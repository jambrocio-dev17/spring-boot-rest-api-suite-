package com.universidad.reservashotelapi.service;

import com.universidad.reservashotelapi.model.Reserva;

import java.util.List;
import java.util.Optional;

public interface ReservaService {
    Reserva crearReserva(Reserva reserva);
    List<Reserva> obtenerTodas();
    Optional<Reserva> obtenerPorId(Long id);
    Optional<Reserva> actualizarReserva(Long id, Reserva reserva);
    Optional<Reserva> cancelarReserva(Long id);
}