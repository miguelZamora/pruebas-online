package cl.cachoza.web001.service;

import cl.cachoza.web001.dto.WpUserDTO;
import java.util.List;
import java.util.Optional;

public interface WpUserService {
    List<WpUserDTO> obtenerTodos();
    Optional<WpUserDTO> obtenerPorId(Long id);
    Optional<WpUserDTO> obtenerPorUserLogin(String userLogin);
    Optional<WpUserDTO> obtenerPorUserEmail(String userEmail);
    WpUserDTO guardar(WpUserDTO dto);
    WpUserDTO actualizar(Long id, WpUserDTO dto);
    void eliminar(Long id);
    boolean existePorId(Long id);
    boolean existePorUserLogin(String userLogin);
    boolean existePorUserEmail(String userEmail);
}