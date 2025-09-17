package cl.cachoza.web001.dto.mapper;

import cl.cachoza.web001.dto.CursoDTO;
import cl.cachoza.web001.entity.CursoEntity;

public class CursoMapper {

    public static CursoEntity toEntity(CursoDTO dto) {
        CursoEntity entity = new CursoEntity();
        entity.setIdCurso(dto.getIdCurso());
        entity.setRbdId(dto.getRbdId());
        entity.setCodigoNivel(dto.getCodigoNivel());
        entity.setLetra(dto.getLetra());
        entity.setCodigoCurso(dto.getCodigoCurso());
        entity.setAnio(dto.getAnio());
        entity.setEstado(dto.getEstado());
        return entity;
    }

    public static CursoDTO toDTO(CursoEntity entity) {
        return new CursoDTO(
            entity.getIdCurso(),
            entity.getRbdId(),
            entity.getCodigoNivel(),
            entity.getLetra(),
            entity.getCodigoCurso(),
            entity.getAnio(),
            entity.getEstado()
        );
    }
}