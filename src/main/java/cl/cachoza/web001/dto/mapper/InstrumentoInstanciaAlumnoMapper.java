package cl.cachoza.web001.dto.mapper;

import cl.cachoza.web001.dto.InstrumentoInstanciaAlumnoDTO;
import cl.cachoza.web001.entity.InstrumentoInstanciaAlumnoEntity;

public class InstrumentoInstanciaAlumnoMapper {

    public static InstrumentoInstanciaAlumnoEntity toEntity(InstrumentoInstanciaAlumnoDTO dto) {
        InstrumentoInstanciaAlumnoEntity entity = new InstrumentoInstanciaAlumnoEntity();
        entity.setIdIntruInstaAlumnos(dto.getIdIntruInstaAlumnos());
        entity.setInstanciaGrupoId(dto.getInstanciaGrupoId());
        entity.setAlumnoId(dto.getAlumnoId());
        entity.setCodigoCursoId(dto.getCodigoCursoId());
        entity.setFechaCreacion(dto.getFechaCreacion());
        entity.setEstado(dto.getEstado());
        entity.setFechaInstancia(dto.getFechaInstancia());
        entity.setInstrumentoId(dto.getInstrumentoId());
        return entity;
    }

    public static InstrumentoInstanciaAlumnoDTO toDTO(InstrumentoInstanciaAlumnoEntity entity) {
        return new InstrumentoInstanciaAlumnoDTO(
            entity.getIdIntruInstaAlumnos(),
            entity.getInstanciaGrupoId(),
            entity.getAlumnoId(),
            entity.getCodigoCursoId(),
            entity.getFechaCreacion(),
            entity.getEstado(),
            entity.getFechaInstancia(),
            entity.getInstrumentoId()
        );
    }
}