package cl.cachoza.web001.controller;

import cl.cachoza.web001.dto.ArchivoDTO;
import cl.cachoza.web001.service.ArchivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/archivos")
public class ArchivoController {

    private final ArchivoService service;

    @Autowired
    public ArchivoController(ArchivoService service) {
        this.service = service;
    }

    @GetMapping("/pregunta/{id}")
    public ResponseEntity<List<ArchivoDTO>> getByPregunta(@PathVariable Long id) {
        List<ArchivoDTO> archivos = service.obtenerPorPregunta(id);
        return ResponseEntity.ok(archivos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArchivoDTO> getById(@PathVariable Long id) {
        ArchivoDTO archivo = service.obtenerPorId(id);
        return ResponseEntity.ok(archivo);
    }

    @PostMapping
    public ResponseEntity<ArchivoDTO> crear(@Validated @RequestBody ArchivoDTO dto) {
        ArchivoDTO archivoGuardado = service.guardar(dto);
        return new ResponseEntity<>(archivoGuardado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArchivoDTO> actualizar(@PathVariable Long id, @Validated @RequestBody ArchivoDTO dto) {
        ArchivoDTO archivoActualizado = service.actualizar(id, dto);
        return ResponseEntity.ok(archivoActualizado);
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

    @GetMapping("/pregunta/{id}/existe")
    public ResponseEntity<Boolean> existePorPregunta(@PathVariable Long id) {
        boolean existe = service.existePorPregunta(id);
        return ResponseEntity.ok(existe);
    }
}