package cl.cachoza.web001.service;

import cl.cachoza.web001.dto.AlumnoDTO;
import java.util.List;

public interface AlumnoService {
    List<AlumnoDTO> obtenerTodos();
    AlumnoDTO obtenerPorId(Long id);
    AlumnoDTO obtenerPorUsuario(String usuario);
    List<AlumnoDTO> buscarPorNombres(String nombres);
    List<AlumnoDTO> obtenerPorEstado(Boolean estado);
    AlumnoDTO guardar(AlumnoDTO dto);
    AlumnoDTO actualizar(Long id, AlumnoDTO dto);
    void eliminar(Long id);
    boolean existePorId(Long id);
    boolean existePorUsuario(String usuario);
}