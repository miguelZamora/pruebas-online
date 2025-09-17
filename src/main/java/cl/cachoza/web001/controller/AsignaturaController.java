package cl.cachoza.web001.controller;

import cl.cachoza.web001.dto.AsignaturaDTO;
import cl.cachoza.web001.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asignaturas")
public class AsignaturaController {

    private final AsignaturaService service;

    @Autowired
    public AsignaturaController(AsignaturaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AsignaturaDTO>> obtenerTodas() {
        List<AsignaturaDTO> asignaturas = service.obtenerTodas();
        return ResponseEntity.ok(asignaturas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsignaturaDTO> obtenerPorId(@PathVariable Long id) {
        AsignaturaDTO asignatura = service.obtenerPorId(id);
        return ResponseEntity.ok(asignatura);
    }

    @PostMapping
    public ResponseEntity<AsignaturaDTO> crear(@Validated @RequestBody AsignaturaDTO dto) {
        AsignaturaDTO asignaturaGuardada = service.guardar(dto);
        return new ResponseEntity<>(asignaturaGuardada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AsignaturaDTO> actualizar(@PathVariable Long id, @Validated @RequestBody AsignaturaDTO dto) {
        AsignaturaDTO asignaturaActualizada = service.actualizar(id, dto);
        return ResponseEntity.ok(asignaturaActualizada);
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

    @GetMapping("/existe/nombre")
    public ResponseEntity<Boolean> existePorNombre(@RequestParam String nombre) {
        boolean existe = service.existePorNombre(nombre);
        return ResponseEntity.ok(existe);
    }
}