package cl.cachoza.web001.dto.mapper;

import cl.cachoza.web001.dto.PreguntaFrecuenteDTO;
import cl.cachoza.web001.entity.PreguntaFrecuenteEntity;

public class PreguntaFrecuenteMapper {

    public static PreguntaFrecuenteEntity toEntity(PreguntaFrecuenteDTO dto) {
        PreguntaFrecuenteEntity entity = new PreguntaFrecuenteEntity();
        entity.setId(dto.getId());
        entity.setPalabrasClaves(dto.getPalabrasClaves());
        entity.setRespuesta(dto.getRespuesta());
        entity.setIdUsuario(dto.getIdUsuario());
        entity.setComentarios(dto.getComentarios());
        return entity;
    }

    public static PreguntaFrecuenteDTO toDTO(PreguntaFrecuenteEntity entity) {
        return new PreguntaFrecuenteDTO(
            entity.getId(),
            entity.getPalabrasClaves(),
            entity.getRespuesta(),
            entity.getIdUsuario(),
            entity.getComentarios()
        );
    }
}