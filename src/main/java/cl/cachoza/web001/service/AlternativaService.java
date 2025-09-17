package cl.cachoza.web001.service;

import cl.cachoza.web001.dto.AlternativaDTO;
import java.util.List;

public interface AlternativaService {
    List<AlternativaDTO> obtenerPorPregunta(Long preguntaId);
    AlternativaDTO obtenerPorId(Long id);
    AlternativaDTO guardar(AlternativaDTO dto);
    AlternativaDTO actualizar(Long id, AlternativaDTO dto);
    void eliminar(Long id);
    boolean existePorId(Long id);
}