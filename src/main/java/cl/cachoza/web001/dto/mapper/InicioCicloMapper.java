package cl.cachoza.web001.dto.mapper;

import cl.cachoza.web001.dto.InicioCicloDTO;
import cl.cachoza.web001.entity.InicioCicloEntity;

public class InicioCicloMapper {

    public static InicioCicloEntity toEntity(InicioCicloDTO dto) {
        InicioCicloEntity entity = new InicioCicloEntity();
        entity.setIdInicioCiclo(dto.getIdInicioCiclo());
        entity.setUsuarioIdWp(dto.getUsuarioIdWp());
        entity.setRbdId(dto.getRbdId());
        return entity;
    }

    public static InicioCicloDTO toDTO(InicioCicloEntity entity) {
        return new InicioCicloDTO(
            entity.getIdInicioCiclo(),
            entity.getUsuarioIdWp(),
            entity.getRbdId()
        );
    }
}