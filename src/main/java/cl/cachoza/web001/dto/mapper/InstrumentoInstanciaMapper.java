package cl.cachoza.web001.dto.mapper;

import cl.cachoza.web001.dto.InstrumentoInstanciaDTO;
import cl.cachoza.web001.entity.InstrumentoInstanciaEntity;

public class InstrumentoInstanciaMapper {

    public static InstrumentoInstanciaEntity toEntity(InstrumentoInstanciaDTO dto) {
        InstrumentoInstanciaEntity entity = new InstrumentoInstanciaEntity();
        entity.setIdInstancia(dto.getIdInstancia());
        entity.setInstrumentoId(dto.getInstrumentoId());
        entity.setEstado(dto.getEstado());
        entity.setFechaCreacion(dto.getFechaCreacion());
        entity.setCodigoCursoId(dto.getCodigoCursoId());
        entity.setFechaInstancia(dto.getFechaInstancia());
        entity.setEditableOffline(dto.getEditableOffline());
        return entity;
    }

    public static InstrumentoInstanciaDTO toDTO(InstrumentoInstanciaEntity entity) {
        return new InstrumentoInstanciaDTO(
            entity.getIdInstancia(),
            entity.getInstrumentoId(),
            entity.getEstado(),
            entity.getFechaCreacion(),
            entity.getCodigoCursoId(),
            entity.getFechaInstancia(),
            entity.getEditableOffline()
        );
    }
}