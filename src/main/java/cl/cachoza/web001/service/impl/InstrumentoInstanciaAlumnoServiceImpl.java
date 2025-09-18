package cl.cachoza.web001.service.impl;

import cl.cachoza.web001.dto.InstrumentoInstanciaAlumnoDTO;
import cl.cachoza.web001.entity.InstrumentoInstanciaAlumnoEntity;
import cl.cachoza.web001.repository.InstrumentoInstanciaAlumnoRepository;
import cl.cachoza.web001.service.InstrumentoInstanciaAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstrumentoInstanciaAlumnoServiceImpl implements InstrumentoInstanciaAlumnoService {

    private final InstrumentoInstanciaAlumnoRepository repository;

    @Autowired
    public InstrumentoInstanciaAlumnoServiceImpl(InstrumentoInstanciaAlumnoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<InstrumentoInstanciaAlumnoDTO> obtenerPorInstanciaGrupo(Long instanciaGrupoId) {
        return repository.findByInstanciaGrupoId(instanciaGrupoId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<InstrumentoInstanciaAlumnoDTO> obtenerPorAlumno(Long alumnoId) {
        return repository.findByAlumnoId(alumnoId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<InstrumentoInstanciaAlumnoDTO> obtenerPorCurso(Long codigoCursoId) {
        return repository.findByCodigoCursoId(codigoCursoId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<InstrumentoInstanciaAlumnoDTO> obtenerPorInstrumento(Integer instrumentoId) {
        return repository.findByInstrumentoId(instrumentoId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public InstrumentoInstanciaAlumnoDTO obtenerPorId(Long id) {
        InstrumentoInstanciaAlumnoEntity entity = repository.findByIdIntruInstaAlumnos(id)
                .orElseThrow(() -> new EntityNotFoundException("Instrumento instancia alumno no encontrado con ID: " + id));
        return toDTO(entity);
    }

    @Override
    public InstrumentoInstanciaAlumnoDTO guardar(InstrumentoInstanciaAlumnoDTO dto) {
        InstrumentoInstanciaAlumnoEntity entity = toEntity(dto);
        InstrumentoInstanciaAlumnoEntity saved = repository.save(entity);
        return toDTO(saved);
    }

    @Override
    public InstrumentoInstanciaAlumnoDTO actualizar(Long id, InstrumentoInstanciaAlumnoDTO dto) {
        if (!repository.existsByIdIntruInstaAlumnos(id)) {
            throw new EntityNotFoundException("Instrumento instancia alumno no encontrado con ID: " + id);
        }
        
        InstrumentoInstanciaAlumnoEntity entity = toEntity(dto);
        entity.setIdIntruInstaAlumnos(id);
        InstrumentoInstanciaAlumnoEntity updated = repository.save(entity);
        return toDTO(updated);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsByIdIntruInstaAlumnos(id)) {
            throw new EntityNotFoundException("Instrumento instancia alumno no encontrado con ID: " + id);
        }
        repository.deleteByIdIntruInstaAlumnos(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return repository.existsByIdIntruInstaAlumnos(id);
    }

    @Override
    public boolean existePorAlumnoYInstancia(Long alumnoId, Long instanciaGrupoId) {
        return repository.existsByAlumnoIdAndInstanciaGrupoId(alumnoId, instanciaGrupoId);
    }

    private InstrumentoInstanciaAlumnoDTO toDTO(InstrumentoInstanciaAlumnoEntity entity) {
        return new InstrumentoInstanciaAlumnoDTO(
                entity.getIdIntruInstaAlumnos(),
                entity.getInstanciaGrupoId(),
                entity.getAlumnoId(),
                entity.getCodigoCursoId(),
                entity.getFechaCreacion(),
                entity.getEstado(),
                entity.getFechaInstancia(),
                entity.getInstrumentoId()
        );
    }

    private InstrumentoInstanciaAlumnoEntity toEntity(InstrumentoInstanciaAlumnoDTO dto) {
        return new InstrumentoInstanciaAlumnoEntity(
                dto.getInstanciaGrupoId(),
                dto.getAlumnoId(),
                dto.getCodigoCursoId(),
                dto.getEstado(),
                dto.getFechaInstancia(),
                dto.getInstrumentoId()
        );
    }
}