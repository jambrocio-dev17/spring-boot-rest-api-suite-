package com.universidad.bibliotecaapi.repository;

import com.universidad.bibliotecaapi.model.Libro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class LibroRepositoryImpl implements LibroRepository {

    private final List<Libro> libros = new ArrayList<>();
    private final AtomicLong secuenciaId = new AtomicLong(1);

    @Override
    public Libro guardar(Libro libro) {
        libro.setId(secuenciaId.getAndIncrement());
        libros.add(libro);
        return libro;
    }

    @Override
    public List<Libro> buscarTodos() {
        return libros;
    }

    @Override
    public Optional<Libro> buscarPorTitulo(String titulo) {
        return libros.stream()
                .filter(l -> l.getTitulo().equalsIgnoreCase(titulo))
                .findFirst();
    }

    @Override
    public Optional<Libro> actualizar(Long id, Libro libroActualizado) {
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getId().equals(id)) {
                libroActualizado.setId(id);
                libros.set(i, libroActualizado);
                return Optional.of(libroActualizado);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean eliminar(Long id) {
        return libros.removeIf(l -> l.getId().equals(id));
    }
}