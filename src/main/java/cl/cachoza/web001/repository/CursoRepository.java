package cl.cachoza.web001.repository;

import cl.cachoza.web001.entity.CursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<CursoEntity, Long> {
    
    Optional<CursoEntity> findByIdCurso(Long idCurso);
    
    List<CursoEntity> findByRbdId(Long rbdId);
    
    List<CursoEntity> findByAnio(Integer anio);
    
    List<CursoEntity> findByEstado(Integer estado);
    
    List<CursoEntity> findByCodigoCurso(String codigoCurso);
    
    void deleteByIdCurso(Long idCurso);
    
    boolean existsByIdCurso(Long idCurso);
    
    boolean existsByCodigoCurso(String codigoCurso);
    
    boolean existsByRbdIdAndCodigoNivelAndLetraAndAnio(Long rbdId, Long codigoNivel, String letra, Integer anio);
}