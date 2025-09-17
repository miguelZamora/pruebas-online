package cl.cachoza.web001.dto.mapper;

import cl.cachoza.web001.dto.EstablecimientoDTO;
import cl.cachoza.web001.entity.EstablecimientoEntity;

public class EstablecimientoMapper {

    public static EstablecimientoEntity toEntity(EstablecimientoDTO dto) {
        EstablecimientoEntity entity = new EstablecimientoEntity();
        entity.setIdEstablecimiento(dto.getIdEstablecimiento());
        entity.setRbd(dto.getRbd());
        entity.setDvrbd(dto.getDvrbd());
        entity.setNombre(dto.getNombre());
        entity.setEliminar(dto.getEliminar());
        return entity;
    }

    public static EstablecimientoDTO toDTO(EstablecimientoEntity entity) {
        return new EstablecimientoDTO(
            entity.getIdEstablecimiento(),
            entity.getRbd(),
            entity.getDvrbd(),
            entity.getNombre(),
            entity.getEliminar()
        );
    }
}