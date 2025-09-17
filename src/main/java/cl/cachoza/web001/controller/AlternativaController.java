package cl.cachoza.web001.controller;

import cl.cachoza.web001.dto.AlternativaDTO;
import cl.cachoza.web001.service.AlternativaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alternativas")
public class AlternativaController {

    private final AlternativaService service;

    @Autowired
    public AlternativaController(AlternativaService service) {
        this.service = service;
    }

    @GetMapping("/pregunta/{id}")
    public ResponseEntity<List<AlternativaDTO>> getByPregunta(@PathVariable Long id) {
        List<AlternativaDTO> alternativas = service.obtenerPorPregunta(id);
        return ResponseEntity.ok(alternativas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlternativaDTO> getById(@PathVariable Long id) {
        AlternativaDTO alternativa = service.obtenerPorId(id);
        return ResponseEntity.ok(alternativa);
    }

    @PostMapping
    public ResponseEntity<AlternativaDTO> crear(@Validated @RequestBody AlternativaDTO dto) {
        AlternativaDTO alternativaGuardada = service.guardar(dto);
        return new ResponseEntity<>(alternativaGuardada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlternativaDTO> actualizar(@PathVariable Long id, @Validated @RequestBody AlternativaDTO dto) {
        AlternativaDTO alternativaActualizada = service.actualizar(id, dto);
        return ResponseEntity.ok(alternativaActualizada);
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
}