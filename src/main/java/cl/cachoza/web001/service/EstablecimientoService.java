package cl.cachoza.web001.service;

import cl.cachoza.web001.dto.EstablecimientoDTO;
import java.util.List;

public interface EstablecimientoService {
    List<EstablecimientoDTO> obtenerPorRbd(Long rbd);
    List<EstablecimientoDTO> obtenerPorDvrbd(Long dvrbd);
    List<EstablecimientoDTO> obtenerPorNombre(String nombre);
    List<EstablecimientoDTO> obtenerPorEliminados(Boolean eliminar);
    EstablecimientoDTO obtenerPorId(Long id);
    EstablecimientoDTO guardar(EstablecimientoDTO dto);
    EstablecimientoDTO actualizar(Long id, EstablecimientoDTO dto);
    void eliminar(Long id);
    boolean existePorId(Long id);
    boolean existePorRbdYDvrbd(Long rbd, Long dvrbd);
    boolean existePorRbd(Long rbd);
}