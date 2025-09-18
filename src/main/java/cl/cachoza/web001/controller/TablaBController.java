package cl.cachoza.web001.controller;

import cl.cachoza.web001.dto.TablaBDTO;
import cl.cachoza.web001.service.TablaBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tabla-b")
public class TablaBController {

    private final TablaBService service;

    @Autowired
    public TablaBController(TablaBService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TablaBDTO>> obtenerTodos() {
        List<TablaBDTO> tablaBList = service.obtenerTodos();
        return ResponseEntity.ok(tablaBList);
    }

    @GetMapping("/pregunta/{preguntaId}")
    public ResponseEntity<List<TablaBDTO>> obtenerPorPreguntaId(@PathVariable Integer preguntaId) {
        List<TablaBDTO> tablaBList = service.obtenerPorPreguntaId(preguntaId);
        return ResponseEntity.ok(tablaBList);
    }

    @GetMapping("/buscar/{contenido}")
    public ResponseEntity<List<TablaBDTO>> obtenerPorOpcionContenido(@PathVariable String contenido) {
        List<TablaBDTO> tablaBList = service.obtenerPorOpcionContenido(contenido);
        return ResponseEntity.ok(tablaBList);
    }

    @GetMapping("/orden/{orden}")
    public ResponseEntity<List<TablaBDTO>> obtenerPorOrden(@PathVariable Integer orden) {
        List<TablaBDTO> tablaBList = service.obtenerPorOrden(orden);
        return ResponseEntity.ok(tablaBList);
    }

    @GetMapping("/pregunta/{preguntaId}/ordenado")
    public ResponseEntity<List<TablaBDTO>> obtenerPorPreguntaIdOrdenado(@PathVariable Integer preguntaId) {
        List<TablaBDTO> tablaBList = service.obtenerPorPreguntaIdOrdenado(preguntaId);
        return ResponseEntity.ok(tablaBList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TablaBDTO> obtenerPorId(@PathVariable Long id) {
        TablaBDTO tablaB = service.obtenerPorId(id);
        return ResponseEntity.ok(tablaB);
    }

    @PostMapping
    public ResponseEntity<TablaBDTO> crear(@Validated @RequestBody TablaBDTO dto) {
        TablaBDTO tablaBGuardada = service.guardar(dto);
        return new ResponseEntity<>(tablaBGuardada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TablaBDTO> actualizar(@PathVariable Long id, @Validated @RequestBody TablaBDTO dto) {
        TablaBDTO tablaBActualizada = service.actualizar(id, dto);
        return ResponseEntity.ok(tablaBActualizada);
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

    @GetMapping("/existe/pregunta/{preguntaId}/opcion/{opcion}")
    public ResponseEntity<Boolean> existePorPreguntaYOpcion(
            @PathVariable Integer preguntaId, 
            @PathVariable String opcion) {
        boolean existe = service.existePorPreguntaYOpcion(preguntaId, opcion);
        return ResponseEntity.ok(existe);
    }

    @GetMapping("/existe/pregunta/{preguntaId}/orden/{orden}")
    public ResponseEntity<Boolean> existePorPreguntaYOrden(
            @PathVariable Integer preguntaId, 
            @PathVariable Integer orden) {
        boolean existe = service.existePorPreguntaYOrden(preguntaId, orden);
        return ResponseEntity.ok(existe);
    }

    @GetMapping("/contar/pregunta/{preguntaId}")
    public ResponseEntity<Long> contarPorPreguntaId(@PathVariable Integer preguntaId) {
        long count = service.contarPorPreguntaId(preguntaId);
        return ResponseEntity.ok(count);
    }
}