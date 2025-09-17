package cl.cachoza.web001.controller;

import cl.cachoza.web001.dto.CursoDTO;
import cl.cachoza.web001.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoService service;

    @Autowired
    public CursoController(CursoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CursoDTO>> obtenerTodos() {
        List<CursoDTO> cursos = service.obtenerTodos();
        return ResponseEntity.ok(cursos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDTO> obtenerPorId(@PathVariable Long id) {
        CursoDTO curso = service.obtenerPorId(id);
        return ResponseEntity.ok(curso);
    }

    @GetMapping("/rbd/{rbdId}")
    public ResponseEntity<List<CursoDTO>> obtenerPorRbd(@PathVariable Long rbdId) {
        List<CursoDTO> cursos = service.obtenerPorRbd(rbdId);
        return ResponseEntity.ok(cursos);
    }

    @GetMapping("/anio/{anio}")
    public ResponseEntity<List<CursoDTO>> obtenerPorAnio(@PathVariable Integer anio) {
        List<CursoDTO> cursos = service.obtenerPorAnio(anio);
        return ResponseEntity.ok(cursos);
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<CursoDTO>> obtenerPorEstado(@PathVariable Integer estado) {
        List<CursoDTO> cursos = service.obtenerPorEstado(estado);
        return ResponseEntity.ok(cursos);
    }

    @PostMapping
    public ResponseEntity<CursoDTO> crear(@Validated @RequestBody CursoDTO dto) {
        CursoDTO cursoGuardado = service.guardar(dto);
        return new ResponseEntity<>(cursoGuardado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoDTO> actualizar(@PathVariable Long id, @Validated @RequestBody CursoDTO dto) {
        CursoDTO cursoActualizado = service.actualizar(id, dto);
        return ResponseEntity.ok(cursoActualizado);
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

    @GetMapping("/existe/codigo")
    public ResponseEntity<Boolean> existePorCodigoCurso(@RequestParam String codigoCurso) {
        boolean existe = service.existePorCodigoCurso(codigoCurso);
        return ResponseEntity.ok(existe);
    }

    @GetMapping("/existe/duplicado")
    public ResponseEntity<Boolean> existeCursoDuplicado(
            @RequestParam Long rbdId,
            @RequestParam Long codigoNivel,
            @RequestParam String letra,
            @RequestParam Integer anio) {
        boolean existe = service.existeCursoDuplicado(rbdId, codigoNivel, letra, anio);
        return ResponseEntity.ok(existe);
    }
}