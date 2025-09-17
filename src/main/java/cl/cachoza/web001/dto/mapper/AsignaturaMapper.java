package cl.cachoza.web001.dto.mapper;

import cl.cachoza.web001.dto.AsignaturaDTO;
import cl.cachoza.web001.entity.AsignaturaEntity;

public class AsignaturaMapper {

    public static AsignaturaEntity toEntity(AsignaturaDTO dto) {
        AsignaturaEntity entity = new AsignaturaEntity();
        entity.setIdAsignatura(dto.getIdAsignatura());
        entity.setNombre(dto.getNombre());
        entity.setDescripcion(dto.getDescripcion());
        return entity;
    }

    public static AsignaturaDTO toDTO(AsignaturaEntity entity) {
        return new AsignaturaDTO(
            entity.getIdAsignatura(),
            entity.getNombre(),
            entity.getDescripcion()
        );
    }
}