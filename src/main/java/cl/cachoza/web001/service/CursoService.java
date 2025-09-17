package cl.cachoza.web001.service;

import cl.cachoza.web001.dto.CursoDTO;
import java.util.List;

public interface CursoService {
    List<CursoDTO> obtenerTodos();
    CursoDTO obtenerPorId(Long id);
    List<CursoDTO> obtenerPorRbd(Long rbdId);
    List<CursoDTO> obtenerPorAnio(Integer anio);
    List<CursoDTO> obtenerPorEstado(Integer estado);
    CursoDTO guardar(CursoDTO dto);
    CursoDTO actualizar(Long id, CursoDTO dto);
    void eliminar(Long id);
    boolean existePorId(Long id);
    boolean existePorCodigoCurso(String codigoCurso);
    boolean existeCursoDuplicado(Long rbdId, Long codigoNivel, String letra, Integer anio);
}