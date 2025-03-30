package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
@RestController
@RequestMapping("/api/prendas")
@CrossOrigin
public class ClosetApiApplication {

    private List<Prenda> prendas = new ArrayList<>();
    private AtomicLong contadorId = new AtomicLong();

    public static void main(String[] args) {
        SpringApplication.run(ClosetApiApplication.class, args);
    }

    @GetMapping
    public List<Prenda> listar() {
        return prendas;
    }

    @PostMapping
    public Prenda crear(@RequestBody Prenda nueva) {
        nueva.setId(contadorId.incrementAndGet());
        prendas.add(nueva);
        return nueva;
    }

    @PutMapping("/{id}")
    public Prenda actualizar(@PathVariable Long id, @RequestBody Prenda actualizada) {
        for (Prenda p : prendas) {
            if (p.getId().equals(id)) {
                p.setNombre(actualizada.getNombre());
                p.setTipo(actualizada.getTipo());
                p.setTemporada(actualizada.getTemporada());
                return p;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Long id) {
        prendas.removeIf(p -> p.getId().equals(id));
    }

    // Clase interna (modelo)
    static class Prenda {
        private Long id;
        private String nombre;
        private String tipo;
        private String temporada;

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }

        public String getTipo() { return tipo; }
        public void setTipo(String tipo) { this.tipo = tipo; }

        public String getTemporada() { return temporada; }
        public void setTemporada(String temporada) { this.temporada = temporada; }
    }
}
