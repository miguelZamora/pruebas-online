package cl.cachoza.web001.service;

import cl.cachoza.web001.dto.DirectoresRbdDTO;
import java.util.List;

public interface DirectoresRbdService {
    List<DirectoresRbdDTO> obtenerPorRut(String rut);
    List<DirectoresRbdDTO> obtenerPorRbd(String rbd);
    List<DirectoresRbdDTO> obtenerPorTipoW(String tipoW);
    List<DirectoresRbdDTO> obtenerPorOrigen(String origen);
    List<DirectoresRbdDTO> obtenerPorEsTest(Boolean esTest);
    DirectoresRbdDTO obtenerPorId(Long id);
    DirectoresRbdDTO guardar(DirectoresRbdDTO dto);
    DirectoresRbdDTO actualizar(Long id, DirectoresRbdDTO dto);
    void eliminar(Long id);
    boolean existePorId(Long id);
    boolean existePorRutYRbd(String rut, String rbd);
}