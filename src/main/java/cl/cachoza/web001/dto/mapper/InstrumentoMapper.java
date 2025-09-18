package cl.cachoza.web001.dto.mapper;

import cl.cachoza.web001.dto.InstrumentoDTO;
import cl.cachoza.web001.entity.InstrumentoEntity;

public class InstrumentoMapper {

    public static InstrumentoEntity toEntity(InstrumentoDTO dto) {
        InstrumentoEntity entity = new InstrumentoEntity();
        entity.setIdInstrumento(dto.getIdInstrumento());
        entity.setNombre(dto.getNombre());
        entity.setDescripcion(dto.getDescripcion());
        entity.setCantidadDePreguntas(dto.getCantidadDePreguntas());
        entity.setInsuficiente(dto.getInsuficiente());
        entity.setAdecuado(dto.getAdecuado());
        entity.setVisible(dto.getVisible());
        return entity;
    }

    public static InstrumentoDTO toDTO(InstrumentoEntity entity) {
        return new InstrumentoDTO(
            entity.getIdInstrumento(),
            entity.getNombre(),
            entity.getDescripcion(),
            entity.getCantidadDePreguntas(),
            entity.getInsuficiente(),
            entity.getAdecuado(),
            entity.getVisible()
        );
    }
}