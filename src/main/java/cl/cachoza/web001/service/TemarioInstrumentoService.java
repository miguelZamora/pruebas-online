package cl.cachoza.web001.service;

import cl.cachoza.web001.dto.TemarioInstrumentoDTO;
import java.util.List;

public interface TemarioInstrumentoService {
    List<TemarioInstrumentoDTO> obtenerPorInstrumento(Long instrumentoId);
    List<TemarioInstrumentoDTO> obtenerPorCurso(Long cursoId);
    TemarioInstrumentoDTO obtenerPorId(Long id);
    TemarioInstrumentoDTO guardar(TemarioInstrumentoDTO dto);
    TemarioInstrumentoDTO actualizar(Long id, TemarioInstrumentoDTO dto);
    void eliminar(Long id);
    boolean existePorId(Long id);
    boolean existePorInstrumentoYCurso(Long instrumentoId, Long cursoId);
}