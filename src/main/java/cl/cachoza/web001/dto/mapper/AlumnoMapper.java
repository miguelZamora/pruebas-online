package cl.cachoza.web001.dto.mapper;



import cl.cachoza.web001.dto.AlumnoDTO;
import cl.cachoza.web001.entity.AlumnoEntity;

public class AlumnoMapper {

    public static AlumnoEntity toEntity(AlumnoDTO dto) {
        AlumnoEntity entity = new AlumnoEntity();
        entity.setIdAlumno(dto.getIdAlumno());
        entity.setUsuario(dto.getUsuario());
        entity.setClave(dto.getClave());
        entity.setNombres(dto.getNombres());
        entity.setApellidoPaterno(dto.getApellidoPaterno());
        entity.setApellidoMaterno(dto.getApellidoMaterno());
        entity.setEstado(dto.getEstado());
        entity.setFechaIngreso(dto.getFechaIngreso());
        entity.setSerie(dto.getSerie());
        return entity;
    }

    public static AlumnoDTO toDTO(AlumnoEntity entity) {
        return new AlumnoDTO(
            entity.getIdAlumno(),
            entity.getUsuario(),
            entity.getClave(),
            entity.getNombres(),
            entity.getApellidoPaterno(),
            entity.getApellidoMaterno(),
            entity.getEstado(),
            entity.getFechaIngreso(),
            entity.getSerie()
        );
    }
}