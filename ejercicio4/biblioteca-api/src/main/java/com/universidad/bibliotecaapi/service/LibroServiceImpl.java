package com.universidad.bibliotecaapi.service;

import com.universidad.bibliotecaapi.model.Libro;
import com.universidad.bibliotecaapi.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService {

    private final LibroRepository libroRepository;

    @Autowired
    public LibroServiceImpl(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public Libro registrarLibro(Libro libro) {
        return libroRepository.guardar(libro);
    }

    @Override
    public List<Libro> obtenerTodos() {
        return libroRepository.buscarTodos();
    }

    @Override
    public Optional<Libro> obtenerPorTitulo(String titulo) {
        return libroRepository.buscarPorTitulo(titulo);
    }

    @Override
    public Optional<Libro> actualizarLibro(Long id, Libro libro) {
        return libroRepository.actualizar(id, libro);
    }

    @Override
    public boolean eliminarLibro(Long id) {
        return libroRepository.eliminar(id);
    }
}