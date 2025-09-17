package cl.cachoza.web001.service;

import cl.cachoza.web001.dto.ArchivoDTO;
import java.util.List;

public interface ArchivoService {
    List<ArchivoDTO> obtenerPorPregunta(Long idPregunta);
    ArchivoDTO obtenerPorId(Long id);
    ArchivoDTO guardar(ArchivoDTO dto);
    ArchivoDTO actualizar(Long id, ArchivoDTO dto);
    void eliminar(Long id);
    boolean existePorId(Long id);
    boolean existePorPregunta(Long idPregunta);
}