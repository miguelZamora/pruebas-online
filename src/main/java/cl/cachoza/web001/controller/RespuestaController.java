package cl.cachoza.web001.controller;

import cl.cachoza.web001.dto.RespuestaDTO;
import cl.cachoza.web001.service.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/respuestas")
public class RespuestaController {

    private final RespuestaService service;

    @Autowired
    public RespuestaController(RespuestaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<RespuestaDTO>> obtenerTodos() {
        List<RespuestaDTO> respuestas = service.obtenerTodos();
        return ResponseEntity.ok(respuestas);
    }

    @GetMapping("/pregunta/{preguntaId}")
    public ResponseEntity<List<RespuestaDTO>> obtenerPorPregunta(@PathVariable Long preguntaId) {
        List<RespuestaDTO> respuestas = service.obtenerPorPregunta(preguntaId);
        return ResponseEntity.ok(respuestas);
    }

    @GetMapping("/buscar/{contenido}")
    public ResponseEntity<List<RespuestaDTO>> obtenerPorContenido(@PathVariable String contenido) {
        List<RespuestaDTO> respuestas = service.obtenerPorRespuestaContenido(contenido);
        return ResponseEntity.ok(respuestas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespuestaDTO> obtenerPorId(@PathVariable Long id) {
        RespuestaDTO respuesta = service.obtenerPorId(id);
        return ResponseEntity.ok(respuesta);
    }

    @PostMapping
    public ResponseEntity<RespuestaDTO> crear(@Validated @RequestBody RespuestaDTO dto) {
        RespuestaDTO respuestaGuardada = service.guardar(dto);
        return new ResponseEntity<>(respuestaGuardada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RespuestaDTO> actualizar(@PathVariable Long id, @Validated @RequestBody RespuestaDTO dto) {
        RespuestaDTO respuestaActualizada = service.actualizar(id, dto);
        return ResponseEntity.ok(respuestaActualizada);
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

    @GetMapping("/existe/pregunta/{preguntaId}/respuesta/{respuesta}")
    public ResponseEntity<Boolean> existePorPreguntaYRespuesta(
            @PathVariable Long preguntaId, 
            @PathVariable String respuesta) {
        boolean existe = service.existePorPreguntaYRespuesta(preguntaId, respuesta);
        return ResponseEntity.ok(existe);
    }

    @GetMapping("/contar/pregunta/{preguntaId}")
    public ResponseEntity<Long> contarPorPregunta(@PathVariable Long preguntaId) {
        long count = service.contarPorPregunta(preguntaId);
        return ResponseEntity.ok(count);
    }
}