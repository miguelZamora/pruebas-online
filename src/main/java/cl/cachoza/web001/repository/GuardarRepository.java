package cl.cachoza.web001.repository;

import cl.cachoza.web001.entity.GuardarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GuardarRepository extends JpaRepository<GuardarEntity, Long> {
    
    List<GuardarEntity> findByProfesorId(Long profesorId);
    
    List<GuardarEntity> findByCursoId(Long cursoId);
    
    List<GuardarEntity> findByInstrumentoId(Long instrumentoId);
    
    List<GuardarEntity> findByPapel(Boolean papel);
    
    Optional<GuardarEntity> findByIdGuardar(Long idGuardar);
    
    void deleteByIdGuardar(Long idGuardar);
    
    boolean existsByIdGuardar(Long idGuardar);
    
    boolean existsByProfesorIdAndCursoIdAndInstrumentoId(Long profesorId, Long cursoId, Long instrumentoId);
    
    List<GuardarEntity> findByProfesorIdAndCursoIdAndInstrumentoId(Long profesorId, Long cursoId, Long instrumentoId);
}