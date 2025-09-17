package cl.cachoza.web001.repository;

import cl.cachoza.web001.entity.AlumnoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlumnoRepository extends JpaRepository<AlumnoEntity, Long> {
    
    Optional<AlumnoEntity> findByIdAlumno(Long idAlumno);
    
    List<AlumnoEntity> findByNombresContainingIgnoreCase(String nombres);
    
    Optional<AlumnoEntity> findByUsuario(String usuario);
    
    List<AlumnoEntity> findByEstado(Boolean estado);
    
    boolean existsByUsuario(String usuario);
    
    void deleteByIdAlumno(Long idAlumno);
    
    boolean existsByIdAlumno(Long idAlumno);
}