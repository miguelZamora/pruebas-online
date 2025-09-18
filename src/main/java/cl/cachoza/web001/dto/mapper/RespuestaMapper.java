package cl.cachoza.web001.dto.mapper;

import cl.cachoza.web001.dto.RespuestaDTO;
import cl.cachoza.web001.entity.RespuestaEntity;

public class RespuestaMapper {

    public static RespuestaEntity toEntity(RespuestaDTO dto) {
        RespuestaEntity entity = new RespuestaEntity();
        entity.setIdRespuesta(dto.getIdRespuesta());
        entity.setPreguntaId(dto.getPreguntaId());
        entity.setRespuesta(dto.getRespuesta());
        return entity;
    }

    public static RespuestaDTO toDTO(RespuestaEntity entity) {
        return new RespuestaDTO(
            entity.getIdRespuesta(),
            entity.getPreguntaId(),
            entity.getRespuesta()
        );
    }
}