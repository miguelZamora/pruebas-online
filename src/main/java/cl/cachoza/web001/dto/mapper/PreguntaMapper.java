package cl.cachoza.web001.dto.mapper;

import cl.cachoza.web001.dto.PreguntaDTO;
import cl.cachoza.web001.entity.PreguntaEntity;

public class PreguntaMapper {

    public static PreguntaEntity toEntity(PreguntaDTO dto) {
        PreguntaEntity entity = new PreguntaEntity();
        entity.setIdPregunta(dto.getIdPregunta());
        entity.setEnunciado(dto.getEnunciado());
        entity.setTipo(dto.getTipo());
        entity.setCantidadAlternativas(dto.getCantidadAlternativas());
        entity.setTextoAsociadoId(dto.getTextoAsociadoId());
        entity.setIdAntiguo(dto.getIdAntiguo());
        entity.setNivel(dto.getNivel());
        entity.setCurso(dto.getCurso());
        entity.setAsignatura(dto.getAsignatura());
        entity.setEje(dto.getEje());
        entity.setDominioCognitivo(dto.getDominioCognitivo());
        entity.setObjetivoGeneral(dto.getObjetivoGeneral());
        entity.setNombreEstimulo(dto.getNombreEstimulo());
        entity.setSemiOffline(dto.getSemiOffline());
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
        entity.setPeso(dto.getPeso());
        return entity;
    }

    public static PreguntaDTO toDTO(PreguntaEntity entity) {
        return new PreguntaDTO(
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
    }
}