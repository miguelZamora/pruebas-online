package cl.cachoza.web001.service;

import cl.cachoza.web001.dto.GuardarDTO;
import java.util.List;

public interface GuardarService {
    List<GuardarDTO> obtenerPorProfesor(Long profesorId);
    List<GuardarDTO> obtenerPorCurso(Long cursoId);
    List<GuardarDTO> obtenerPorInstrumento(Long instrumentoId);
    List<GuardarDTO> obtenerPorPapel(Boolean papel);
    List<GuardarDTO> obtenerPorProfesorCursoInstrumento(Long profesorId, Long cursoId, Long instrumentoId);
    GuardarDTO obtenerPorId(Long id);
    GuardarDTO guardar(GuardarDTO dto);
    GuardarDTO actualizar(Long id, GuardarDTO dto);
    void eliminar(Long id);
    boolean existePorId(Long id);
    boolean existePorProfesorCursoInstrumento(Long profesorId, Long cursoId, Long instrumentoId);
}