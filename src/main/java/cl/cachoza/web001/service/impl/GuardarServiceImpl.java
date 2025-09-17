package cl.cachoza.web001.service.impl;

import cl.cachoza.web001.dto.GuardarDTO;
import cl.cachoza.web001.entity.GuardarEntity;
import cl.cachoza.web001.repository.GuardarRepository;
import cl.cachoza.web001.service.GuardarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuardarServiceImpl implements GuardarService {

    private final GuardarRepository repository;

    @Autowired
    public GuardarServiceImpl(GuardarRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<GuardarDTO> obtenerPorProfesor(Long profesorId) {
        return repository.findByProfesorId(profesorId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<GuardarDTO> obtenerPorCurso(Long cursoId) {
        return repository.findByCursoId(cursoId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<GuardarDTO> obtenerPorInstrumento(Long instrumentoId) {
        return repository.findByInstrumentoId(instrumentoId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<GuardarDTO> obtenerPorPapel(Boolean papel) {
        return repository.findByPapel(papel)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<GuardarDTO> obtenerPorProfesorCursoInstrumento(Long profesorId, Long cursoId, Long instrumentoId) {
        return repository.findByProfesorIdAndCursoIdAndInstrumentoId(profesorId, cursoId, instrumentoId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public GuardarDTO obtenerPorId(Long id) {
        GuardarEntity entity = repository.findByIdGuardar(id)
                .orElseThrow(() -> new EntityNotFoundException("Guardar no encontrado con ID: " + id));
        return toDTO(entity);
    }

    @Override
    public GuardarDTO guardar(GuardarDTO dto) {
        GuardarEntity entity = toEntity(dto);
        GuardarEntity saved = repository.save(entity);
        return toDTO(saved);
    }

    @Override
    public GuardarDTO actualizar(Long id, GuardarDTO dto) {
        if (!repository.existsByIdGuardar(id)) {
            throw new EntityNotFoundException("Guardar no encontrado con ID: " + id);
        }
        
        GuardarEntity entity = toEntity(dto);
        entity.setIdGuardar(id);
        GuardarEntity updated = repository.save(entity);
        return toDTO(updated);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsByIdGuardar(id)) {
            throw new EntityNotFoundException("Guardar no encontrado con ID: " + id);
        }
        repository.deleteByIdGuardar(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return repository.existsByIdGuardar(id);
    }

    @Override
    public boolean existePorProfesorCursoInstrumento(Long profesorId, Long cursoId, Long instrumentoId) {
        return repository.existsByProfesorIdAndCursoIdAndInstrumentoId(profesorId, cursoId, instrumentoId);
    }

    private GuardarDTO toDTO(GuardarEntity entity) {
        return new GuardarDTO(
                entity.getIdGuardar(),
                entity.getProfesorId(),
                entity.getCursoId(),
                entity.getInstrumentoId(),
                entity.getValor(),
                entity.getPapel()
        );
    }

    private GuardarEntity toEntity(GuardarDTO dto) {
        return new GuardarEntity(
                dto.getProfesorId(),
                dto.getCursoId(),
                dto.getInstrumentoId(),
                dto.getValor(),
                dto.getPapel()
        );
    }
}