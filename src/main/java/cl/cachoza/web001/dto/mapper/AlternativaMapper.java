package cl.cachoza.web001.dto.mapper;

import cl.cachoza.web001.dto.AlternativaDTO;
import cl.cachoza.web001.entity.AlternativaEntity;

public class AlternativaMapper {

    public static AlternativaEntity toEntity(AlternativaDTO dto) {
        AlternativaEntity entity = new AlternativaEntity();
        entity.setIdAlternativa(dto.getIdAlternativa());
        entity.setPreguntaId(dto.getPreguntaId());
        entity.setOrden(dto.getOrden());
        entity.setAlternativaValor(dto.getAlternativaValor());
        return entity;
    }

    public static AlternativaDTO toDTO(AlternativaEntity entity) {
        return new AlternativaDTO(
            entity.getIdAlternativa(),
            entity.getPreguntaId(),
            entity.getOrden(),
            entity.getAlternativaValor()
        );
    }
}
