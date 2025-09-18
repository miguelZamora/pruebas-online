package cl.cachoza.web001.controller;

import cl.cachoza.web001.dto.PreguntaDTO;
import cl.cachoza.web001.service.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/preguntas")
public class PreguntaController {

    private final PreguntaService service;

    @Autowired
    public PreguntaController(PreguntaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PreguntaDTO>> obtenerTodos() {
        List<PreguntaDTO> preguntas = service.obtenerTodos();
        return ResponseEntity.ok(preguntas);
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<PreguntaDTO>> obtenerPorTipo(@PathVariable String tipo) {
        List<PreguntaDTO> preguntas = service.obtenerPorTipo(tipo);
        return ResponseEntity.ok(preguntas);
    }

    @GetMapping("/nivel/{nivel}")
    public ResponseEntity<List<PreguntaDTO>> obtenerPorNivel(@PathVariable String nivel) {
        List<PreguntaDTO> preguntas = service.obtenerPorNivel(nivel);
        return ResponseEntity.ok(preguntas);
    }

    @GetMapping("/curso/{curso}")
    public ResponseEntity<List<PreguntaDTO>> obtenerPorCurso(@PathVariable String curso) {
        List<PreguntaDTO> preguntas = service.obtenerPorCurso(curso);
        return ResponseEntity.ok(preguntas);
    }

    @GetMapping("/asignatura/{asignatura}")
    public ResponseEntity<List<PreguntaDTO>> obtenerPorAsignatura(@PathVariable String asignatura) {
        List<PreguntaDTO> preguntas = service.obtenerPorAsignatura(asignatura);
        return ResponseEntity.ok(preguntas);
    }

    @GetMapping("/semi-offline/{semiOffline}")
    public ResponseEntity<List<PreguntaDTO>> obtenerPorSemiOffline(@PathVariable Boolean semiOffline) {
        List<PreguntaDTO> preguntas = service.obtenerPorSemiOffline(semiOffline);
        return ResponseEntity.ok(preguntas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PreguntaDTO> obtenerPorId(@PathVariable Long id) {
        PreguntaDTO pregunta = service.obtenerPorId(id);
        return ResponseEntity.ok(pregunta);
    }

    @PostMapping
    public ResponseEntity<PreguntaDTO> crear(@Validated @RequestBody PreguntaDTO dto) {
        PreguntaDTO preguntaGuardada = service.guardar(dto);
        return new ResponseEntity<>(preguntaGuardada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PreguntaDTO> actualizar(@PathVariable Long id, @Validated @RequestBody PreguntaDTO dto) {
        PreguntaDTO preguntaActualizada = service.actualizar(id, dto);
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

    @GetMapping("/existe/id-antiguo/{idAntiguo}")
    public ResponseEntity<Boolean> existePorIdAntiguo(@PathVariable String idAntiguo) {
        boolean existe = service.existePorIdAntiguo(idAntiguo);
        return ResponseEntity.ok(existe);
    }
}