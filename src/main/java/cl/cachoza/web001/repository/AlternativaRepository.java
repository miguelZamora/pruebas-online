package cl.cachoza.web001.repository;

import cl.cachoza.web001.entity.AlternativaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlternativaRepository extends JpaRepository<AlternativaEntity, Long> {
    
    List<AlternativaEntity> findByPreguntaId(Long preguntaId);
    
    Optional<AlternativaEntity> findByIdAlternativa(Long idAlternativa);
    
    void deleteByIdAlternativa(Long idAlternativa);
    
    boolean existsByIdAlternativa(Long idAlternativa);
}