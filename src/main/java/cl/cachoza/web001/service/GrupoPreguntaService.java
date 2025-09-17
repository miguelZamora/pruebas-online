package cl.cachoza.web001.service;

import cl.cachoza.web001.dto.GrupoPreguntaDTO;
import java.util.List;

public interface GrupoPreguntaService {
    List<GrupoPreguntaDTO> obtenerPorInstrumento(Long instrumentoId);
    List<GrupoPreguntaDTO> obtenerPorPregunta(Long preguntaId);
    List<GrupoPreguntaDTO> obtenerPorOrden(Integer orden);
    List<GrupoPreguntaDTO> obtenerPorPreguntaNumero(Integer preguntaNumero);
    GrupoPreguntaDTO obtenerPorId(Long id);
    GrupoPreguntaDTO guardar(GrupoPreguntaDTO dto);
    GrupoPreguntaDTO actualizar(Long id, GrupoPreguntaDTO dto);
    void eliminar(Long id);
    boolean existePorId(Long id);
    boolean existePorInstrumentoYPregunta(Long instrumentoId, Long preguntaId);
    boolean existePorInstrumentoYOrden(Long instrumentoId, Integer orden);
}