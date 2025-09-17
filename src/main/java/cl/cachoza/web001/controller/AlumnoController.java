package cl.cachoza.web001.controller;

import cl.cachoza.web001.dto.AlumnoDTO;
import cl.cachoza.web001.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    private final AlumnoService service;

    @Autowired
    public AlumnoController(AlumnoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AlumnoDTO>> obtenerTodos() {
        List<AlumnoDTO> alumnos = service.obtenerTodos();
        return ResponseEntity.ok(alumnos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlumnoDTO> obtenerPorId(@PathVariable Long id) {
        AlumnoDTO alumno = service.obtenerPorId(id);
        return ResponseEntity.ok(alumno);
    }

    @GetMapping("/usuario/{usuario}")
    public ResponseEntity<AlumnoDTO> obtenerPorUsuario(@PathVariable String usuario) {
        AlumnoDTO alumno = service.obtenerPorUsuario(usuario);
        return ResponseEntity.ok(alumno);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<AlumnoDTO>> buscarPorNombres(@RequestParam String nombres) {
        List<AlumnoDTO> alumnos = service.buscarPorNombres(nombres);
        return ResponseEntity.ok(alumnos);
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<AlumnoDTO>> obtenerPorEstado(@PathVariable Boolean estado) {
        List<AlumnoDTO> alumnos = service.obtenerPorEstado(estado);
        return ResponseEntity.ok(alumnos);
    }

    @PostMapping
    public ResponseEntity<AlumnoDTO> crear(@Validated @RequestBody AlumnoDTO dto) {
        AlumnoDTO alumnoGuardado = service.guardar(dto);
        return new ResponseEntity<>(alumnoGuardado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlumnoDTO> actualizar(@PathVariable Long id, @Validated @RequestBody AlumnoDTO dto) {
        AlumnoDTO alumnoActualizado = service.actualizar(id, dto);
        return ResponseEntity.ok(alumnoActualizado);
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

    @GetMapping("/usuario/{usuario}/existe")
    public ResponseEntity<Boolean> existePorUsuario(@PathVariable String usuario) {
        boolean existe = service.existePorUsuario(usuario);
        return ResponseEntity.ok(existe);
    }
}