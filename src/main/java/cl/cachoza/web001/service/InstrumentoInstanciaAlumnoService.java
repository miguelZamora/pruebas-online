package cl.cachoza.web001.service;

import cl.cachoza.web001.dto.InstrumentoInstanciaAlumnoDTO;
import java.util.List;

public interface InstrumentoInstanciaAlumnoService {
    List<InstrumentoInstanciaAlumnoDTO> obtenerPorInstanciaGrupo(Long instanciaGrupoId);
    List<InstrumentoInstanciaAlumnoDTO> obtenerPorAlumno(Long alumnoId);
    List<InstrumentoInstanciaAlumnoDTO> obtenerPorCurso(Long codigoCursoId);
    List<InstrumentoInstanciaAlumnoDTO> obtenerPorInstrumento(Integer instrumentoId);
    InstrumentoInstanciaAlumnoDTO obtenerPorId(Long id);
    InstrumentoInstanciaAlumnoDTO guardar(InstrumentoInstanciaAlumnoDTO dto);
    InstrumentoInstanciaAlumnoDTO actualizar(Long id, InstrumentoInstanciaAlumnoDTO dto);
    void eliminar(Long id);
    boolean existePorId(Long id);
    boolean existePorAlumnoYInstancia(Long alumnoId, Long instanciaGrupoId);
}