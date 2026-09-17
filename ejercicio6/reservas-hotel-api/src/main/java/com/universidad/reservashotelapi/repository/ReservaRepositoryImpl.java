package com.universidad.reservashotelapi.repository;

import com.universidad.reservashotelapi.model.EstadoReserva;
import com.universidad.reservashotelapi.model.Reserva;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ReservaRepositoryImpl implements ReservaRepository {

    private final List<Reserva> reservas = new ArrayList<>();
    private final AtomicLong secuenciaId = new AtomicLong(1);

    @Override
    public Reserva guardar(Reserva reserva) {
        reserva.setId(secuenciaId.getAndIncrement());
        reservas.add(reserva);
        return reserva;
    }

    @Override
    public List<Reserva> buscarTodos() {
        return reservas;
    }

    @Override
    public Optional<Reserva> buscarPorId(Long id) {
        return reservas.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst();
    }

    @Override
    public Optional<Reserva> actualizar(Long id, Reserva reservaActualizada) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getId().equals(id)) {
                reservaActualizada.setId(id);
                reservas.set(i, reservaActualizada);
                return Optional.of(reservaActualizada);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Reserva> cancelar(Long id) {
        for (Reserva r : reservas) {
            if (r.getId().equals(id)) {
                r.setEstado(EstadoReserva.CANCELADA);
                return Optional.of(r);
            }
        }
        return Optional.empty();
    }
}