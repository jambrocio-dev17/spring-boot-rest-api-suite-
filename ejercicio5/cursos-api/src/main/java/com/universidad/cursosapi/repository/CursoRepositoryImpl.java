package com.universidad.cursosapi.repository;

import com.universidad.cursosapi.model.Curso;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CursoRepositoryImpl implements CursoRepository {

    private final List<Curso> cursos = new ArrayList<>();
    private final AtomicLong secuenciaId = new AtomicLong(1);

    @Override
    public Curso guardar(Curso curso) {
        curso.setId(secuenciaId.getAndIncrement());
        cursos.add(curso);
        return curso;
    }

    @Override
    public List<Curso> buscarTodos() {
        return cursos;
    }

    @Override
    public Optional<Curso> buscarPorCodigo(String codigo) {
        return cursos.stream()
                .filter(c -> c.getCodigo().equalsIgnoreCase(codigo))
                .findFirst();
    }

    @Override
    public Optional<Curso> actualizar(Long id, Curso cursoActualizado) {
        for (int i = 0; i < cursos.size(); i++) {
            if (cursos.get(i).getId().equals(id)) {
                cursoActualizado.setId(id);
                cursos.set(i, cursoActualizado);
                return Optional.of(cursoActualizado);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean eliminar(Long id) {
        return cursos.removeIf(c -> c.getId().equals(id));
    }
}