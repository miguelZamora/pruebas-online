package cl.cachoza.web001.service.impl;

import cl.cachoza.web001.dto.RespuestaDTO;
import cl.cachoza.web001.entity.RespuestaEntity;
import cl.cachoza.web001.repository.RespuestaRepository;
import cl.cachoza.web001.service.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RespuestaServiceImpl implements RespuestaService {

    private final RespuestaRepository repository;

    @Autowired
    public RespuestaServiceImpl(RespuestaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<RespuestaDTO> obtenerTodos() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<RespuestaDTO> obtenerPorPregunta(Long preguntaId) {
        return repository.findByPreguntaId(preguntaId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<RespuestaDTO> obtenerPorRespuestaContenido(String contenido) {
        return repository.findByRespuestaContaining(contenido)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RespuestaDTO obtenerPorId(Long id) {
        RespuestaEntity entity = repository.findByIdRespuesta(id)
                .orElseThrow(() -> new EntityNotFoundException("Respuesta no encontrada con ID: " + id));
        return toDTO(entity);
    }

    @Override
    public RespuestaDTO guardar(RespuestaDTO dto) {
        RespuestaEntity entity = toEntity(dto);
        RespuestaEntity saved = repository.save(entity);
        return toDTO(saved);
    }

    @Override
    public RespuestaDTO actualizar(Long id, RespuestaDTO dto) {
        if (!repository.existsByIdRespuesta(id)) {
            throw new EntityNotFoundException("Respuesta no encontrada con ID: " + id);
        }
        
        RespuestaEntity entity = toEntity(dto);
        entity.setIdRespuesta(id);
        RespuestaEntity updated = repository.save(entity);
        return toDTO(updated);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsByIdRespuesta(id)) {
            throw new EntityNotFoundException("Respuesta no encontrada con ID: " + id);
        }
        repository.deleteByIdRespuesta(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return repository.existsByIdRespuesta(id);
    }

    @Override
    public boolean existePorPreguntaYRespuesta(Long preguntaId, String respuesta) {
        return repository.existsByPreguntaIdAndRespuesta(preguntaId, respuesta);
    }

    @Override
    public long contarPorPregunta(Long preguntaId) {
        return repository.countByPreguntaId(preguntaId);
    }

    private RespuestaDTO toDTO(RespuestaEntity entity) {
        return new RespuestaDTO(
                entity.getIdRespuesta(),
                entity.getPreguntaId(),
                entity.getRespuesta()
        );
    }

    private RespuestaEntity toEntity(RespuestaDTO dto) {
        return new RespuestaEntity(
                dto.getPreguntaId(),
                dto.getRespuesta()
        );
    }
}