package cl.cachoza.web001.service.impl;

import cl.cachoza.web001.dto.GrupoPreguntaDTO;
import cl.cachoza.web001.entity.GrupoPreguntaEntity;
import cl.cachoza.web001.repository.GrupoPreguntaRepository;
import cl.cachoza.web001.service.GrupoPreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GrupoPreguntaServiceImpl implements GrupoPreguntaService {

    private final GrupoPreguntaRepository repository;

    @Autowired
    public GrupoPreguntaServiceImpl(GrupoPreguntaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<GrupoPreguntaDTO> obtenerPorInstrumento(Long instrumentoId) {
        return repository.findByInstrumentoId(instrumentoId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<GrupoPreguntaDTO> obtenerPorPregunta(Long preguntaId) {
        return repository.findByPreguntaId(preguntaId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<GrupoPreguntaDTO> obtenerPorOrden(Integer orden) {
        return repository.findByOrden(orden)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<GrupoPreguntaDTO> obtenerPorPreguntaNumero(Integer preguntaNumero) {
        return repository.findByPreguntaNumero(preguntaNumero)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public GrupoPreguntaDTO obtenerPorId(Long id) {
        GrupoPreguntaEntity entity = repository.findByIdGrupoPreguntas(id)
                .orElseThrow(() -> new EntityNotFoundException("Grupo de pregunta no encontrado con ID: " + id));
        return toDTO(entity);
    }

    @Override
    public GrupoPreguntaDTO guardar(GrupoPreguntaDTO dto) {
        GrupoPreguntaEntity entity = toEntity(dto);
        GrupoPreguntaEntity saved = repository.save(entity);
        return toDTO(saved);
    }

    @Override
    public GrupoPreguntaDTO actualizar(Long id, GrupoPreguntaDTO dto) {
        if (!repository.existsByIdGrupoPreguntas(id)) {
            throw new EntityNotFoundException("Grupo de pregunta no encontrado con ID: " + id);
        }
        
        GrupoPreguntaEntity entity = toEntity(dto);
        entity.setIdGrupoPreguntas(id);
        GrupoPreguntaEntity updated = repository.save(entity);
        return toDTO(updated);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsByIdGrupoPreguntas(id)) {
            throw new EntityNotFoundException("Grupo de pregunta no encontrado con ID: " + id);
        }
        repository.deleteByIdGrupoPreguntas(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return repository.existsByIdGrupoPreguntas(id);
    }

    @Override
    public boolean existePorInstrumentoYPregunta(Long instrumentoId, Long preguntaId) {
        return repository.existsByInstrumentoIdAndPreguntaId(instrumentoId, preguntaId);
    }

    @Override
    public boolean existePorInstrumentoYOrden(Long instrumentoId, Integer orden) {
        return repository.existsByInstrumentoIdAndOrden(instrumentoId, orden);
    }

    private GrupoPreguntaDTO toDTO(GrupoPreguntaEntity entity) {
        return new GrupoPreguntaDTO(
                entity.getIdGrupoPreguntas(),
                entity.getInstrumentoId(),
                entity.getPreguntaId(),
                entity.getOrden(),
                entity.getPreguntaNumero()
        );
    }

    private GrupoPreguntaEntity toEntity(GrupoPreguntaDTO dto) {
        return new GrupoPreguntaEntity(
                dto.getInstrumentoId(),
                dto.getPreguntaId(),
                dto.getOrden(),
                dto.getPreguntaNumero()
        );
    }
}