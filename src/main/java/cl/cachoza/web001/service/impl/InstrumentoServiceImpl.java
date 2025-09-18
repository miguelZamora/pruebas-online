package cl.cachoza.web001.service.impl;

import cl.cachoza.web001.dto.InstrumentoDTO;
import cl.cachoza.web001.entity.InstrumentoEntity;
import cl.cachoza.web001.repository.InstrumentoRepository;
import cl.cachoza.web001.service.InstrumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstrumentoServiceImpl implements InstrumentoService {

    private final InstrumentoRepository repository;

    @Autowired
    public InstrumentoServiceImpl(InstrumentoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<InstrumentoDTO> obtenerTodos() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<InstrumentoDTO> obtenerPorNombre(String nombre) {
        return repository.findByNombreContaining(nombre)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<InstrumentoDTO> obtenerPorCantidadPreguntas(Integer cantidadPreguntas) {
        return repository.findByCantidadDePreguntas(cantidadPreguntas)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<InstrumentoDTO> obtenerPorVisibilidad(Integer visible) {
        return repository.findByVisible(visible)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public InstrumentoDTO obtenerPorId(Long id) {
        InstrumentoEntity entity = repository.findByIdInstrumento(id)
                .orElseThrow(() -> new EntityNotFoundException("Instrumento no encontrado con ID: " + id));
        return toDTO(entity);
    }

    @Override
    public InstrumentoDTO guardar(InstrumentoDTO dto) {
        InstrumentoEntity entity = toEntity(dto);
        InstrumentoEntity saved = repository.save(entity);
        return toDTO(saved);
    }

    @Override
    public InstrumentoDTO actualizar(Long id, InstrumentoDTO dto) {
        if (!repository.existsByIdInstrumento(id)) {
            throw new EntityNotFoundException("Instrumento no encontrado con ID: " + id);
        }
        
        InstrumentoEntity entity = toEntity(dto);
        entity.setIdInstrumento(id);
        InstrumentoEntity updated = repository.save(entity);
        return toDTO(updated);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsByIdInstrumento(id)) {
            throw new EntityNotFoundException("Instrumento no encontrado con ID: " + id);
        }
        repository.deleteByIdInstrumento(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return repository.existsByIdInstrumento(id);
    }

    @Override
    public boolean existePorNombre(String nombre) {
        return repository.existsByNombre(nombre);
    }

    private InstrumentoDTO toDTO(InstrumentoEntity entity) {
        return new InstrumentoDTO(
                entity.getIdInstrumento(),
                entity.getNombre(),
                entity.getDescripcion(),
                entity.getCantidadDePreguntas(),
                entity.getInsuficiente(),
                entity.getAdecuado(),
                entity.getVisible()
        );
    }

    private InstrumentoEntity toEntity(InstrumentoDTO dto) {
        return new InstrumentoEntity(
                dto.getNombre(),
                dto.getDescripcion(),
                dto.getCantidadDePreguntas(),
                dto.getInsuficiente(),
                dto.getAdecuado(),
                dto.getVisible()
        );
    }
}