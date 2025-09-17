package cl.cachoza.web001.repository;

import cl.cachoza.web001.entity.InicioCicloEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InicioCicloRepository extends JpaRepository<InicioCicloEntity, Long> {
    
    List<InicioCicloEntity> findByUsuarioIdWp(Long usuarioIdWp);
    
    List<InicioCicloEntity> findByRbdId(Long rbdId);
    
    Optional<InicioCicloEntity> findByIdInicioCiclo(Long idInicioCiclo);
    
    void deleteByIdInicioCiclo(Long idInicioCiclo);
    
    boolean existsByIdInicioCiclo(Long idInicioCiclo);
    
    boolean existsByUsuarioIdWpAndRbdId(Long usuarioIdWp, Long rbdId);
    
    List<InicioCicloEntity> findByUsuarioIdWpAndRbdId(Long usuarioIdWp, Long rbdId);
}