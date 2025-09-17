package cl.cachoza.web001.repository;

import cl.cachoza.web001.entity.AsignaturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AsignaturaRepository extends JpaRepository<AsignaturaEntity, Long> {
    
    Optional<AsignaturaEntity> findByIdAsignatura(Long idAsignatura);
    
    void deleteByIdAsignatura(Long idAsignatura);
    
    boolean existsByIdAsignatura(Long idAsignatura);
    
    boolean existsByNombre(String nombre);
}