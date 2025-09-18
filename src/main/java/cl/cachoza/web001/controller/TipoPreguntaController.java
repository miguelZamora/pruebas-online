package cl.cachoza.web001.controller;

import cl.cachoza.web001.dto.TipoPreguntaDTO;
import cl.cachoza.web001.service.TipoPreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-pregunta")
public class TipoPreguntaController {

    private final TipoPreguntaService service;

    @Autowired
    public TipoPreguntaController(TipoPreguntaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TipoPreguntaDTO>> obtenerTodos() {
        List<TipoPreguntaDTO> tipos = service.obtenerTodos();
        return ResponseEntity.ok(tipos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoPreguntaDTO> obtenerPorId(@PathVariable Long id) {
        TipoPreguntaDTO tipo = service.obtenerPorId(id);
        return ResponseEntity.ok(tipo);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<TipoPreguntaDTO> obtenerPorNombre(@PathVariable String nombre) {
        TipoPreguntaDTO tipo = service.obtenerPorNombre(nombre);
        return ResponseEntity.ok(tipo);
    }

    @PostMapping
    public ResponseEntity<TipoPreguntaDTO> crear(@Validated @RequestBody TipoPreguntaDTO dto) {
        TipoPreguntaDTO tipoGuardado = service.guardar(dto);
        return new ResponseEntity<>(tipoGuardado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoPreguntaDTO> actualizar(@PathVariable Long id, @Validated @RequestBody TipoPreguntaDTO dto) {
        TipoPreguntaDTO tipoActualizado = service.actualizar(id, dto);
        return ResponseEntity.ok(tipoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/existe")
    public ResponseEntity<Boolean> existePorId(@PathVariable Long id) {
        boolean existe = service.existePorId(id);
        return ResponseEntity.ok(existe);
    }

    @GetMapping("/existe/{nombre}")
    public ResponseEntity<Boolean> existePorNombre(@PathVariable String nombre) {
        boolean existe = service.existePorNombre(nombre);
        return ResponseEntity.ok(existe);
    }
}