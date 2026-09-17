package com.universidad.bibliotecaapi.controller;

import com.universidad.bibliotecaapi.model.Libro;
import com.universidad.bibliotecaapi.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroService libroService;

    @Autowired
    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @PostMapping
    public ResponseEntity<Libro> registrarLibro(@RequestBody Libro libro) {
        Libro nuevoLibro = libroService.registrarLibro(libro);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoLibro);
    }

    @GetMapping
    public ResponseEntity<List<Libro>> obtenerLibros() {
        return ResponseEntity.ok(libroService.obtenerTodos());
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<Libro> obtenerLibroPorTitulo(@PathVariable String titulo) {
        Optional<Libro> libro = libroService.obtenerPorTitulo(titulo);
        return libro.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizarLibro(@PathVariable Long id, @RequestBody Libro libro) {
        Optional<Libro> libroActualizado = libroService.actualizarLibro(id, libro);
        return libroActualizado.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Long id) {
        boolean eliminado = libroService.eliminarLibro(id);
        if (eliminado) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}