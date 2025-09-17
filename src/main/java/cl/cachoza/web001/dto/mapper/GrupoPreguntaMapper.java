package cl.cachoza.web001.dto.mapper;

import cl.cachoza.web001.dto.GrupoPreguntaDTO;
import cl.cachoza.web001.entity.GrupoPreguntaEntity;

public class GrupoPreguntaMapper {

    public static GrupoPreguntaEntity toEntity(GrupoPreguntaDTO dto) {
        GrupoPreguntaEntity entity = new GrupoPreguntaEntity();
        entity.setIdGrupoPreguntas(dto.getIdGrupoPreguntas());
        entity.setInstrumentoId(dto.getInstrumentoId());
        entity.setPreguntaId(dto.getPreguntaId());
        entity.setOrden(dto.getOrden());
        entity.setPreguntaNumero(dto.getPreguntaNumero());
        return entity;
    }

    public static GrupoPreguntaDTO toDTO(GrupoPreguntaEntity entity) {
        return new GrupoPreguntaDTO(
            entity.getIdGrupoPreguntas(),
            entity.getInstrumentoId(),
            entity.getPreguntaId(),
            entity.getOrden(),
            entity.getPreguntaNumero()
        );
    }
}