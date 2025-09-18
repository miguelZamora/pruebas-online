package cl.cachoza.web001.controller;

import cl.cachoza.web001.dto.RespondeDTO;
import cl.cachoza.web001.service.RespondeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/responde")
public class RespondeController {

    private final RespondeService service;

    @Autowired
    public RespondeController(RespondeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<RespondeDTO>> obtenerTodos() {
        List<RespondeDTO> respondeList = service.obtenerTodos();
        return ResponseEntity.ok(respondeList);
    }

    @GetMapping("/instrumento/{instrumentoInstanciaId}")
    public ResponseEntity<List<RespondeDTO>> obtenerPorInstrumentoInstancia(@PathVariable Integer instrumentoInstanciaId) {
        List<RespondeDTO> respondeList = service.obtenerPorInstrumentoInstancia(instrumentoInstanciaId);
        return ResponseEntity.ok(respondeList);
    }

    @GetMapping("/alumno/{alumnoId}")
    public ResponseEntity<List<RespondeDTO>> obtenerPorAlumno(@PathVariable String alumnoId) {
        List<RespondeDTO> respondeList = service.obtenerPorAlumno(alumnoId);
        return ResponseEntity.ok(respondeList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespondeDTO> obtenerPorId(@PathVariable Long id) {
        RespondeDTO responde = service.obtenerPorId(id);
        return ResponseEntity.ok(responde);
    }

    @PostMapping
    public ResponseEntity<RespondeDTO> crear(@Validated @RequestBody RespondeDTO dto) {
        RespondeDTO respondeGuardado = service.guardar(dto);
        return new ResponseEntity<>(respondeGuardado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RespondeDTO> actualizar(@PathVariable Long id, @Validated @RequestBody RespondeDTO dto) {
        RespondeDTO respondeActualizado = service.actualizar(id, dto);
        return ResponseEntity.ok(respondeActualizado);
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

    @GetMapping("/existe/instrumento/{instrumentoInstanciaId}/alumno/{alumnoId}")
    public ResponseEntity<Boolean> existePorInstrumentoYAlumno(
            @PathVariable Integer instrumentoInstanciaId, 
            @PathVariable String alumnoId) {
        boolean existe = service.existePorInstrumentoYAlumno(instrumentoInstanciaId, alumnoId);
        return ResponseEntity.ok(existe);
    }

    @GetMapping("/contar/instrumento/{instrumentoInstanciaId}")
    public ResponseEntity<Long> contarPorInstrumentoInstancia(@PathVariable Integer instrumentoInstanciaId) {
        long count = service.contarPorInstrumentoInstancia(instrumentoInstanciaId);
        return ResponseEntity.ok(count);
    }

    @GetMapping("/contar/alumno/{alumnoId}")
    public ResponseEntity<Long> contarPorAlumno(@PathVariable String alumnoId) {
        long count = service.contarPorAlumno(alumnoId);
        return ResponseEntity.ok(count);
    }
}