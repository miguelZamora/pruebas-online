package cl.cachoza.web001.dto.mapper;

import cl.cachoza.web001.dto.RespondeDTO;
import cl.cachoza.web001.entity.RespondeEntity;

public class RespondeMapper {

    public static RespondeEntity toEntity(RespondeDTO dto) {
        RespondeEntity entity = new RespondeEntity();
        entity.setIdResponde(dto.getIdResponde());
        entity.setInstrumentoInstanciaId(dto.getInstrumentoInstanciaId());
        entity.setAlumnoId(dto.getAlumnoId());
        return entity;
    }

    public static RespondeDTO toDTO(RespondeEntity entity) {
        return new RespondeDTO(
            entity.getIdResponde(),
            entity.getInstrumentoInstanciaId(),
            entity.getAlumnoId()
        );
    }
}