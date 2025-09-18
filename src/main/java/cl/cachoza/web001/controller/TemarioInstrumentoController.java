package cl.cachoza.web001.controller;

import cl.cachoza.web001.dto.TemarioInstrumentoDTO;
import cl.cachoza.web001.service.TemarioInstrumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/temario-instrumentos")
public class TemarioInstrumentoController {

    private final TemarioInstrumentoService service;

    @Autowired
    public TemarioInstrumentoController(TemarioInstrumentoService service) {
        this.service = service;
    }

    @GetMapping("/instrumento/{id}")
    public ResponseEntity<List<TemarioInstrumentoDTO>> getByInstrumento(@PathVariable Long id) {
        List<TemarioInstrumentoDTO> temarios = service.obtenerPorInstrumento(id);
        return ResponseEntity.ok(temarios);
    }

    @GetMapping("/curso/{id}")
    public ResponseEntity<List<TemarioInstrumentoDTO>> getByCurso(@PathVariable Long id) {
        List<TemarioInstrumentoDTO> temarios = service.obtenerPorCurso(id);
        return ResponseEntity.ok(temarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TemarioInstrumentoDTO> getById(@PathVariable Long id) {
        TemarioInstrumentoDTO temario = service.obtenerPorId(id);
        return ResponseEntity.ok(temario);
    }

    @PostMapping
    public ResponseEntity<TemarioInstrumentoDTO> crear(@Validated @RequestBody TemarioInstrumentoDTO dto) {
        TemarioInstrumentoDTO temarioGuardado = service.guardar(dto);
        return new ResponseEntity<>(temarioGuardado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TemarioInstrumentoDTO> actualizar(@PathVariable Long id, @Validated @RequestBody TemarioInstrumentoDTO dto) {
        TemarioInstrumentoDTO temarioActualizado = service.actualizar(id, dto);
        return ResponseEntity.ok(temarioActualizado);
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

    @GetMapping("/existe")
    public ResponseEntity<Boolean> existePorInstrumentoYCurso(
            @RequestParam Long instrumentoId, 
            @RequestParam Long cursoId) {
        boolean existe = service.existePorInstrumentoYCurso(instrumentoId, cursoId);
        return ResponseEntity.ok(existe);
    }
}