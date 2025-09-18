package cl.cachoza.web001.repository;

import cl.cachoza.web001.entity.PreguntaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PreguntaRepository extends JpaRepository<PreguntaEntity, Long> {
    
    List<PreguntaEntity> findByTipo(String tipo);
    
    List<PreguntaEntity> findByNivel(String nivel);
    
    List<PreguntaEntity> findByCurso(String curso);
    
    List<PreguntaEntity> findByAsignatura(String asignatura);
    
    List<PreguntaEntity> findBySemiOffline(Boolean semiOffline);
    
    Optional<PreguntaEntity> findByIdPregunta(Long idPregunta);
    
    void deleteByIdPregunta(Long idPregunta);
    
    boolean existsByIdPregunta(Long idPregunta);
    
    boolean existsByIdAntiguo(String idAntiguo);
}