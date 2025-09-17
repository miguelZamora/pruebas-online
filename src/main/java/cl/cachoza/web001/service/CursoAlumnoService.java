package cl.cachoza.web001.service;

import cl.cachoza.web001.dto.CursoAlumnoDTO;
import java.util.List;

public interface CursoAlumnoService {
    List<CursoAlumnoDTO> obtenerTodos();
    CursoAlumnoDTO obtenerPorId(Long id);
    List<CursoAlumnoDTO> obtenerPorAlumno(Long alumnoId);
    List<CursoAlumnoDTO> obtenerPorCurso(Long cursoId);
    List<CursoAlumnoDTO> obtenerPorEstado(Integer estado);
    CursoAlumnoDTO guardar(CursoAlumnoDTO dto);
    CursoAlumnoDTO actualizar(Long id, CursoAlumnoDTO dto);
    void eliminar(Long id);
    boolean existePorId(Long id);
    boolean existeInscripcion(Long alumnoId, Long cursoId);
    long contarPorCurso(Long cursoId);
    long contarPorAlumno(Long alumnoId);
}