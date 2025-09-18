package cl.cachoza.web001.service;

import cl.cachoza.web001.dto.RespuestaDTO;
import java.util.List;

public interface RespuestaService {
    List<RespuestaDTO> obtenerTodos();
    List<RespuestaDTO> obtenerPorPregunta(Long preguntaId);
    List<RespuestaDTO> obtenerPorRespuestaContenido(String contenido);
    RespuestaDTO obtenerPorId(Long id);
    RespuestaDTO guardar(RespuestaDTO dto);
    RespuestaDTO actualizar(Long id, RespuestaDTO dto);
    void eliminar(Long id);
    boolean existePorId(Long id);
    boolean existePorPreguntaYRespuesta(Long preguntaId, String respuesta);
    long contarPorPregunta(Long preguntaId);
}