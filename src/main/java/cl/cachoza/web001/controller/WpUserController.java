package cl.cachoza.web001.controller;

import cl.cachoza.web001.dto.WpUserDTO;
import cl.cachoza.web001.service.WpUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/wp-users")
public class WpUserController {

    private final WpUserService service;

    @Autowired
    public WpUserController(WpUserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<WpUserDTO>> obtenerTodos() {
        List<WpUserDTO> usuarios = service.obtenerTodos();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WpUserDTO> obtenerPorId(@PathVariable Long id) {
        Optional<WpUserDTO> usuario = service.obtenerPorId(id);
        return usuario.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/login/{userLogin}")
    public ResponseEntity<WpUserDTO> obtenerPorUserLogin(@PathVariable String userLogin) {
        Optional<WpUserDTO> usuario = service.obtenerPorUserLogin(userLogin);
        return usuario.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/email/{userEmail}")
    public ResponseEntity<WpUserDTO> obtenerPorUserEmail(@PathVariable String userEmail) {
        Optional<WpUserDTO> usuario = service.obtenerPorUserEmail(userEmail);
        return usuario.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<WpUserDTO> crear(@Validated @RequestBody WpUserDTO dto) {
        WpUserDTO usuarioGuardado = service.guardar(dto);
        return new ResponseEntity<>(usuarioGuardado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WpUserDTO> actualizar(@PathVariable Long id, @Validated @RequestBody WpUserDTO dto) {
        WpUserDTO usuarioActualizado = service.actualizar(id, dto);
        return ResponseEntity.ok(usuarioActualizado);
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

    @GetMapping("/login/{userLogin}/existe")
    public ResponseEntity<Boolean> existePorUserLogin(@PathVariable String userLogin) {
        boolean existe = service.existePorUserLogin(userLogin);
        return ResponseEntity.ok(existe);
    }

    @GetMapping("/email/{userEmail}/existe")
    public ResponseEntity<Boolean> existePorUserEmail(@PathVariable String userEmail) {
        boolean existe = service.existePorUserEmail(userEmail);
        return ResponseEntity.ok(existe);
    }
}