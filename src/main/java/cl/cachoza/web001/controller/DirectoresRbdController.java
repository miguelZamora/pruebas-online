package cl.cachoza.web001.controller;

import cl.cachoza.web001.dto.DirectoresRbdDTO;
import cl.cachoza.web001.service.DirectoresRbdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/directores-rbd")
public class DirectoresRbdController {

    private final DirectoresRbdService service;

    @Autowired
    public DirectoresRbdController(DirectoresRbdService service) {
        this.service = service;
    }

    @GetMapping("/rut/{rut}")
    public ResponseEntity<List<DirectoresRbdDTO>> getByRut(@PathVariable String rut) {
        List<DirectoresRbdDTO> directores = service.obtenerPorRut(rut);
        return ResponseEntity.ok(directores);
    }

    @GetMapping("/rbd/{rbd}")
    public ResponseEntity<List<DirectoresRbdDTO>> getByRbd(@PathVariable String rbd) {
        List<DirectoresRbdDTO> directores = service.obtenerPorRbd(rbd);
        return ResponseEntity.ok(directores);
    }

    @GetMapping("/tipo-w/{tipoW}")
    public ResponseEntity<List<DirectoresRbdDTO>> getByTipoW(@PathVariable String tipoW) {
        List<DirectoresRbdDTO> directores = service.obtenerPorTipoW(tipoW);
        return ResponseEntity.ok(directores);
    }

    @GetMapping("/origen/{origen}")
    public ResponseEntity<List<DirectoresRbdDTO>> getByOrigen(@PathVariable String origen) {
        List<DirectoresRbdDTO> directores = service.obtenerPorOrigen(origen);
        return ResponseEntity.ok(directores);
    }

    @GetMapping("/test/{esTest}")
    public ResponseEntity<List<DirectoresRbdDTO>> getByEsTest(@PathVariable Boolean esTest) {
        List<DirectoresRbdDTO> directores = service.obtenerPorEsTest(esTest);
        return ResponseEntity.ok(directores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DirectoresRbdDTO> getById(@PathVariable Long id) {
        DirectoresRbdDTO director = service.obtenerPorId(id);
        return ResponseEntity.ok(director);
    }

    @PostMapping
    public ResponseEntity<DirectoresRbdDTO> crear(@Validated @RequestBody DirectoresRbdDTO dto) {
        DirectoresRbdDTO directorGuardado = service.guardar(dto);
        return new ResponseEntity<>(directorGuardado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DirectoresRbdDTO> actualizar(@PathVariable Long id, @Validated @RequestBody DirectoresRbdDTO dto) {
        DirectoresRbdDTO directorActualizado = service.actualizar(id, dto);
        return ResponseEntity.ok(directorActualizado);
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

    @GetMapping("/existe-relacion")
    public ResponseEntity<Boolean> existeRelacion(
            @RequestParam String rut,
            @RequestParam String rbd) {
        boolean existe = service.existePorRutYRbd(rut, rbd);
        return ResponseEntity.ok(existe);
    }
}