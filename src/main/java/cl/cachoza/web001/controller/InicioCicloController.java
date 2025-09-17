package cl.cachoza.web001.controller;

import cl.cachoza.web001.dto.InicioCicloDTO;
import cl.cachoza.web001.service.InicioCicloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inicio-ciclo")
public class InicioCicloController {

    private final InicioCicloService service;

    @Autowired
    public InicioCicloController(InicioCicloService service) {
        this.service = service;
    }

    @GetMapping("/usuario/{usuarioIdWp}")
    public ResponseEntity<List<InicioCicloDTO>> getByUsuarioIdWp(@PathVariable Long usuarioIdWp) {
        List<InicioCicloDTO> inicioCiclos = service.obtenerPorUsuarioIdWp(usuarioIdWp);
        return ResponseEntity.ok(inicioCiclos);
    }

    @GetMapping("/rbd/{rbdId}")
    public ResponseEntity<List<InicioCicloDTO>> getByRbdId(@PathVariable Long rbdId) {
        List<InicioCicloDTO> inicioCiclos = service.obtenerPorRbdId(rbdId);
        return ResponseEntity.ok(inicioCiclos);
    }

    @GetMapping("/combinado")
    public ResponseEntity<List<InicioCicloDTO>> getByCombinado(
            @RequestParam Long usuarioIdWp,
            @RequestParam Long rbdId) {
        List<InicioCicloDTO> inicioCiclos = service.obtenerPorUsuarioIdWpYRbdId(usuarioIdWp, rbdId);
        return ResponseEntity.ok(inicioCiclos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InicioCicloDTO> getById(@PathVariable Long id) {
        InicioCicloDTO inicioCiclo = service.obtenerPorId(id);
        return ResponseEntity.ok(inicioCiclo);
    }

    @PostMapping
    public ResponseEntity<InicioCicloDTO> crear(@Validated @RequestBody InicioCicloDTO dto) {
        InicioCicloDTO inicioCicloGuardado = service.guardar(dto);
        return new ResponseEntity<>(inicioCicloGuardado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InicioCicloDTO> actualizar(@PathVariable Long id, @Validated @RequestBody InicioCicloDTO dto) {
        InicioCicloDTO inicioCicloActualizado = service.actualizar(id, dto);
        return ResponseEntity.ok(inicioCicloActualizado);
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
            @RequestParam Long usuarioIdWp,
            @RequestParam Long rbdId) {
        boolean existe = service.existePorUsuarioIdWpYRbdId(usuarioIdWp, rbdId);
        return ResponseEntity.ok(existe);
    }
}