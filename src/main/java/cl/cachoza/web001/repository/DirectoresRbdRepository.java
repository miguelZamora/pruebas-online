package cl.cachoza.web001.repository;

import cl.cachoza.web001.entity.DirectoresRbdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DirectoresRbdRepository extends JpaRepository<DirectoresRbdEntity, Long> {
    
    List<DirectoresRbdEntity> findByRut(String rut);
    
    List<DirectoresRbdEntity> findByRbd(String rbd);
    
    List<DirectoresRbdEntity> findByTipoW(String tipoW);
    
    List<DirectoresRbdEntity> findByOrigen(String origen);
    
    List<DirectoresRbdEntity> findByEsTest(Boolean esTest);
    
    Optional<DirectoresRbdEntity> findByIdUsuariosDirectores(Long idUsuariosDirectores);
    
    void deleteByIdUsuariosDirectores(Long idUsuariosDirectores);
    
    boolean existsByIdUsuariosDirectores(Long idUsuariosDirectores);
    
    boolean existsByRutAndRbd(String rut, String rbd);
}