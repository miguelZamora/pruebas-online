package cl.cachoza.web001.dto.mapper;

import cl.cachoza.web001.dto.TablaBDTO;
import cl.cachoza.web001.entity.TablaBEntity;

public class TablaBMapper {

    public static TablaBEntity toEntity(TablaBDTO dto) {
        TablaBEntity entity = new TablaBEntity();
        entity.setIdTablaB(dto.getIdTablaB());
        entity.setPreguntaId(dto.getPreguntaId());
        entity.setOpcion(dto.getOpcion());
        entity.setOrden(dto.getOrden());
        return entity;
    }

    public static TablaBDTO toDTO(TablaBEntity entity) {
        return new TablaBDTO(
            entity.getIdTablaB(),
            entity.getPreguntaId(),
            entity.getOpcion(),
            entity.getOrden()
        );
    }
}