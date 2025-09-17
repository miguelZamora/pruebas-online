package cl.cachoza.web001.controller;

import cl.cachoza.web001.dto.EstablecimientoDTO;
import cl.cachoza.web001.service.EstablecimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/establecimientos")
public class EstablecimientoController {

    private final EstablecimientoService service;

    @Autowired
    public EstablecimientoController(EstablecimientoService service) {
        this.service = service;
    }

    @GetMapping("/rbd/{rbd}")
    public ResponseEntity<List<EstablecimientoDTO>> getByRbd(@PathVariable Long rbd) {
        List<EstablecimientoDTO> establecimientos = service.obtenerPorRbd(rbd);
        return ResponseEntity.ok(establecimientos);
    }

    @GetMapping("/dvrbd/{dvrbd}")
    public ResponseEntity<List<EstablecimientoDTO>> getByDvrbd(@PathVariable Long dvrbd) {
        List<EstablecimientoDTO> establecimientos = service.obtenerPorDvrbd(dvrbd);
        return ResponseEntity.ok(establecimientos);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<EstablecimientoDTO>> getByNombre(@PathVariable String nombre) {
        List<EstablecimientoDTO> establecimientos = service.obtenerPorNombre(nombre);
        return ResponseEntity.ok(establecimientos);
    }

    @GetMapping("/eliminados/{eliminado}")
    public ResponseEntity<List<EstablecimientoDTO>> getByEliminados(@PathVariable Boolean eliminado) {
        List<EstablecimientoDTO> establecimientos = service.obtenerPorEliminados(eliminado);
        return ResponseEntity.ok(establecimientos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstablecimientoDTO> getById(@PathVariable Long id) {
        EstablecimientoDTO establecimiento = service.obtenerPorId(id);
        return ResponseEntity.ok(establecimiento);
    }

    @PostMapping
    public ResponseEntity<EstablecimientoDTO> crear(@Validated @RequestBody EstablecimientoDTO dto) {
        EstablecimientoDTO establecimientoGuardado = service.guardar(dto);
        return new ResponseEntity<>(establecimientoGuardado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstablecimientoDTO> actualizar(@PathVariable Long id, @Validated @RequestBody EstablecimientoDTO dto) {
        EstablecimientoDTO establecimientoActualizado = service.actualizar(id, dto);
        return ResponseEntity.ok(establecimientoActualizado);
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

    @GetMapping("/existe-rbd-dvrbd")
    public ResponseEntity<Boolean> existePorRbdYDvrbd(
            @RequestParam Long rbd,
            @RequestParam Long dvrbd) {
        boolean existe = service.existePorRbdYDvrbd(rbd, dvrbd);
        return ResponseEntity.ok(existe);
    }

    @GetMapping("/existe-rbd/{rbd}")
    public ResponseEntity<Boolean> existePorRbd(@PathVariable Long rbd) {
        boolean existe = service.existePorRbd(rbd);
        return ResponseEntity.ok(existe);
    }
}