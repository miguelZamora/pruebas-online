package cl.cachoza.web001.service;

import cl.cachoza.web001.dto.AsignaturaDTO;
import java.util.List;

public interface AsignaturaService {
    List<AsignaturaDTO> obtenerTodas();
    AsignaturaDTO obtenerPorId(Long id);
    AsignaturaDTO guardar(AsignaturaDTO dto);
    AsignaturaDTO actualizar(Long id, AsignaturaDTO dto);
    void eliminar(Long id);
    boolean existePorId(Long id);
    boolean existePorNombre(String nombre);
}