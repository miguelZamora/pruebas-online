package cl.cachoza.web001.service;

import cl.cachoza.web001.dto.PreguntaFrecuenteDTO;
import java.util.List;

public interface PreguntaFrecuenteService {
    List<PreguntaFrecuenteDTO> obtenerTodos();
    List<PreguntaFrecuenteDTO> obtenerPorPalabrasClaves(String palabrasClaves);
    List<PreguntaFrecuenteDTO> obtenerPorUsuario(Long idUsuario);
    PreguntaFrecuenteDTO obtenerPorId(Long id);
    PreguntaFrecuenteDTO guardar(PreguntaFrecuenteDTO dto);
    PreguntaFrecuenteDTO actualizar(Long id, PreguntaFrecuenteDTO dto);
    void eliminar(Long id);
    boolean existePorId(Long id);
    boolean existePorPalabrasClaves(String palabrasClaves);
}