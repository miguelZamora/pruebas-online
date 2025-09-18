package cl.cachoza.web001.service;

import cl.cachoza.web001.dto.InstrumentoDTO;
import java.util.List;

public interface InstrumentoService {
    List<InstrumentoDTO> obtenerTodos();
    List<InstrumentoDTO> obtenerPorNombre(String nombre);
    List<InstrumentoDTO> obtenerPorCantidadPreguntas(Integer cantidadPreguntas);
    List<InstrumentoDTO> obtenerPorVisibilidad(Integer visible);
    InstrumentoDTO obtenerPorId(Long id);
    InstrumentoDTO guardar(InstrumentoDTO dto);
    InstrumentoDTO actualizar(Long id, InstrumentoDTO dto);
    void eliminar(Long id);
    boolean existePorId(Long id);
    boolean existePorNombre(String nombre);
}