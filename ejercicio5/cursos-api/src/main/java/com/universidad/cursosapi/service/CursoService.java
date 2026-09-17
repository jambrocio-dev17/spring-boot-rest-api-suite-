package com.universidad.cursosapi.service;

import com.universidad.cursosapi.model.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService {
    Curso crearCurso(Curso curso);
    List<Curso> obtenerTodos();
    Optional<Curso> obtenerPorCodigo(String codigo);
    Optional<Curso> actualizarCurso(Long id, Curso curso);
    boolean eliminarCurso(Long id);
}