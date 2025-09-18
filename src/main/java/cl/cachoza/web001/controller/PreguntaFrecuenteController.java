package cl.cachoza.web001.controller;

import cl.cachoza.web001.dto.PreguntaFrecuenteDTO;
import cl.cachoza.web001.service.PreguntaFrecuenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/preguntas-frecuentes")
public class PreguntaFrecuenteController {

    private final PreguntaFrecuenteService service;

    @Autowired
    public PreguntaFrecuenteController(PreguntaFrecuenteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PreguntaFrecuenteDTO>> obtenerTodos() {
        List<PreguntaFrecuenteDTO> preguntas = service.obtenerTodos();
        return ResponseEntity.ok(preguntas);
    }

    @GetMapping("/buscar/{palabrasClaves}")
    public ResponseEntity<List<PreguntaFrecuenteDTO>> obtenerPorPalabrasClaves(@PathVariable String palabrasClaves) {
        List<PreguntaFrecuenteDTO> preguntas = service.obtenerPorPalabrasClaves(palabrasClaves);
        return ResponseEntity.ok(preguntas);
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<PreguntaFrecuenteDTO>> obtenerPorUsuario(@PathVariable Long idUsuario) {
        List<PreguntaFrecuenteDTO> preguntas = service.obtenerPorUsuario(idUsuario);
        return ResponseEntity.ok(preguntas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PreguntaFrecuenteDTO> obtenerPorId(@PathVariable Long id) {
        PreguntaFrecuenteDTO pregunta = service.obtenerPorId(id);
        return ResponseEntity.ok(pregunta);
    }

    @PostMapping
    public ResponseEntity<PreguntaFrecuenteDTO> crear(@Validated @RequestBody PreguntaFrecuenteDTO dto) {
        PreguntaFrecuenteDTO preguntaGuardada = service.guardar(dto);
        return new ResponseEntity<>(preguntaGuardada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PreguntaFrecuenteDTO> actualizar(@PathVariable Long id, @Validated @RequestBody PreguntaFrecuenteDTO dto) {
        PreguntaFrecuenteDTO preguntaActualizada = service.actualizar(id, dto);
        return ResponseEntity.ok(preguntaActualizada);
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

    @GetMapping("/existe/palabras-claves/{palabrasClaves}")
    public ResponseEntity<Boolean> existePorPalabrasClaves(@PathVariable String palabrasClaves) {
        boolean existe = service.existePorPalabrasClaves(palabrasClaves);
        return ResponseEntity.ok(existe);
    }
}