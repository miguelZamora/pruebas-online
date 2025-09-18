package cl.cachoza.web001.service.impl;

import cl.cachoza.web001.dto.PreguntaDTO;
import cl.cachoza.web001.entity.PreguntaEntity;
import cl.cachoza.web001.repository.PreguntaRepository;
import cl.cachoza.web001.service.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PreguntaServiceImpl implements PreguntaService {

    private final PreguntaRepository repository;

    @Autowired
    public PreguntaServiceImpl(PreguntaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PreguntaDTO> obtenerTodos() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PreguntaDTO> obtenerPorTipo(String tipo) {
        return repository.findByTipo(tipo)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PreguntaDTO> obtenerPorNivel(String nivel) {
        return repository.findByNivel(nivel)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PreguntaDTO> obtenerPorCurso(String curso) {
        return repository.findByCurso(curso)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PreguntaDTO> obtenerPorAsignatura(String asignatura) {
        return repository.findByAsignatura(asignatura)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PreguntaDTO> obtenerPorSemiOffline(Boolean semiOffline) {
        return repository.findBySemiOffline(semiOffline)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PreguntaDTO obtenerPorId(Long id) {
        PreguntaEntity entity = repository.findByIdPregunta(id)
                .orElseThrow(() -> new EntityNotFoundException("Pregunta no encontrada con ID: " + id));
        return toDTO(entity);
    }

    @Override
    public PreguntaDTO guardar(PreguntaDTO dto) {
        PreguntaEntity entity = toEntity(dto);
        PreguntaEntity saved = repository.save(entity);
        return toDTO(saved);
    }

    @Override
    public PreguntaDTO actualizar(Long id, PreguntaDTO dto) {
        if (!repository.existsByIdPregunta(id)) {
            throw new EntityNotFoundException("Pregunta no encontrada con ID: " + id);
        }
        
        PreguntaEntity entity = toEntity(dto);
        entity.setIdPregunta(id);
        PreguntaEntity updated = repository.save(entity);
        return toDTO(updated);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsByIdPregunta(id)) {
            throw new EntityNotFoundException("Pregunta no encontrada con ID: " + id);
        }
        repository.deleteByIdPregunta(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return repository.existsByIdPregunta(id);
    }

    @Override
    public boolean existePorIdAntiguo(String idAntiguo) {
        return repository.existsByIdAntiguo(idAntiguo);
    }

    private PreguntaDTO toDTO(PreguntaEntity entity) {
        PreguntaDTO dto = new PreguntaDTO(
                entity.getIdPregunta(),
                entity.getEnunciado(),
                entity.getTipo(),
                entity.getCantidadAlternativas(),
                entity.getIdAntiguo(),
                entity.getNivel(),
                entity.getCurso(),
                entity.getAsignatura(),
                entity.getEje(),
                entity.getDominioCognitivo(),
                entity.getObjetivoGeneral(),
                entity.getNombreEstimulo(),
                entity.getSemiOffline(),
                entity.getPeso()
        );
        
        // Set optional fields
        dto.setTextoAsociadoId(entity.getTextoAsociadoId());
        dto.setAutorItem(entity.getAutorItem());
        dto.setGeneroTextual(entity.getGeneroTextual());
        dto.setReferenciaCurricular(entity.getReferenciaCurricular());
        dto.setOahOf(entity.getOahOf());
        dto.setOacCmo(entity.getOacCmo());
        dto.setObjetivoEvaluacionEspecifico(entity.getObjetivoEvaluacionEspecifico());
        dto.setFuenteEstimulo(entity.getFuenteEstimulo());
        dto.setFuentesItem(entity.getFuentesItem());
        dto.setEstadoItem(entity.getEstadoItem());
        dto.setObservaciones(entity.getObservaciones());
        dto.setPuntajeRespuestasCorrecta(entity.getPuntajeRespuestasCorrecta());
        dto.setRespuestasParcialmenteCorrectas(entity.getRespuestasParcialmenteCorrectas());
        dto.setPuntajeRespuestasParcialmenteCorrectas(entity.getPuntajeRespuestasParcialmenteCorrectas());
        dto.setRespuestaCorrecta(entity.getRespuestaCorrecta());
        
        return dto;
    }

    private PreguntaEntity toEntity(PreguntaDTO dto) {
        PreguntaEntity entity = new PreguntaEntity(
                dto.getEnunciado(),
                dto.getTipo(),
                dto.getCantidadAlternativas(),
                dto.getIdAntiguo(),
                dto.getNivel(),
                dto.getCurso(),
                dto.getAsignatura(),
                dto.getEje(),
                dto.getDominioCognitivo(),
                dto.getObjetivoGeneral(),
                dto.getNombreEstimulo(),
                dto.getSemiOffline(),
                dto.getPeso()
        );
        
        // Set optional fields
        entity.setTextoAsociadoId(dto.getTextoAsociadoId());
        entity.setAutorItem(dto.getAutorItem());
        entity.setGeneroTextual(dto.getGeneroTextual());
        entity.setReferenciaCurricular(dto.getReferenciaCurricular());
        entity.setOahOf(dto.getOahOf());
        entity.setOacCmo(dto.getOacCmo());
        entity.setObjetivoEvaluacionEspecifico(dto.getObjetivoEvaluacionEspecifico());
        entity.setFuenteEstimulo(dto.getFuenteEstimulo());
        entity.setFuentesItem(dto.getFuentesItem());
        entity.setEstadoItem(dto.getEstadoItem());
        entity.setObservaciones(dto.getObservaciones());
        entity.setPuntajeRespuestasCorrecta(dto.getPuntajeRespuestasCorrecta());
        entity.setRespuestasParcialmenteCorrectas(dto.getRespuestasParcialmenteCorrectas());
        entity.setPuntajeRespuestasParcialmenteCorrectas(dto.getPuntajeRespuestasParcialmenteCorrectas());
        entity.setRespuestaCorrecta(dto.getRespuestaCorrecta());
        
        return entity;
    }
}