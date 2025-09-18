package cl.cachoza.web001.controller;

import cl.cachoza.web001.dto.PreguntaFrecuenteBitacoraDTO;
import cl.cachoza.web001.service.PreguntaFrecuenteBitacoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/preguntas-frecuentes-bitacora")
public class PreguntaFrecuenteBitacoraController {

    private final PreguntaFrecuenteBitacoraService service;

    @Autowired
    public PreguntaFrecuenteBitacoraController(PreguntaFrecuenteBitacoraService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PreguntaFrecuenteBitacoraDTO>> obtenerTodos() {
        List<PreguntaFrecuenteBitacoraDTO> bitacoras = service.obtenerTodos();
        return ResponseEntity.ok(bitacoras);
    }

    @GetMapping("/busqueda/{busqueda}")
    public ResponseEntity<List<PreguntaFrecuenteBitacoraDTO>> obtenerPorBusqueda(@PathVariable String busqueda) {
        List<PreguntaFrecuenteBitacoraDTO> bitacoras = service.obtenerPorBusqueda(busqueda);
        return ResponseEntity.ok(bitacoras);
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<PreguntaFrecuenteBitacoraDTO>> obtenerPorUsuario(@PathVariable Long idUsuario) {
        List<PreguntaFrecuenteBitacoraDTO> bitacoras = service.obtenerPorUsuario(idUsuario);
        return ResponseEntity.ok(bitacoras);
    }

    @GetMapping("/ip/{ip}")
    public ResponseEntity<List<PreguntaFrecuenteBitacoraDTO>> obtenerPorIp(@PathVariable String ip) {
        List<PreguntaFrecuenteBitacoraDTO> bitacoras = service.obtenerPorIp(ip);
        return ResponseEntity.ok(bitacoras);
    }

    @GetMapping("/fechas")
    public ResponseEntity<List<PreguntaFrecuenteBitacoraDTO>> obtenerPorRangoFechas(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fin) {
        List<PreguntaFrecuenteBitacoraDTO> bitacoras = service.obtenerPorRangoFechas(inicio, fin);
        return ResponseEntity.ok(bitacoras);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PreguntaFrecuenteBitacoraDTO> obtenerPorId(@PathVariable Long id) {
        PreguntaFrecuenteBitacoraDTO bitacora = service.obtenerPorId(id);
        return ResponseEntity.ok(bitacora);
    }

    @PostMapping
    public ResponseEntity<PreguntaFrecuenteBitacoraDTO> crear(@Validated @RequestBody PreguntaFrecuenteBitacoraDTO dto) {
        PreguntaFrecuenteBitacoraDTO bitacoraGuardada = service.guardar(dto);
        return new ResponseEntity<>(bitacoraGuardada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PreguntaFrecuenteBitacoraDTO> actualizar(@PathVariable Long id, @Validated @RequestBody PreguntaFrecuenteBitacoraDTO dto) {
        PreguntaFrecuenteBitacoraDTO bitacoraActualizada = service.actualizar(id, dto);
        return ResponseEntity.ok(bitacoraActualizada);
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

    @GetMapping("/contar/usuario/{idUsuario}")
    public ResponseEntity<Long> contarPorUsuario(@PathVariable Long idUsuario) {
        long count = service.contarPorUsuario(idUsuario);
        return ResponseEntity.ok(count);
    }

    @GetMapping("/contar/busqueda/{busqueda}")
    public ResponseEntity<Long> contarPorBusqueda(@PathVariable String busqueda) {
        long count = service.contarPorBusqueda(busqueda);
        return ResponseEntity.ok(count);
    }
}