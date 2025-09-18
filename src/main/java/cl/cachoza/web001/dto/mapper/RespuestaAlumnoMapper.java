package cl.cachoza.web001.dto.mapper;

import cl.cachoza.web001.dto.RespuestaAlumnoDTO;
import cl.cachoza.web001.entity.RespuestaAlumnoEntity;

public class RespuestaAlumnoMapper {

    public static RespuestaAlumnoEntity toEntity(RespuestaAlumnoDTO dto) {
        RespuestaAlumnoEntity entity = new RespuestaAlumnoEntity();
        entity.setIdRespuestasAlumno(dto.getIdRespuestasAlumno());
        entity.setRespondeId(dto.getRespondeId());
        entity.setPreguntaId(dto.getPreguntaId());
        entity.setAlternativaEscogida(dto.getAlternativaEscogida());
        entity.setIntentoNumero(dto.getIntentoNumero());
        entity.setHora(dto.getHora());
        entity.setCorrecta(dto.getCorrecta());
        entity.setTipo(dto.getTipo());
        entity.setDesarrollo(dto.getDesarrollo());
        entity.setPapel(dto.getPapel());
        return entity;
    }

    public static RespuestaAlumnoDTO toDTO(RespuestaAlumnoEntity entity) {
        return new RespuestaAlumnoDTO(
            entity.getIdRespuestasAlumno(),
            entity.getRespondeId(),
            entity.getPreguntaId(),
            entity.getAlternativaEscogida(),
            entity.getIntentoNumero(),
            entity.getHora(),
            entity.getCorrecta(),
            entity.getTipo(),
            entity.getDesarrollo(),
            entity.getPapel()
        );
    }
}