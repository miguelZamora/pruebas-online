package cl.cachoza.web001.dto.mapper;

import cl.cachoza.web001.dto.TipoPreguntaDTO;
import cl.cachoza.web001.entity.TipoPreguntaEntity;

public class TipoPreguntaMapper {

    public static TipoPreguntaEntity toEntity(TipoPreguntaDTO dto) {
        TipoPreguntaEntity entity = new TipoPreguntaEntity();
        entity.setIdTipoPregunta(dto.getIdTipoPregunta());
        entity.setNombre(dto.getNombre());
        entity.setDescripcion(dto.getDescripcion());
        return entity;
    }

    public static TipoPreguntaDTO toDTO(TipoPreguntaEntity entity) {
        return new TipoPreguntaDTO(
            entity.getIdTipoPregunta(),
            entity.getNombre(),
            entity.getDescripcion()
        );
    }
}