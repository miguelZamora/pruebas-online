package cl.cachoza.web001.repository;

import cl.cachoza.web001.entity.TablaBEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TablaBRepository extends JpaRepository<TablaBEntity, Long> {
    
    List<TablaBEntity> findByPreguntaId(Integer preguntaId);
    
    List<TablaBEntity> findByOpcionContaining(String opcion);
    
    List<TablaBEntity> findByOrden(Integer orden);
    
    List<TablaBEntity> findByPreguntaIdOrderByOrdenAsc(Integer preguntaId);
    
    Optional<TablaBEntity> findByIdTablaB(Long idTablaB);
    
    void deleteByIdTablaB(Long idTablaB);
    
    boolean existsByIdTablaB(Long idTablaB);
    
    boolean existsByPreguntaIdAndOpcion(Integer preguntaId, String opcion);
    
    boolean existsByPreguntaIdAndOrden(Integer preguntaId, Integer orden);
    
    long countByPreguntaId(Integer preguntaId);
}