package cl.cachoza.web001.controller;

import cl.cachoza.web001.dto.TextoAsociadoDTO;
import cl.cachoza.web001.service.TextoAsociadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/textos-asociados")
public class TextoAsociadoController {

    private final TextoAsociadoService service;

    @Autowired
    public TextoAsociadoController(TextoAsociadoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TextoAsociadoDTO>> obtenerTodos() {
        List<TextoAsociadoDTO> textos = service.obtenerTodos();
        return ResponseEntity.ok(textos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TextoAsociadoDTO> obtenerPorId(@PathVariable Long id) {
        TextoAsociadoDTO texto = service.obtenerPorId(id);
        return ResponseEntity.ok(texto);
    }

    @PostMapping
    public ResponseEntity<TextoAsociadoDTO> crear(@Validated @RequestBody TextoAsociadoDTO dto) {
        TextoAsociadoDTO textoGuardado = service.guardar(dto);
        return new ResponseEntity<>(textoGuardado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TextoAsociadoDTO> actualizar(@PathVariable Long id, @Validated @RequestBody TextoAsociadoDTO dto) {
        TextoAsociadoDTO textoActualizado = service.actualizar(id, dto);
        return ResponseEntity.ok(textoActualizado);
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
}