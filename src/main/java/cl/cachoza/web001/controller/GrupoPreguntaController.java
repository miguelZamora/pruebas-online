package cl.cachoza.web001.controller;

import cl.cachoza.web001.dto.GrupoPreguntaDTO;
import cl.cachoza.web001.service.GrupoPreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grupo-preguntas")
public class GrupoPreguntaController {

    private final GrupoPreguntaService service;

    @Autowired
    public GrupoPreguntaController(GrupoPreguntaService service) {
        this.service = service;
    }

    @GetMapping("/instrumento/{instrumentoId}")
    public ResponseEntity<List<GrupoPreguntaDTO>> getByInstrumento(@PathVariable Long instrumentoId) {
        List<GrupoPreguntaDTO> grupoPreguntas = service.obtenerPorInstrumento(instrumentoId);
        return ResponseEntity.ok(grupoPreguntas);
    }

    @GetMapping("/pregunta/{preguntaId}")
    public ResponseEntity<List<GrupoPreguntaDTO>> getByPregunta(@PathVariable Long preguntaId) {
        List<GrupoPreguntaDTO> grupoPreguntas = service.obtenerPorPregunta(preguntaId);
        return ResponseEntity.ok(grupoPreguntas);
    }

    @GetMapping("/orden/{orden}")
    public ResponseEntity<List<GrupoPreguntaDTO>> getByOrden(@PathVariable Integer orden) {
        List<GrupoPreguntaDTO> grupoPreguntas = service.obtenerPorOrden(orden);
        return ResponseEntity.ok(grupoPreguntas);
    }

    @GetMapping("/numero/{preguntaNumero}")
    public ResponseEntity<List<GrupoPreguntaDTO>> getByPreguntaNumero(@PathVariable Integer preguntaNumero) {
        List<GrupoPreguntaDTO> grupoPreguntas = service.obtenerPorPreguntaNumero(preguntaNumero);
        return ResponseEntity.ok(grupoPreguntas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GrupoPreguntaDTO> getById(@PathVariable Long id) {
        GrupoPreguntaDTO grupoPregunta = service.obtenerPorId(id);
        return ResponseEntity.ok(grupoPregunta);
    }

    @PostMapping
    public ResponseEntity<GrupoPreguntaDTO> crear(@Validated @RequestBody GrupoPreguntaDTO dto) {
        GrupoPreguntaDTO grupoPreguntaGuardado = service.guardar(dto);
        return new ResponseEntity<>(grupoPreguntaGuardado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GrupoPreguntaDTO> actualizar(@PathVariable Long id, @Validated @RequestBody GrupoPreguntaDTO dto) {
        GrupoPreguntaDTO grupoPreguntaActualizado = service.actualizar(id, dto);
        return ResponseEntity.ok(grupoPreguntaActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/existe")
    public ResponseEntity<Boolean> existe(@PathVariable Long id) {
        boolean existe = service.existePorId(id);
        return ResponseEntity.ok(existe);
    }

    @GetMapping("/existe-relacion")
    public ResponseEntity<Boolean> existeRelacion(
            @RequestParam Long instrumentoId,
            @RequestParam Long preguntaId) {
        boolean existe = service.existePorInstrumentoYPregunta(instrumentoId, preguntaId);
        return ResponseEntity.ok(existe);
    }

    @GetMapping("/existe-orden")
    public ResponseEntity<Boolean> existeOrden(
            @RequestParam Long instrumentoId,
            @RequestParam Integer orden) {
        boolean existe = service.existePorInstrumentoYOrden(instrumentoId, orden);
        return ResponseEntity.ok(existe);
    }
}