package cl.cachoza.web001.repository;

import cl.cachoza.web001.entity.RespuestaAlumnoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface RespuestaAlumnoRepository extends JpaRepository<RespuestaAlumnoEntity, Long> {
    
    List<RespuestaAlumnoEntity> findByRespondeId(Integer respondeId);
    
    List<RespuestaAlumnoEntity> findByPreguntaId(Integer preguntaId);
    
    List<RespuestaAlumnoEntity> findByTipo(String tipo);
    
    List<RespuestaAlumnoEntity> findByIntentoNumero(Integer intentoNumero);
    
    List<RespuestaAlumnoEntity> findByHoraBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);
    
    List<RespuestaAlumnoEntity> findByRespondeIdAndPreguntaId(Integer respondeId, Integer preguntaId);
    
    Optional<RespuestaAlumnoEntity> findByIdRespuestasAlumno(Long idRespuestasAlumno);
    
    void deleteByIdRespuestasAlumno(Long idRespuestasAlumno);
    
    boolean existsByIdRespuestasAlumno(Long idRespuestasAlumno);
    
    boolean existsByRespondeIdAndPreguntaIdAndIntentoNumero(Integer respondeId, Integer preguntaId, Integer intentoNumero);
    
    long countByRespondeId(Integer respondeId);
    
    long countByPreguntaId(Integer preguntaId);
    
    long countByTipo(String tipo);
}