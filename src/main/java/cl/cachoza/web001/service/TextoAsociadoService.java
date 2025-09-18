package cl.cachoza.web001.service;

import cl.cachoza.web001.dto.TextoAsociadoDTO;
import java.util.List;

public interface TextoAsociadoService {
    List<TextoAsociadoDTO> obtenerTodos();
    TextoAsociadoDTO obtenerPorId(Long id);
    TextoAsociadoDTO guardar(TextoAsociadoDTO dto);
    TextoAsociadoDTO actualizar(Long id, TextoAsociadoDTO dto);
    void eliminar(Long id);
    boolean existePorId(Long id);
}