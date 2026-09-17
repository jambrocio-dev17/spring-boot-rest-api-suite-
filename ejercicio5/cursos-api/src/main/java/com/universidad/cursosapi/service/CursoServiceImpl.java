package com.universidad.cursosapi.service;

import com.universidad.cursosapi.model.Curso;
import com.universidad.cursosapi.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;

    @Autowired
    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public Curso crearCurso(Curso curso) {
        return cursoRepository.guardar(curso);
    }

    @Override
    public List<Curso> obtenerTodos() {
        return cursoRepository.buscarTodos();
    }

    @Override
    public Optional<Curso> obtenerPorCodigo(String codigo) {
        return cursoRepository.buscarPorCodigo(codigo);
    }

    @Override
    public Optional<Curso> actualizarCurso(Long id, Curso curso) {
        return cursoRepository.actualizar(id, curso);
    }

    @Override
    public boolean eliminarCurso(Long id) {
        return cursoRepository.eliminar(id);
    }
}