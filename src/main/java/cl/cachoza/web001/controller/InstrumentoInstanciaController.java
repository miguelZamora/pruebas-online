package cl.cachoza.web001.controller;

import cl.cachoza.web001.dto.InstrumentoInstanciaDTO;
import cl.cachoza.web001.service.InstrumentoInstanciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instrumento-instancias")
public class InstrumentoInstanciaController {

    private final InstrumentoInstanciaService service;

    @Autowired
    public InstrumentoInstanciaController(InstrumentoInstanciaService service) {
        this.service = service;
    }

    @GetMapping("/instrumento/{instrumentoId}")
    public ResponseEntity<List<InstrumentoInstanciaDTO>> getByInstrumentoId(@PathVariable Long instrumentoId) {
        List<InstrumentoInstanciaDTO> instancias = service.obtenerPorInstrumentoId(instrumentoId);
        return ResponseEntity.ok(instancias);
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<InstrumentoInstanciaDTO>> getByEstado(@PathVariable Integer estado) {
        List<InstrumentoInstanciaDTO> instancias = service.obtenerPorEstado(estado);
        return ResponseEntity.ok(instancias);
    }

    @GetMapping("/curso/{codigoCursoId}")
    public ResponseEntity<List<InstrumentoInstanciaDTO>> getByCodigoCursoId(@PathVariable Long codigoCursoId) {
        List<InstrumentoInstanciaDTO> instancias = service.obtenerPorCodigoCursoId(codigoCursoId);
        return ResponseEntity.ok(instancias);
    }

    @GetMapping("/editable/{editableOffline}")
    public ResponseEntity<List<InstrumentoInstanciaDTO>> getByEditableOffline(@PathVariable Boolean editableOffline) {
        List<InstrumentoInstanciaDTO> instancias = service.obtenerPorEditableOffline(editableOffline);
        return ResponseEntity.ok(instancias);
    }

    @GetMapping("/combinado")
    public ResponseEntity<List<InstrumentoInstanciaDTO>> getByCombinado(
            @RequestParam Long instrumentoId,
            @RequestParam Long codigoCursoId) {
        List<InstrumentoInstanciaDTO> instancias = service.obtenerPorInstrumentoIdYCodigoCursoId(instrumentoId, codigoCursoId);
        return ResponseEntity.ok(instancias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstrumentoInstanciaDTO> getById(@PathVariable Long id) {
        InstrumentoInstanciaDTO instancia = service.obtenerPorId(id);
        return ResponseEntity.ok(instancia);
    }

    @PostMapping
    public ResponseEntity<InstrumentoInstanciaDTO> crear(@Validated @RequestBody InstrumentoInstanciaDTO dto) {
        InstrumentoInstanciaDTO instanciaGuardada = service.guardar(dto);
        return new ResponseEntity<>(instanciaGuardada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InstrumentoInstanciaDTO> actualizar(@PathVariable Long id, @Validated @RequestBody InstrumentoInstanciaDTO dto) {
        InstrumentoInstanciaDTO instanciaActualizada = service.actualizar(id, dto);
        return ResponseEntity.ok(instanciaActualizada);
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
            @RequestParam Long instrumentoId,
            @RequestParam Long codigoCursoId) {
        boolean existe = service.existePorInstrumentoIdYCodigoCursoId(instrumentoId, codigoCursoId);
        return ResponseEntity.ok(existe);
    }
}