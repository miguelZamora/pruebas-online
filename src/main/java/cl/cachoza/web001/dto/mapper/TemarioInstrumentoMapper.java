package cl.cachoza.web001.dto.mapper;

import cl.cachoza.web001.dto.TemarioInstrumentoDTO;
import cl.cachoza.web001.entity.TemarioInstrumentoEntity;

public class TemarioInstrumentoMapper {

    public static TemarioInstrumentoEntity toEntity(TemarioInstrumentoDTO dto) {
        TemarioInstrumentoEntity entity = new TemarioInstrumentoEntity();
        entity.setIdTemario(dto.getIdTemario());
        entity.setInstrumentoId(dto.getInstrumentoId());
        entity.setCursoId(dto.getCursoId());
        return entity;
    }

    public static TemarioInstrumentoDTO toDTO(TemarioInstrumentoEntity entity) {
        return new TemarioInstrumentoDTO(
            entity.getIdTemario(),
            entity.getInstrumentoId(),
            entity.getCursoId()
        );
    }
}