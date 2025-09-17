package cl.cachoza.web001.dto.mapper;

import cl.cachoza.web001.dto.GuardarTablaDTO;
import cl.cachoza.web001.entity.GuardarTablaEntity;

public class GuardarTablaMapper {

    public static GuardarTablaEntity toEntity(GuardarTablaDTO dto) {
        GuardarTablaEntity entity = new GuardarTablaEntity();
        entity.setIdGuardarTabla(dto.getIdGuardarTabla());
        entity.setGuardarId(dto.getGuardarId());
        entity.setPosicion(dto.getPosicion());
        entity.setValor(dto.getValor());
        return entity;
    }

    public static GuardarTablaDTO toDTO(GuardarTablaEntity entity) {
        return new GuardarTablaDTO(
            entity.getIdGuardarTabla(),
            entity.getGuardarId(),
            entity.getPosicion(),
            entity.getValor()
        );
    }
}