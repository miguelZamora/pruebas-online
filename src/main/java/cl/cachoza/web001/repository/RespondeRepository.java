package cl.cachoza.web001.repository;

import cl.cachoza.web001.entity.RespondeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RespondeRepository extends JpaRepository<RespondeEntity, Long> {
    
    List<RespondeEntity> findByInstrumentoInstanciaId(Integer instrumentoInstanciaId);
    
    List<RespondeEntity> findByAlumnoId(String alumnoId);
    
    Optional<RespondeEntity> findByIdResponde(Long idResponde);
    
    void deleteByIdResponde(Long idResponde);
    
    boolean existsByIdResponde(Long idResponde);
    
    boolean existsByInstrumentoInstanciaIdAndAlumnoId(Integer instrumentoInstanciaId, String alumnoId);
    
    long countByInstrumentoInstanciaId(Integer instrumentoInstanciaId);
    
    long countByAlumnoId(String alumnoId);
}