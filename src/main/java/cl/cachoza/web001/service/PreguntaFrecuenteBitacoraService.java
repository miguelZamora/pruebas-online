package cl.cachoza.web001.service;

import cl.cachoza.web001.dto.PreguntaFrecuenteBitacoraDTO;
import java.time.LocalDateTime;
import java.util.List;

public interface PreguntaFrecuenteBitacoraService {
    List<PreguntaFrecuenteBitacoraDTO> obtenerTodos();
    List<PreguntaFrecuenteBitacoraDTO> obtenerPorBusqueda(String busqueda);
    List<PreguntaFrecuenteBitacoraDTO> obtenerPorUsuario(Long idUsuario);
    List<PreguntaFrecuenteBitacoraDTO> obtenerPorIp(String ip);
    List<PreguntaFrecuenteBitacoraDTO> obtenerPorRangoFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin);
    PreguntaFrecuenteBitacoraDTO obtenerPorId(Long id);
    PreguntaFrecuenteBitacoraDTO guardar(PreguntaFrecuenteBitacoraDTO dto);
    PreguntaFrecuenteBitacoraDTO actualizar(Long id, PreguntaFrecuenteBitacoraDTO dto);
    void eliminar(Long id);
    boolean existePorId(Long id);
    long contarPorUsuario(Long idUsuario);
    long contarPorBusqueda(String busqueda);
}