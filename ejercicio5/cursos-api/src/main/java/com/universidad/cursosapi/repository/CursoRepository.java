package com.universidad.cursosapi.repository;

import com.universidad.cursosapi.model.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoRepository {
    Curso guardar(Curso curso);
    List<Curso> buscarTodos();
    Optional<Curso> buscarPorCodigo(String codigo);
    Optional<Curso> actualizar(Long id, Curso cursoActualizado);
    boolean eliminar(Long id);
}