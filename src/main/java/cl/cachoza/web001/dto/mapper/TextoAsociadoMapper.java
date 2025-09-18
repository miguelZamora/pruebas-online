package cl.cachoza.web001.dto.mapper;

import cl.cachoza.web001.dto.TextoAsociadoDTO;
import cl.cachoza.web001.entity.TextoAsociadoEntity;

public class TextoAsociadoMapper {

    public static TextoAsociadoEntity toEntity(TextoAsociadoDTO dto) {
        TextoAsociadoEntity entity = new TextoAsociadoEntity();
        entity.setIdTextoAsociado(dto.getIdTextoAsociado());
        entity.setTexto(dto.getTexto());
        return entity;
    }

    public static TextoAsociadoDTO toDTO(TextoAsociadoEntity entity) {
        return new TextoAsociadoDTO(
            entity.getIdTextoAsociado(),
            entity.getTexto()
        );
    }
}