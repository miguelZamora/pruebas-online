package cl.cachoza.web001.repository;

import cl.cachoza.web001.entity.DictaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DictaRepository extends JpaRepository<DictaEntity, Long> {
    
    List<DictaEntity> findByUserProfesorId(Long userProfesorId);
    
    List<DictaEntity> findByCodigoCursoId(Long codigoCursoId);
    
    List<DictaEntity> findByAsignaturaId(Long asignaturaId);
    
    Optional<DictaEntity> findByIdDicta(Long idDicta);
    
    void deleteByIdDicta(Long idDicta);
    
    boolean existsByIdDicta(Long idDicta);
    
    boolean existsByUserProfesorIdAndCodigoCursoIdAndAsignaturaId(Long userProfesorId, Long codigoCursoId, Long asignaturaId);
}