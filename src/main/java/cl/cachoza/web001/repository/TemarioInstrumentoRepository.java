package cl.cachoza.web001.repository;

import cl.cachoza.web001.entity.TemarioInstrumentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TemarioInstrumentoRepository extends JpaRepository<TemarioInstrumentoEntity, Long> {
    
    List<TemarioInstrumentoEntity> findByInstrumentoId(Long instrumentoId);
    
    List<TemarioInstrumentoEntity> findByCursoId(Long cursoId);
    
    Optional<TemarioInstrumentoEntity> findByIdTemario(Long idTemario);
    
    void deleteByIdTemario(Long idTemario);
    
    boolean existsByIdTemario(Long idTemario);
    
    boolean existsByInstrumentoIdAndCursoId(Long instrumentoId, Long cursoId);
}