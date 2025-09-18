package cl.cachoza.web001.repository;

import cl.cachoza.web001.entity.TextoAsociadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TextoAsociadoRepository extends JpaRepository<TextoAsociadoEntity, Long> {
    
    Optional<TextoAsociadoEntity> findByIdTextoAsociado(Long idTextoAsociado);
    
    void deleteByIdTextoAsociado(Long idTextoAsociado);
    
    boolean existsByIdTextoAsociado(Long idTextoAsociado);
}