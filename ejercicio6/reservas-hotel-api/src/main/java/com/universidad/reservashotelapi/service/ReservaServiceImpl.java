package com.universidad.reservashotelapi.service;

import com.universidad.reservashotelapi.model.Reserva;
import com.universidad.reservashotelapi.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepository;

    @Autowired
    public ReservaServiceImpl(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @Override
    public Reserva crearReserva(Reserva reserva) {
        return reservaRepository.guardar(reserva);
    }

    @Override
    public List<Reserva> obtenerTodas() {
        return reservaRepository.buscarTodos();
    }

    @Override
    public Optional<Reserva> obtenerPorId(Long id) {
        return reservaRepository.buscarPorId(id);
    }

    @Override
    public Optional<Reserva> actualizarReserva(Long id, Reserva reserva) {
        return reservaRepository.actualizar(id, reserva);
    }

    @Override
    public Optional<Reserva> cancelarReserva(Long id) {
        return reservaRepository.cancelar(id);
    }
}