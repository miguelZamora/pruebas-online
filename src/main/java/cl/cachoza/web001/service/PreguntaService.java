package cl.cachoza.web001.service;

import cl.cachoza.web001.dto.PreguntaDTO;
import java.util.List;

public interface PreguntaService {
    List<PreguntaDTO> obtenerTodos();
    List<PreguntaDTO> obtenerPorTipo(String tipo);
    List<PreguntaDTO> obtenerPorNivel(String nivel);
    List<PreguntaDTO> obtenerPorCurso(String curso);
    List<PreguntaDTO> obtenerPorAsignatura(String asignatura);
    List<PreguntaDTO> obtenerPorSemiOffline(Boolean semiOffline);
    PreguntaDTO obtenerPorId(Long id);
    PreguntaDTO guardar(PreguntaDTO dto);
    PreguntaDTO actualizar(Long id, PreguntaDTO dto);
    void eliminar(Long id);
    boolean existePorId(Long id);
    boolean existePorIdAntiguo(String idAntiguo);
}