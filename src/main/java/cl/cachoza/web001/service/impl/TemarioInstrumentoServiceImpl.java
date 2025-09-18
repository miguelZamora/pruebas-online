package cl.cachoza.web001.service.impl;

import cl.cachoza.web001.dto.TemarioInstrumentoDTO;
import cl.cachoza.web001.entity.TemarioInstrumentoEntity;
import cl.cachoza.web001.repository.TemarioInstrumentoRepository;
import cl.cachoza.web001.service.TemarioInstrumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TemarioInstrumentoServiceImpl implements TemarioInstrumentoService {

    private final TemarioInstrumentoRepository repository;

    @Autowired
    public TemarioInstrumentoServiceImpl(TemarioInstrumentoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TemarioInstrumentoDTO> obtenerPorInstrumento(Long instrumentoId) {
        return repository.findByInstrumentoId(instrumentoId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TemarioInstrumentoDTO> obtenerPorCurso(Long cursoId) {
        return repository.findByCursoId(cursoId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TemarioInstrumentoDTO obtenerPorId(Long id) {
        TemarioInstrumentoEntity entity = repository.findByIdTemario(id)
                .orElseThrow(() -> new EntityNotFoundException("Temario instrumento no encontrado con ID: " + id));
        return toDTO(entity);
    }

    @Override
    public TemarioInstrumentoDTO guardar(TemarioInstrumentoDTO dto) {
        TemarioInstrumentoEntity entity = toEntity(dto);
        TemarioInstrumentoEntity saved = repository.save(entity);
        return toDTO(saved);
    }

    @Override
    public TemarioInstrumentoDTO actualizar(Long id, TemarioInstrumentoDTO dto) {
        if (!repository.existsByIdTemario(id)) {
            throw new EntityNotFoundException("Temario instrumento no encontrado con ID: " + id);
        }
        
        TemarioInstrumentoEntity entity = toEntity(dto);
        entity.setIdTemario(id);
        TemarioInstrumentoEntity updated = repository.save(entity);
        return toDTO(updated);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsByIdTemario(id)) {
            throw new EntityNotFoundException("Temario instrumento no encontrado con ID: " + id);
        }
        repository.deleteByIdTemario(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return repository.existsByIdTemario(id);
    }

    @Override
    public boolean existePorInstrumentoYCurso(Long instrumentoId, Long cursoId) {
        return repository.existsByInstrumentoIdAndCursoId(instrumentoId, cursoId);
    }

    private TemarioInstrumentoDTO toDTO(TemarioInstrumentoEntity entity) {
        return new TemarioInstrumentoDTO(
                entity.getIdTemario(),
                entity.getInstrumentoId(),
                entity.getCursoId()
        );
    }

    private TemarioInstrumentoEntity toEntity(TemarioInstrumentoDTO dto) {
        return new TemarioInstrumentoEntity(
                dto.getInstrumentoId(),
                dto.getCursoId()
        );
    }
}