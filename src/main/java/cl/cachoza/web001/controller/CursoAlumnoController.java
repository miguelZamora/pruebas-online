package cl.cachoza.web001.controller;

import cl.cachoza.web001.dto.CursoAlumnoDTO;
import cl.cachoza.web001.service.CursoAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos-alumnos")
public class CursoAlumnoController {

    private final CursoAlumnoService service;

    @Autowired
    public CursoAlumnoController(CursoAlumnoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CursoAlumnoDTO>> obtenerTodos() {
        List<CursoAlumnoDTO> inscripciones = service.obtenerTodos();
        return ResponseEntity.ok(inscripciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoAlumnoDTO> obtenerPorId(@PathVariable Long id) {
        CursoAlumnoDTO inscripcion = service.obtenerPorId(id);
        return ResponseEntity.ok(inscripcion);
    }

    @GetMapping("/alumno/{alumnoId}")
    public ResponseEntity<List<CursoAlumnoDTO>> obtenerPorAlumno(@PathVariable Long alumnoId) {
        List<CursoAlumnoDTO> inscripciones = service.obtenerPorAlumno(alumnoId);
        return ResponseEntity.ok(inscripciones);
    }

    @GetMapping("/curso/{cursoId}")
    public ResponseEntity<List<CursoAlumnoDTO>> obtenerPorCurso(@PathVariable Long cursoId) {
        List<CursoAlumnoDTO> inscripciones = service.obtenerPorCurso(cursoId);
        return ResponseEntity.ok(inscripciones);
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<CursoAlumnoDTO>> obtenerPorEstado(@PathVariable Integer estado) {
        List<CursoAlumnoDTO> inscripciones = service.obtenerPorEstado(estado);
        return ResponseEntity.ok(inscripciones);
    }

    @PostMapping
    public ResponseEntity<CursoAlumnoDTO> crear(@Validated @RequestBody CursoAlumnoDTO dto) {
        CursoAlumnoDTO inscripcionGuardada = service.guardar(dto);
        return new ResponseEntity<>(inscripcionGuardada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoAlumnoDTO> actualizar(@PathVariable Long id, @Validated @RequestBody CursoAlumnoDTO dto) {
        CursoAlumnoDTO inscripcionActualizada = service.actualizar(id, dto);
        return ResponseEntity.ok(inscripcionActualizada);
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

    @GetMapping("/existe/inscripcion")
    public ResponseEntity<Boolean> existeInscripcion(
            @RequestParam Long alumnoId,
            @RequestParam Long cursoId) {
        boolean existe = service.existeInscripcion(alumnoId, cursoId);
        return ResponseEntity.ok(existe);
    }

    @GetMapping("/contar/curso/{cursoId}")
    public ResponseEntity<Long> contarPorCurso(@PathVariable Long cursoId) {
        long cantidad = service.contarPorCurso(cursoId);
        return ResponseEntity.ok(cantidad);
    }

    @GetMapping("/contar/alumno/{alumnoId}")
    public ResponseEntity<Long> contarPorAlumno(@PathVariable Long alumnoId) {
        long cantidad = service.contarPorAlumno(alumnoId);
        return ResponseEntity.ok(cantidad);
    }
}