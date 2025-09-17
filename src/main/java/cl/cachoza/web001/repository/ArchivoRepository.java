package cl.cachoza.web001.repository;

import cl.cachoza.web001.entity.ArchivoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArchivoRepository extends JpaRepository<ArchivoEntity, Long> {
    
    List<ArchivoEntity> findByIdPregunta(Long idPregunta);
    
    Optional<ArchivoEntity> findByIdArchivo(Long idArchivo);
    
    void deleteByIdArchivo(Long idArchivo);
    
    boolean existsByIdArchivo(Long idArchivo);
    
    boolean existsByIdPregunta(Long idPregunta);
}