package cl.cachoza.web001.controller;

import cl.cachoza.web001.dto.GuardarTablaDTO;
import cl.cachoza.web001.service.GuardarTablaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guardar-tabla")
public class GuardarTablaController {

    private final GuardarTablaService service;

    @Autowired
    public GuardarTablaController(GuardarTablaService service) {
        this.service = service;
    }

    @GetMapping("/guardar/{guardarId}")
    public ResponseEntity<List<GuardarTablaDTO>> getByGuardarId(@PathVariable Long guardarId) {
        List<GuardarTablaDTO> guardarTablas = service.obtenerPorGuardarId(guardarId);
        return ResponseEntity.ok(guardarTablas);
    }

    @GetMapping("/posicion/{posicion}")
    public ResponseEntity<List<GuardarTablaDTO>> getByPosicion(@PathVariable String posicion) {
        List<GuardarTablaDTO> guardarTablas = service.obtenerPorPosicion(posicion);
        return ResponseEntity.ok(guardarTablas);
    }

    @GetMapping("/valor/{valor}")
    public ResponseEntity<List<GuardarTablaDTO>> getByValor(@PathVariable String valor) {
        List<GuardarTablaDTO> guardarTablas = service.obtenerPorValor(valor);
        return ResponseEntity.ok(guardarTablas);
    }

    @GetMapping("/combinado")
    public ResponseEntity<List<GuardarTablaDTO>> getByCombinado(
            @RequestParam Long guardarId,
            @RequestParam String posicion) {
        List<GuardarTablaDTO> guardarTablas = service.obtenerPorGuardarIdYPosicion(guardarId, posicion);
        return ResponseEntity.ok(guardarTablas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuardarTablaDTO> getById(@PathVariable Long id) {
        GuardarTablaDTO guardarTabla = service.obtenerPorId(id);
        return ResponseEntity.ok(guardarTabla);
    }

    @PostMapping
    public ResponseEntity<GuardarTablaDTO> crear(@Validated @RequestBody GuardarTablaDTO dto) {
        GuardarTablaDTO guardarTablaGuardado = service.guardar(dto);
        return new ResponseEntity<>(guardarTablaGuardado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GuardarTablaDTO> actualizar(@PathVariable Long id, @Validated @RequestBody GuardarTablaDTO dto) {
        GuardarTablaDTO guardarTablaActualizado = service.actualizar(id, dto);
        return ResponseEntity.ok(guardarTablaActualizado);
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
            @RequestParam Long guardarId,
            @RequestParam String posicion) {
        boolean existe = service.existePorGuardarIdYPosicion(guardarId, posicion);
        return ResponseEntity.ok(existe);
    }
}