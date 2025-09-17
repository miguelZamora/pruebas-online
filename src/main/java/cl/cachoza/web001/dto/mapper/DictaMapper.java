package cl.cachoza.web001.dto.mapper;

import cl.cachoza.web001.dto.DictaDTO;
import cl.cachoza.web001.entity.DictaEntity;

public class DictaMapper {

    public static DictaEntity toEntity(DictaDTO dto) {
        DictaEntity entity = new DictaEntity();
        entity.setIdDicta(dto.getIdDicta());
        entity.setUserProfesorId(dto.getUserProfesorId());
        entity.setCodigoCursoId(dto.getCodigoCursoId());
        entity.setAsignaturaId(dto.getAsignaturaId());
        entity.setEstado(dto.getEstado());
        return entity;
    }

    public static DictaDTO toDTO(DictaEntity entity) {
        return new DictaDTO(
            entity.getIdDicta(),
            entity.getUserProfesorId(),
            entity.getCodigoCursoId(),
            entity.getAsignaturaId(),
            entity.getEstado()
        );
    }
}