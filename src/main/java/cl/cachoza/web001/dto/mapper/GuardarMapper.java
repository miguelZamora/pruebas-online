package cl.cachoza.web001.dto.mapper;

import cl.cachoza.web001.dto.GuardarDTO;
import cl.cachoza.web001.entity.GuardarEntity;

public class GuardarMapper {

    public static GuardarEntity toEntity(GuardarDTO dto) {
        GuardarEntity entity = new GuardarEntity();
        entity.setIdGuardar(dto.getIdGuardar());
        entity.setProfesorId(dto.getProfesorId());
        entity.setCursoId(dto.getCursoId());
        entity.setInstrumentoId(dto.getInstrumentoId());
        entity.setValor(dto.getValor());
        entity.setPapel(dto.getPapel());
        return entity;
    }

    public static GuardarDTO toDTO(GuardarEntity entity) {
        return new GuardarDTO(
            entity.getIdGuardar(),
            entity.getProfesorId(),
            entity.getCursoId(),
            entity.getInstrumentoId(),
            entity.getValor(),
            entity.getPapel()
        );
    }
}