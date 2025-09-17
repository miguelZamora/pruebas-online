package cl.cachoza.web001.service.impl;

import cl.cachoza.web001.dto.DictaDTO;
import cl.cachoza.web001.entity.DictaEntity;
import cl.cachoza.web001.repository.DictaRepository;
import cl.cachoza.web001.service.DictaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DictaServiceImpl implements DictaService {

    private final DictaRepository repository;

    @Autowired
    public DictaServiceImpl(DictaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DictaDTO> obtenerPorProfesor(Long userProfesorId) {
        return repository.findByUserProfesorId(userProfesorId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DictaDTO> obtenerPorCurso(Long codigoCursoId) {
        return repository.findByCodigoCursoId(codigoCursoId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DictaDTO> obtenerPorAsignatura(Long asignaturaId) {
        return repository.findByAsignaturaId(asignaturaId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DictaDTO obtenerPorId(Long id) {
        DictaEntity entity = repository.findByIdDicta(id)
                .orElseThrow(() -> new EntityNotFoundException("Dicta no encontrada con ID: " + id));
        return toDTO(entity);
    }

    @Override
    public DictaDTO guardar(DictaDTO dto) {
        DictaEntity entity = toEntity(dto);
        DictaEntity saved = repository.save(entity);
        return toDTO(saved);
    }

    @Override
    public DictaDTO actualizar(Long id, DictaDTO dto) {
        if (!repository.existsByIdDicta(id)) {
            throw new EntityNotFoundException("Dicta no encontrada con ID: " + id);
        }
        
        DictaEntity entity = toEntity(dto);
        entity.setIdDicta(id);
        DictaEntity updated = repository.save(entity);
        return toDTO(updated);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsByIdDicta(id)) {
            throw new EntityNotFoundException("Dicta no encontrada con ID: " + id);
        }
        repository.deleteByIdDicta(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return repository.existsByIdDicta(id);
    }

    @Override
    public boolean existePorProfesorCursoAsignatura(Long userProfesorId, Long codigoCursoId, Long asignaturaId) {
        return repository.existsByUserProfesorIdAndCodigoCursoIdAndAsignaturaId(userProfesorId, codigoCursoId, asignaturaId);
    }

    private DictaDTO toDTO(DictaEntity entity) {
        return new DictaDTO(
                entity.getIdDicta(),
                entity.getUserProfesorId(),
                entity.getCodigoCursoId(),
                entity.getAsignaturaId(),
                entity.getEstado()
        );
    }

    private DictaEntity toEntity(DictaDTO dto) {
        return new DictaEntity(
                dto.getUserProfesorId(),
                dto.getCodigoCursoId(),
                dto.getAsignaturaId(),
                dto.getEstado()
        );
    }
}