package cl.cachoza.web001.repository;

import cl.cachoza.web001.entity.CursoAlumnoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CursoAlumnoRepository extends JpaRepository<CursoAlumnoEntity, Long> {
    
    Optional<CursoAlumnoEntity> findByIdCursosAlumno(Long idCursosAlumno);
    
    List<CursoAlumnoEntity> findByAlumnoId(Long alumnoId);
    
    List<CursoAlumnoEntity> findByCursoId(Long cursoId);
    
    List<CursoAlumnoEntity> findByEstado(Integer estado);
    
    List<CursoAlumnoEntity> findByAlumnoIdAndCursoId(Long alumnoId, Long cursoId);
    
    void deleteByIdCursosAlumno(Long idCursosAlumno);
    
    boolean existsByIdCursosAlumno(Long idCursosAlumno);
    
    boolean existsByAlumnoIdAndCursoId(Long alumnoId, Long cursoId);
    
    long countByCursoId(Long cursoId);
    
    long countByAlumnoId(Long alumnoId);
}