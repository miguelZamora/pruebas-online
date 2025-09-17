package cl.cachoza.web001.service;

import cl.cachoza.web001.dto.InicioCicloDTO;
import java.util.List;

public interface InicioCicloService {
    List<InicioCicloDTO> obtenerPorUsuarioIdWp(Long usuarioIdWp);
    List<InicioCicloDTO> obtenerPorRbdId(Long rbdId);
    List<InicioCicloDTO> obtenerPorUsuarioIdWpYRbdId(Long usuarioIdWp, Long rbdId);
    InicioCicloDTO obtenerPorId(Long id);
    InicioCicloDTO guardar(InicioCicloDTO dto);
    InicioCicloDTO actualizar(Long id, InicioCicloDTO dto);
    void eliminar(Long id);
    boolean existePorId(Long id);
    boolean existePorUsuarioIdWpYRbdId(Long usuarioIdWp, Long rbdId);
}