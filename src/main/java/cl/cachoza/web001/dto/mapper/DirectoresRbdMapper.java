package cl.cachoza.web001.dto.mapper;

import cl.cachoza.web001.dto.DirectoresRbdDTO;
import cl.cachoza.web001.entity.DirectoresRbdEntity;

public class DirectoresRbdMapper {

    public static DirectoresRbdEntity toEntity(DirectoresRbdDTO dto) {
        DirectoresRbdEntity entity = new DirectoresRbdEntity();
        entity.setIdUsuariosDirectores(dto.getIdUsuariosDirectores());
        entity.setRut(dto.getRut());
        entity.setRbd(dto.getRbd());
        entity.setTipoW(dto.getTipoW());
        entity.setOrigen(dto.getOrigen());
        entity.setEsTest(dto.getEsTest());
        entity.setFechaCreacion(dto.getFechaCreacion());
        return entity;
    }

    public static DirectoresRbdDTO toDTO(DirectoresRbdEntity entity) {
        return new DirectoresRbdDTO(
            entity.getIdUsuariosDirectores(),
            entity.getRut(),
            entity.getRbd(),
            entity.getTipoW(),
            entity.getOrigen(),
            entity.getEsTest(),
            entity.getFechaCreacion()
        );
    }
}