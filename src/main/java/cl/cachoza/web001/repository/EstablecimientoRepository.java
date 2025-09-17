package cl.cachoza.web001.repository;

import cl.cachoza.web001.entity.EstablecimientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstablecimientoRepository extends JpaRepository<EstablecimientoEntity, Long> {
    
    List<EstablecimientoEntity> findByRbd(Long rbd);
    
    List<EstablecimientoEntity> findByDvrbd(Long dvrbd);
    
    List<EstablecimientoEntity> findByNombreContaining(String nombre);
    
    List<EstablecimientoEntity> findByEliminar(Boolean eliminar);
    
    Optional<EstablecimientoEntity> findByIdEstablecimiento(Long idEstablecimiento);
    
    void deleteByIdEstablecimiento(Long idEstablecimiento);
    
    boolean existsByIdEstablecimiento(Long idEstablecimiento);
    
    boolean existsByRbdAndDvrbd(Long rbd, Long dvrbd);
    
    boolean existsByRbd(Long rbd);
}