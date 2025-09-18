package cl.cachoza.web001.service;

import cl.cachoza.web001.dto.TipoPreguntaDTO;
import java.util.List;

public interface TipoPreguntaService {
    List<TipoPreguntaDTO> obtenerTodos();
    TipoPreguntaDTO obtenerPorId(Long id);
    TipoPreguntaDTO obtenerPorNombre(String nombre);
    TipoPreguntaDTO guardar(TipoPreguntaDTO dto);
    TipoPreguntaDTO actualizar(Long id, TipoPreguntaDTO dto);
    void eliminar(Long id);
    boolean existePorId(Long id);
    boolean existePorNombre(String nombre);
}