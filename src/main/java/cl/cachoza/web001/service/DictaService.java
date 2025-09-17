package cl.cachoza.web001.service;

import cl.cachoza.web001.dto.DictaDTO;
import java.util.List;

public interface DictaService {
    List<DictaDTO> obtenerPorProfesor(Long userProfesorId);
    List<DictaDTO> obtenerPorCurso(Long codigoCursoId);
    List<DictaDTO> obtenerPorAsignatura(Long asignaturaId);
    DictaDTO obtenerPorId(Long id);
    DictaDTO guardar(DictaDTO dto);
    DictaDTO actualizar(Long id, DictaDTO dto);
    void eliminar(Long id);
    boolean existePorId(Long id);
    boolean existePorProfesorCursoAsignatura(Long userProfesorId, Long codigoCursoId, Long asignaturaId);
}