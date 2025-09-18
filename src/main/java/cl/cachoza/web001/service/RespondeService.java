package cl.cachoza.web001.service;

import cl.cachoza.web001.dto.RespondeDTO;
import java.util.List;

public interface RespondeService {
    List<RespondeDTO> obtenerTodos();
    List<RespondeDTO> obtenerPorInstrumentoInstancia(Integer instrumentoInstanciaId);
    List<RespondeDTO> obtenerPorAlumno(String alumnoId);
    RespondeDTO obtenerPorId(Long id);
    RespondeDTO guardar(RespondeDTO dto);
    RespondeDTO actualizar(Long id, RespondeDTO dto);
    void eliminar(Long id);
    boolean existePorId(Long id);
    boolean existePorInstrumentoYAlumno(Integer instrumentoInstanciaId, String alumnoId);
    long contarPorInstrumentoInstancia(Integer instrumentoInstanciaId);
    long contarPorAlumno(String alumnoId);
}