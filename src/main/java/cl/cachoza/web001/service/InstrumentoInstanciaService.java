package cl.cachoza.web001.service;

import cl.cachoza.web001.dto.InstrumentoInstanciaDTO;
import java.util.List;

public interface InstrumentoInstanciaService {
    List<InstrumentoInstanciaDTO> obtenerPorInstrumentoId(Long instrumentoId);
    List<InstrumentoInstanciaDTO> obtenerPorEstado(Integer estado);
    List<InstrumentoInstanciaDTO> obtenerPorCodigoCursoId(Long codigoCursoId);
    List<InstrumentoInstanciaDTO> obtenerPorEditableOffline(Boolean editableOffline);
    List<InstrumentoInstanciaDTO> obtenerPorInstrumentoIdYCodigoCursoId(Long instrumentoId, Long codigoCursoId);
    InstrumentoInstanciaDTO obtenerPorId(Long id);
    InstrumentoInstanciaDTO guardar(InstrumentoInstanciaDTO dto);
    InstrumentoInstanciaDTO actualizar(Long id, InstrumentoInstanciaDTO dto);
    void eliminar(Long id);
    boolean existePorId(Long id);
    boolean existePorInstrumentoIdYCodigoCursoId(Long instrumentoId, Long codigoCursoId);
}