package cl.cachoza.web001.controller;

import cl.cachoza.web001.dto.DictaDTO;
import cl.cachoza.web001.service.DictaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dictas")
public class DictaController {

    private final DictaService service;

    @Autowired
    public DictaController(DictaService service) {
        this.service = service;
    }

    @GetMapping("/profesor/{id}")
    public ResponseEntity<List<DictaDTO>> getByProfesor(@PathVariable Long id) {
        List<DictaDTO> dictas = service.obtenerPorProfesor(id);
        return ResponseEntity.ok(dictas);
    }

    @GetMapping("/curso/{id}")
    public ResponseEntity<List<DictaDTO>> getByCurso(@PathVariable Long id) {
        List<DictaDTO> dictas = service.obtenerPorCurso(id);
        return ResponseEntity.ok(dictas);
    }

    @GetMapping("/asignatura/{id}")
    public ResponseEntity<List<DictaDTO>> getByAsignatura(@PathVariable Long id) {
        List<DictaDTO> dictas = service.obtenerPorAsignatura(id);
        return ResponseEntity.ok(dictas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DictaDTO> getById(@PathVariable Long id) {
        DictaDTO dicta = service.obtenerPorId(id);
        return ResponseEntity.ok(dicta);
    }

    @PostMapping
    public ResponseEntity<DictaDTO> crear(@Validated @RequestBody DictaDTO dto) {
        DictaDTO dictaGuardada = service.guardar(dto);
        return new ResponseEntity<>(dictaGuardada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DictaDTO> actualizar(@PathVariable Long id, @Validated @RequestBody DictaDTO dto) {
        DictaDTO dictaActualizada = service.actualizar(id, dto);
        return ResponseEntity.ok(dictaActualizada);
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
            @RequestParam Long profesorId,
            @RequestParam Long cursoId,
            @RequestParam Long asignaturaId) {
        boolean existe = service.existePorProfesorCursoAsignatura(profesorId, cursoId, asignaturaId);
        return ResponseEntity.ok(existe);
    }
}