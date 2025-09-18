package cl.cachoza.web001.repository;

import cl.cachoza.web001.entity.InstrumentoInstanciaAlumnoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstrumentoInstanciaAlumnoRepository extends JpaRepository<InstrumentoInstanciaAlumnoEntity, Long> {
    
    List<InstrumentoInstanciaAlumnoEntity> findByInstanciaGrupoId(Long instanciaGrupoId);
    
    List<InstrumentoInstanciaAlumnoEntity> findByAlumnoId(Long alumnoId);
    
    List<InstrumentoInstanciaAlumnoEntity> findByCodigoCursoId(Long codigoCursoId);
    
    List<InstrumentoInstanciaAlumnoEntity> findByInstrumentoId(Integer instrumentoId);
    
    Optional<InstrumentoInstanciaAlumnoEntity> findByIdIntruInstaAlumnos(Long idIntruInstaAlumnos);
    
    void deleteByIdIntruInstaAlumnos(Long idIntruInstaAlumnos);
    
    boolean existsByIdIntruInstaAlumnos(Long idIntruInstaAlumnos);
    
    boolean existsByAlumnoIdAndInstanciaGrupoId(Long alumnoId, Long instanciaGrupoId);
}