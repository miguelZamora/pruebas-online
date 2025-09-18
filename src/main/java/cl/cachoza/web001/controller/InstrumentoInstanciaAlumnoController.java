package cl.cachoza.web001.controller;

import cl.cachoza.web001.dto.InstrumentoInstanciaAlumnoDTO;
import cl.cachoza.web001.service.InstrumentoInstanciaAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instrumento-instancia-alumnos")
public class InstrumentoInstanciaAlumnoController {

    private final InstrumentoInstanciaAlumnoService service;

    @Autowired
    public InstrumentoInstanciaAlumnoController(InstrumentoInstanciaAlumnoService service) {
        this.service = service;
    }

    @GetMapping("/instancia-grupo/{id}")
    public ResponseEntity<List<InstrumentoInstanciaAlumnoDTO>> getByInstanciaGrupo(@PathVariable Long id) {
        List<InstrumentoInstanciaAlumnoDTO> instancias = service.obtenerPorInstanciaGrupo(id);
        return ResponseEntity.ok(instancias);
    }

    @GetMapping("/alumno/{id}")
    public ResponseEntity<List<InstrumentoInstanciaAlumnoDTO>> getByAlumno(@PathVariable Long id) {
        List<InstrumentoInstanciaAlumnoDTO> instancias = service.obtenerPorAlumno(id);
        return ResponseEntity.ok(instancias);
    }

    @GetMapping("/curso/{id}")
    public ResponseEntity<List<InstrumentoInstanciaAlumnoDTO>> getByCurso(@PathVariable Long id) {
        List<InstrumentoInstanciaAlumnoDTO> instancias = service.obtenerPorCurso(id);
        return ResponseEntity.ok(instancias);
    }

    @GetMapping("/instrumento/{id}")
    public ResponseEntity<List<InstrumentoInstanciaAlumnoDTO>> getByInstrumento(@PathVariable Integer id) {
        List<InstrumentoInstanciaAlumnoDTO> instancias = service.obtenerPorInstrumento(id);
        return ResponseEntity.ok(instancias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstrumentoInstanciaAlumnoDTO> getById(@PathVariable Long id) {
        InstrumentoInstanciaAlumnoDTO instancia = service.obtenerPorId(id);
        return ResponseEntity.ok(instancia);
    }

    @PostMapping
    public ResponseEntity<InstrumentoInstanciaAlumnoDTO> crear(@Validated @RequestBody InstrumentoInstanciaAlumnoDTO dto) {
        InstrumentoInstanciaAlumnoDTO instanciaGuardada = service.guardar(dto);
        return new ResponseEntity<>(instanciaGuardada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InstrumentoInstanciaAlumnoDTO> actualizar(@PathVariable Long id, @Validated @RequestBody InstrumentoInstanciaAlumnoDTO dto) {
        InstrumentoInstanciaAlumnoDTO instanciaActualizada = service.actualizar(id, dto);
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

    @GetMapping("/existe/alumno/{alumnoId}/instancia/{instanciaGrupoId}")
    public ResponseEntity<Boolean> existePorAlumnoYInstancia(@PathVariable Long alumnoId, @PathVariable Long instanciaGrupoId) {
        boolean existe = service.existePorAlumnoYInstancia(alumnoId, instanciaGrupoId);
        return ResponseEntity.ok(existe);
    }
}