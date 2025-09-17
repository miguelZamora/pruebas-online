package cl.cachoza.web001.service.impl;

import cl.cachoza.web001.dto.CursoAlumnoDTO;
import cl.cachoza.web001.entity.CursoAlumnoEntity;
import cl.cachoza.web001.repository.CursoAlumnoRepository;
import cl.cachoza.web001.service.CursoAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoAlumnoServiceImpl implements CursoAlumnoService {

    private final CursoAlumnoRepository repository;

    @Autowired
    public CursoAlumnoServiceImpl(CursoAlumnoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CursoAlumnoDTO> obtenerTodos() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CursoAlumnoDTO obtenerPorId(Long id) {
        CursoAlumnoEntity entity = repository.findByIdCursosAlumno(id)
                .orElseThrow(() -> new EntityNotFoundException("Inscripción no encontrada con ID: " + id));
        return toDTO(entity);
    }

    @Override
    public List<CursoAlumnoDTO> obtenerPorAlumno(Long alumnoId) {
        return repository.findByAlumnoId(alumnoId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CursoAlumnoDTO> obtenerPorCurso(Long cursoId) {
        return repository.findByCursoId(cursoId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CursoAlumnoDTO> obtenerPorEstado(Integer estado) {
        return repository.findByEstado(estado)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CursoAlumnoDTO guardar(CursoAlumnoDTO dto) {
        // Establecer fecha de inscripción si no viene
        if (dto.getFechaInscripcion() == null) {
            dto.setFechaInscripcion(LocalDateTime.now());
        }
        // Establecer estado por defecto si no viene
        if (dto.getEstado() == null) {
            dto.setEstado(1);
        }
        
        CursoAlumnoEntity entity = toEntity(dto);
        CursoAlumnoEntity saved = repository.save(entity);
        return toDTO(saved);
    }

    @Override
    public CursoAlumnoDTO actualizar(Long id, CursoAlumnoDTO dto) {
        if (!repository.existsByIdCursosAlumno(id)) {
            throw new EntityNotFoundException("Inscripción no encontrada con ID: " + id);
        }
        
        CursoAlumnoEntity entity = toEntity(dto);
        entity.setIdCursosAlumno(id);
        CursoAlumnoEntity updated = repository.save(entity);
        return toDTO(updated);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsByIdCursosAlumno(id)) {
            throw new EntityNotFoundException("Inscripción no encontrada con ID: " + id);
        }
        repository.deleteByIdCursosAlumno(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return repository.existsByIdCursosAlumno(id);
    }

    @Override
    public boolean existeInscripcion(Long alumnoId, Long cursoId) {
        return repository.existsByAlumnoIdAndCursoId(alumnoId, cursoId);
    }

    @Override
    public long contarPorCurso(Long cursoId) {
        return repository.countByCursoId(cursoId);
    }

    @Override
    public long contarPorAlumno(Long alumnoId) {
        return repository.countByAlumnoId(alumnoId);
    }

    private CursoAlumnoDTO toDTO(CursoAlumnoEntity entity) {
        return new CursoAlumnoDTO(
                entity.getIdCursosAlumno(),
                entity.getAlumnoId(),
                entity.getCursoId(),
                entity.getFechaInscripcion(),
                entity.getEstado()
        );
    }

    private CursoAlumnoEntity toEntity(CursoAlumnoDTO dto) {
        return new CursoAlumnoEntity(
                dto.getAlumnoId(),
                dto.getCursoId(),
                dto.getFechaInscripcion(),
                dto.getEstado()
        );
    }
}