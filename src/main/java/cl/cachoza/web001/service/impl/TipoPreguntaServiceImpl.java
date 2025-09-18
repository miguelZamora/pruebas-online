package cl.cachoza.web001.service.impl;

import cl.cachoza.web001.dto.TipoPreguntaDTO;
import cl.cachoza.web001.entity.TipoPreguntaEntity;
import cl.cachoza.web001.repository.TipoPreguntaRepository;
import cl.cachoza.web001.service.TipoPreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoPreguntaServiceImpl implements TipoPreguntaService {

    private final TipoPreguntaRepository repository;

    @Autowired
    public TipoPreguntaServiceImpl(TipoPreguntaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TipoPreguntaDTO> obtenerTodos() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TipoPreguntaDTO obtenerPorId(Long id) {
        TipoPreguntaEntity entity = repository.findByIdTipoPregunta(id)
                .orElseThrow(() -> new EntityNotFoundException("Tipo de pregunta no encontrado con ID: " + id));
        return toDTO(entity);
    }

    @Override
    public TipoPreguntaDTO obtenerPorNombre(String nombre) {
        TipoPreguntaEntity entity = repository.findByNombre(nombre)
                .orElseThrow(() -> new EntityNotFoundException("Tipo de pregunta no encontrado con nombre: " + nombre));
        return toDTO(entity);
    }

    @Override
    public TipoPreguntaDTO guardar(TipoPreguntaDTO dto) {
        TipoPreguntaEntity entity = toEntity(dto);
        TipoPreguntaEntity saved = repository.save(entity);
        return toDTO(saved);
    }

    @Override
    public TipoPreguntaDTO actualizar(Long id, TipoPreguntaDTO dto) {
        if (!repository.existsByIdTipoPregunta(id)) {
            throw new EntityNotFoundException("Tipo de pregunta no encontrado con ID: " + id);
        }
        
        TipoPreguntaEntity entity = toEntity(dto);
        entity.setIdTipoPregunta(id);
        TipoPreguntaEntity updated = repository.save(entity);
        return toDTO(updated);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsByIdTipoPregunta(id)) {
            throw new EntityNotFoundException("Tipo de pregunta no encontrado con ID: " + id);
        }
        repository.deleteByIdTipoPregunta(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return repository.existsByIdTipoPregunta(id);
    }

    @Override
    public boolean existePorNombre(String nombre) {
        return repository.existsByNombre(nombre);
    }

    private TipoPreguntaDTO toDTO(TipoPreguntaEntity entity) {
        return new TipoPreguntaDTO(
                entity.getIdTipoPregunta(),
                entity.getNombre(),
                entity.getDescripcion()
        );
    }

    private TipoPreguntaEntity toEntity(TipoPreguntaDTO dto) {
        return new TipoPreguntaEntity(
                dto.getNombre(),
                dto.getDescripcion()
        );
    }
}