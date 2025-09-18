package cl.cachoza.web001.service;

import cl.cachoza.web001.dto.RespuestaAlumnoDTO;
import java.time.LocalDateTime;
import java.util.List;

public interface RespuestaAlumnoService {
    List<RespuestaAlumnoDTO> obtenerTodos();
    List<RespuestaAlumnoDTO> obtenerPorRespondeId(Integer respondeId);
    List<RespuestaAlumnoDTO> obtenerPorPreguntaId(Integer preguntaId);
    List<RespuestaAlumnoDTO> obtenerPorTipo(String tipo);
    List<RespuestaAlumnoDTO> obtenerPorIntentoNumero(Integer intentoNumero);
    List<RespuestaAlumnoDTO> obtenerPorRangoFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin);
    List<RespuestaAlumnoDTO> obtenerPorRespondeIdYPreguntaId(Integer respondeId, Integer preguntaId);
    RespuestaAlumnoDTO obtenerPorId(Long id);
    RespuestaAlumnoDTO guardar(RespuestaAlumnoDTO dto);
    RespuestaAlumnoDTO actualizar(Long id, RespuestaAlumnoDTO dto);
    void eliminar(Long id);
    boolean existePorId(Long id);
    boolean existePorRespondePreguntaEIntento(Integer respondeId, Integer preguntaId, Integer intentoNumero);
    long contarPorRespondeId(Integer respondeId);
    long contarPorPreguntaId(Integer preguntaId);
    long contarPorTipo(String tipo);
}