package cl.cachoza.web001.repository;

import cl.cachoza.web001.entity.RespuestaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RespuestaRepository extends JpaRepository<RespuestaEntity, Long> {
    
    List<RespuestaEntity> findByPreguntaId(Long preguntaId);
    
    List<RespuestaEntity> findByRespuestaContaining(String respuesta);
    
    Optional<RespuestaEntity> findByIdRespuesta(Long idRespuesta);
    
    void deleteByIdRespuesta(Long idRespuesta);
    
    boolean existsByIdRespuesta(Long idRespuesta);
    
    boolean existsByPreguntaIdAndRespuesta(Long preguntaId, String respuesta);
    
    long countByPreguntaId(Long preguntaId);
}