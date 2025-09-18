package cl.cachoza.web001.service.impl;

import cl.cachoza.web001.dto.TablaBDTO;
import cl.cachoza.web001.entity.TablaBEntity;
import cl.cachoza.web001.repository.TablaBRepository;
import cl.cachoza.web001.service.TablaBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TablaBServiceImpl implements TablaBService {

    private final TablaBRepository repository;

    @Autowired
    public TablaBServiceImpl(TablaBRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TablaBDTO> obtenerTodos() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TablaBDTO> obtenerPorPreguntaId(Integer preguntaId) {
        return repository.findByPreguntaId(preguntaId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TablaBDTO> obtenerPorOpcionContenido(String contenido) {
        return repository.findByOpcionContaining(contenido)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TablaBDTO> obtenerPorOrden(Integer orden) {
        return repository.findByOrden(orden)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TablaBDTO> obtenerPorPreguntaIdOrdenado(Integer preguntaId) {
        return repository.findByPreguntaIdOrderByOrdenAsc(preguntaId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TablaBDTO obtenerPorId(Long id) {
        TablaBEntity entity = repository.findByIdTablaB(id)
                .orElseThrow(() -> new EntityNotFoundException("Tabla B no encontrada con ID: " + id));
        return toDTO(entity);
    }

    @Override
    public TablaBDTO guardar(TablaBDTO dto) {
        TablaBEntity entity = toEntity(dto);
        TablaBEntity saved = repository.save(entity);
        return toDTO(saved);
    }

    @Override
    public TablaBDTO actualizar(Long id, TablaBDTO dto) {
        if (!repository.existsByIdTablaB(id)) {
            throw new EntityNotFoundException("Tabla B no encontrada con ID: " + id);
        }
        
        TablaBEntity entity = toEntity(dto);
        entity.setIdTablaB(id);
        TablaBEntity updated = repository.save(entity);
        return toDTO(updated);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsByIdTablaB(id)) {
            throw new EntityNotFoundException("Tabla B no encontrada con ID: " + id);
        }
        repository.deleteByIdTablaB(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return repository.existsByIdTablaB(id);
    }

    @Override
    public boolean existePorPreguntaYOpcion(Integer preguntaId, String opcion) {
        return repository.existsByPreguntaIdAndOpcion(preguntaId, opcion);
    }

    @Override
    public boolean existePorPreguntaYOrden(Integer preguntaId, Integer orden) {
        return repository.existsByPreguntaIdAndOrden(preguntaId, orden);
    }

    @Override
    public long contarPorPreguntaId(Integer preguntaId) {
        return repository.countByPreguntaId(preguntaId);
    }

    private TablaBDTO toDTO(TablaBEntity entity) {
        return new TablaBDTO(
                entity.getIdTablaB(),
                entity.getPreguntaId(),
                entity.getOpcion(),
                entity.getOrden()
        );
    }

    private TablaBEntity toEntity(TablaBDTO dto) {
        return new TablaBEntity(
                dto.getPreguntaId(),
                dto.getOpcion(),
                dto.getOrden()
        );
    }
}