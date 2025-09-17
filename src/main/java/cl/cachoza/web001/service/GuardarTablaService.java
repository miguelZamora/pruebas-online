package cl.cachoza.web001.service;

import cl.cachoza.web001.dto.GuardarTablaDTO;
import java.util.List;

public interface GuardarTablaService {
    List<GuardarTablaDTO> obtenerPorGuardarId(Long guardarId);
    List<GuardarTablaDTO> obtenerPorPosicion(String posicion);
    List<GuardarTablaDTO> obtenerPorValor(String valor);
    List<GuardarTablaDTO> obtenerPorGuardarIdYPosicion(Long guardarId, String posicion);
    GuardarTablaDTO obtenerPorId(Long id);
    GuardarTablaDTO guardar(GuardarTablaDTO dto);
    GuardarTablaDTO actualizar(Long id, GuardarTablaDTO dto);
    void eliminar(Long id);
    boolean existePorId(Long id);
    boolean existePorGuardarIdYPosicion(Long guardarId, String posicion);
}