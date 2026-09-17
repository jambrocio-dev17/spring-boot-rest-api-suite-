package com.universidad.bibliotecaapi.service;

import com.universidad.bibliotecaapi.model.Libro;

import java.util.List;
import java.util.Optional;

public interface LibroService {
    Libro registrarLibro(Libro libro);
    List<Libro> obtenerTodos();
    Optional<Libro> obtenerPorTitulo(String titulo);
    Optional<Libro> actualizarLibro(Long id, Libro libro);
    boolean eliminarLibro(Long id);
}