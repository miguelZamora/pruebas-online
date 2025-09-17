package cl.cachoza.web001.controller;

import cl.cachoza.web001.dto.GuardarDTO;
import cl.cachoza.web001.service.GuardarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guardar")
public class GuardarController {

    private final GuardarService service;

    @Autowired
    public GuardarController(GuardarService service) {
        this.service = service;
    }

    @GetMapping("/profesor/{profesorId}")
    public ResponseEntity<List<GuardarDTO>> getByProfesor(@PathVariable Long profesorId) {
        List<GuardarDTO> guardados = service.obtenerPorProfesor(profesorId);
        return ResponseEntity.ok(guardados);
    }

    @GetMapping("/curso/{cursoId}")
    public ResponseEntity<List<GuardarDTO>> getByCurso(@PathVariable Long cursoId) {
        List<GuardarDTO> guardados = service.obtenerPorCurso(cursoId);
        return ResponseEntity.ok(guardados);
    }

    @GetMapping("/instrumento/{instrumentoId}")
    public ResponseEntity<List<GuardarDTO>> getByInstrumento(@PathVariable Long instrumentoId) {
        List<GuardarDTO> guardados = service.obtenerPorInstrumento(instrumentoId);
        return ResponseEntity.ok(guardados);
    }

    @GetMapping("/papel/{papel}")
    public ResponseEntity<List<GuardarDTO>> getByPapel(@PathVariable Boolean papel) {
        List<GuardarDTO> guardados = service.obtenerPorPapel(papel);
        return ResponseEntity.ok(guardados);
    }

    @GetMapping("/combinado")
    public ResponseEntity<List<GuardarDTO>> getByCombinado(
            @RequestParam Long profesorId,
            @RequestParam Long cursoId,
            @RequestParam Long instrumentoId) {
        List<GuardarDTO> guardados = service.obtenerPorProfesorCursoInstrumento(profesorId, cursoId, instrumentoId);
        return ResponseEntity.ok(guardados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuardarDTO> getById(@PathVariable Long id) {
        GuardarDTO guardar = service.obtenerPorId(id);
        return ResponseEntity.ok(guardar);
    }

    @PostMapping
    public ResponseEntity<GuardarDTO> crear(@Validated @RequestBody GuardarDTO dto) {
        GuardarDTO guardarGuardado = service.guardar(dto);
        return new ResponseEntity<>(guardarGuardado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GuardarDTO> actualizar(@PathVariable Long id, @Validated @RequestBody GuardarDTO dto) {
        GuardarDTO guardarActualizado = service.actualizar(id, dto);
        return ResponseEntity.ok(guardarActualizado);
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

    @GetMapping("/existe-combinado")
    public ResponseEntity<Boolean> existeCombinado(
            @RequestParam Long profesorId,
            @RequestParam Long cursoId,
            @RequestParam Long instrumentoId) {
        boolean existe = service.existePorProfesorCursoInstrumento(profesorId, cursoId, instrumentoId);
        return ResponseEntity.ok(existe);
    }
}