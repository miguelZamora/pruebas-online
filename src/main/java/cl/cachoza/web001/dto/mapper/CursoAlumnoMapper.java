package cl.cachoza.web001.dto.mapper;

import cl.cachoza.web001.dto.CursoAlumnoDTO;
import cl.cachoza.web001.entity.CursoAlumnoEntity;

public class CursoAlumnoMapper {

    public static CursoAlumnoEntity toEntity(CursoAlumnoDTO dto) {
        CursoAlumnoEntity entity = new CursoAlumnoEntity();
        entity.setIdCursosAlumno(dto.getIdCursosAlumno());
        entity.setAlumnoId(dto.getAlumnoId());
        entity.setCursoId(dto.getCursoId());
        entity.setFechaInscripcion(dto.getFechaInscripcion());
        entity.setEstado(dto.getEstado());
        return entity;
    }

    public static CursoAlumnoDTO toDTO(CursoAlumnoEntity entity) {
        return new CursoAlumnoDTO(
            entity.getIdCursosAlumno(),
            entity.getAlumnoId(),
            entity.getCursoId(),
            entity.getFechaInscripcion(),
            entity.getEstado()
        );
    }
}