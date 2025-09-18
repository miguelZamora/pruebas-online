package cl.cachoza.web001.repository;

import cl.cachoza.web001.entity.PreguntaFrecuenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PreguntaFrecuenteRepository extends JpaRepository<PreguntaFrecuenteEntity, Long> {
    
    List<PreguntaFrecuenteEntity> findByPalabrasClavesContaining(String palabrasClaves);
    
    List<PreguntaFrecuenteEntity> findByIdUsuario(Long idUsuario);
    
    Optional<PreguntaFrecuenteEntity> findById(Long id);
    
    void deleteById(Long id);
    
    boolean existsById(Long id);
    
    boolean existsByPalabrasClavesContaining(String palabrasClaves);
}