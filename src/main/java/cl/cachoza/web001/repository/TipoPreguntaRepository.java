package cl.cachoza.web001.repository;

import cl.cachoza.web001.entity.TipoPreguntaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoPreguntaRepository extends JpaRepository<TipoPreguntaEntity, Long> {
    
    Optional<TipoPreguntaEntity> findByIdTipoPregunta(Long idTipoPregunta);
    
    void deleteByIdTipoPregunta(Long idTipoPregunta);
    
    boolean existsByIdTipoPregunta(Long idTipoPregunta);
    
    boolean existsByNombre(String nombre);
    
    Optional<TipoPreguntaEntity> findByNombre(String nombre);
}