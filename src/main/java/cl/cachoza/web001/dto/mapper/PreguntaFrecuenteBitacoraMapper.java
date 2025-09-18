package cl.cachoza.web001.dto.mapper;

import cl.cachoza.web001.dto.PreguntaFrecuenteBitacoraDTO;
import cl.cachoza.web001.entity.PreguntaFrecuenteBitacoraEntity;

public class PreguntaFrecuenteBitacoraMapper {

    public static PreguntaFrecuenteBitacoraEntity toEntity(PreguntaFrecuenteBitacoraDTO dto) {
        PreguntaFrecuenteBitacoraEntity entity = new PreguntaFrecuenteBitacoraEntity();
        entity.setIdBitacora(dto.getIdBitacora());
        entity.setBusqueda(dto.getBusqueda());
        entity.setIp(dto.getIp());
        entity.setIdUsuario(dto.getIdUsuario());
        entity.setFecha(dto.getFecha());
        return entity;
    }

    public static PreguntaFrecuenteBitacoraDTO toDTO(PreguntaFrecuenteBitacoraEntity entity) {
        return new PreguntaFrecuenteBitacoraDTO(
            entity.getIdBitacora(),
            entity.getBusqueda(),
            entity.getIp(),
            entity.getIdUsuario(),
            entity.getFecha()
        );
    }
}