package cl.cachoza.web001.controller;

import cl.cachoza.web001.dto.RespuestaAlumnoDTO;
import cl.cachoza.web001.service.RespuestaAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/respuestas-alumno")
public class RespuestaAlumnoController {

    private final RespuestaAlumnoService service;

    @Autowired
    public RespuestaAlumnoController(RespuestaAlumnoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<RespuestaAlumnoDTO>> obtenerTodos() {
        List<RespuestaAlumnoDTO> respuestas = service.obtenerTodos();
        return ResponseEntity.ok(respuestas);
    }

    @GetMapping("/responde/{respondeId}")
    public ResponseEntity<List<RespuestaAlumnoDTO>> obtenerPorRespondeId(@PathVariable Integer respondeId) {
        List<RespuestaAlumnoDTO> respuestas = service.obtenerPorRespondeId(respondeId);
        return ResponseEntity.ok(respuestas);
    }

    @GetMapping("/pregunta/{preguntaId}")
    public ResponseEntity<List<RespuestaAlumnoDTO>> obtenerPorPreguntaId(@PathVariable Integer preguntaId) {
        List<RespuestaAlumnoDTO> respuestas = service.obtenerPorPreguntaId(preguntaId);
        return ResponseEntity.ok(respuestas);
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<RespuestaAlumnoDTO>> obtenerPorTipo(@PathVariable String tipo) {
        List<RespuestaAlumnoDTO> respuestas = service.obtenerPorTipo(tipo);
        return ResponseEntity.ok(respuestas);
    }

    @GetMapping("/intento/{intentoNumero}")
    public ResponseEntity<List<RespuestaAlumnoDTO>> obtenerPorIntentoNumero(@PathVariable Integer intentoNumero) {
        List<RespuestaAlumnoDTO> respuestas = service.obtenerPorIntentoNumero(intentoNumero);
        return ResponseEntity.ok(respuestas);
    }

    @GetMapping("/fechas")
    public ResponseEntity<List<RespuestaAlumnoDTO>> obtenerPorRangoFechas(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fin) {
        List<RespuestaAlumnoDTO> respuestas = service.obtenerPorRangoFechas(inicio, fin);
        return ResponseEntity.ok(respuestas);
    }

    @GetMapping("/responde/{respondeId}/pregunta/{preguntaId}")
    public ResponseEntity<List<RespuestaAlumnoDTO>> obtenerPorRespondeIdYPreguntaId(
            @PathVariable Integer respondeId, @PathVariable Integer preguntaId) {
        List<RespuestaAlumnoDTO> respuestas = service.obtenerPorRespondeIdYPreguntaId(respondeId, preguntaId);
        return ResponseEntity.ok(respuestas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespuestaAlumnoDTO> obtenerPorId(@PathVariable Long id) {
        RespuestaAlumnoDTO respuesta = service.obtenerPorId(id);
        return ResponseEntity.ok(respuesta);
    }

    @PostMapping
    public ResponseEntity<RespuestaAlumnoDTO> crear(@Validated @RequestBody RespuestaAlumnoDTO dto) {
        RespuestaAlumnoDTO respuestaGuardada = service.guardar(dto);
        return new ResponseEntity<>(respuestaGuardada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RespuestaAlumnoDTO> actualizar(@PathVariable Long id, @Validated @RequestBody RespuestaAlumnoDTO dto) {
        RespuestaAlumnoDTO respuestaActualizada = service.actualizar(id, dto);
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

    @GetMapping("/existe/responde/{respondeId}/pregunta/{preguntaId}/intento/{intentoNumero}")
    public ResponseEntity<Boolean> existePorRespondePreguntaEIntento(
            @PathVariable Integer respondeId, 
            @PathVariable Integer preguntaId,
            @PathVariable Integer intentoNumero) {
        boolean existe = service.existePorRespondePreguntaEIntento(respondeId, preguntaId, intentoNumero);
        return ResponseEntity.ok(existe);
    }

    @GetMapping("/contar/responde/{respondeId}")
    public ResponseEntity<Long> contarPorRespondeId(@PathVariable Integer respondeId) {
        long count = service.contarPorRespondeId(respondeId);
        return ResponseEntity.ok(count);
    }

    @GetMapping("/contar/pregunta/{preguntaId}")
    public ResponseEntity<Long> contarPorPreguntaId(@PathVariable Integer preguntaId) {
        long count = service.contarPorPreguntaId(preguntaId);
        return ResponseEntity.ok(count);
    }

    @GetMapping("/contar/tipo/{tipo}")
    public ResponseEntity<Long> contarPorTipo(@PathVariable String tipo) {
        long count = service.contarPorTipo(tipo);
        return ResponseEntity.ok(count);
    }
}