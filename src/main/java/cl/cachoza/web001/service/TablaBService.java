package cl.cachoza.web001.service;

import cl.cachoza.web001.dto.TablaBDTO;
import java.util.List;

public interface TablaBService {
    List<TablaBDTO> obtenerTodos();
    List<TablaBDTO> obtenerPorPreguntaId(Integer preguntaId);
    List<TablaBDTO> obtenerPorOpcionContenido(String contenido);
    List<TablaBDTO> obtenerPorOrden(Integer orden);
    List<TablaBDTO> obtenerPorPreguntaIdOrdenado(Integer preguntaId);
    TablaBDTO obtenerPorId(Long id);
    TablaBDTO guardar(TablaBDTO dto);
    TablaBDTO actualizar(Long id, TablaBDTO dto);
    void eliminar(Long id);
    boolean existePorId(Long id);
    boolean existePorPreguntaYOpcion(Integer preguntaId, String opcion);
    boolean existePorPreguntaYOrden(Integer preguntaId, Integer orden);
    long contarPorPreguntaId(Integer preguntaId);
}