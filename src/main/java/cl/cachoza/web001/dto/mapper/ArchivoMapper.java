package cl.cachoza.web001.dto.mapper;

import cl.cachoza.web001.dto.ArchivoDTO;
import cl.cachoza.web001.entity.ArchivoEntity;

public class ArchivoMapper {

    public static ArchivoEntity toEntity(ArchivoDTO dto) {
        ArchivoEntity entity = new ArchivoEntity();
        entity.setIdArchivo(dto.getIdArchivo());
        entity.setIdPregunta(dto.getIdPregunta());
        entity.setContenido(dto.getContenido());
        return entity;
    }

    public static ArchivoDTO toDTO(ArchivoEntity entity) {
        return new ArchivoDTO(
            entity.getIdArchivo(),
            entity.getIdPregunta(),
            entity.getContenido()
        );
    }
}