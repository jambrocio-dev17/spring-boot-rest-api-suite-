package com.universidad.bibliotecaapi.repository;

import com.universidad.bibliotecaapi.model.Libro;

import java.util.List;
import java.util.Optional;

public interface LibroRepository {
    Libro guardar(Libro libro);
    List<Libro> buscarTodos();
    Optional<Libro> buscarPorTitulo(String titulo);
    Optional<Libro> actualizar(Long id, Libro libroActualizado);
    boolean eliminar(Long id);
}