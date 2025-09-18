package cl.cachoza.web001.controller;

import cl.cachoza.web001.dto.InstrumentoDTO;
import cl.cachoza.web001.service.InstrumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instrumentos")
public class InstrumentoController {

    private final InstrumentoService service;

    @Autowired
    public InstrumentoController(InstrumentoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<InstrumentoDTO>> obtenerTodos() {
        List<InstrumentoDTO> instrumentos = service.obtenerTodos();
        return ResponseEntity.ok(instrumentos);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<InstrumentoDTO>> obtenerPorNombre(@PathVariable String nombre) {
        List<InstrumentoDTO> instrumentos = service.obtenerPorNombre(nombre);
        return ResponseEntity.ok(instrumentos);
    }

    @GetMapping("/preguntas/{cantidad}")
    public ResponseEntity<List<InstrumentoDTO>> obtenerPorCantidadPreguntas(@PathVariable Integer cantidad) {
        List<InstrumentoDTO> instrumentos = service.obtenerPorCantidadPreguntas(cantidad);
        return ResponseEntity.ok(instrumentos);
    }

    @GetMapping("/visibilidad/{visible}")
    public ResponseEntity<List<InstrumentoDTO>> obtenerPorVisibilidad(@PathVariable Integer visible) {
        List<InstrumentoDTO> instrumentos = service.obtenerPorVisibilidad(visible);
        return ResponseEntity.ok(instrumentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstrumentoDTO> obtenerPorId(@PathVariable Long id) {
        InstrumentoDTO instrumento = service.obtenerPorId(id);
        return ResponseEntity.ok(instrumento);
    }

    @PostMapping
    public ResponseEntity<InstrumentoDTO> crear(@Validated @RequestBody InstrumentoDTO dto) {
        InstrumentoDTO instrumentoGuardado = service.guardar(dto);
        return new ResponseEntity<>(instrumentoGuardado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InstrumentoDTO> actualizar(@PathVariable Long id, @Validated @RequestBody InstrumentoDTO dto) {
        InstrumentoDTO instrumentoActualizado = service.actualizar(id, dto);
        return ResponseEntity.ok(instrumentoActualizado);
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

    @GetMapping("/existe/nombre/{nombre}")
    public ResponseEntity<Boolean> existePorNombre(@PathVariable String nombre) {
        boolean existe = service.existePorNombre(nombre);
        return ResponseEntity.ok(existe);
    }
}