package cl.cachoza.web001.repository;

import cl.cachoza.web001.entity.InstrumentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstrumentoRepository extends JpaRepository<InstrumentoEntity, Long> {
    
    List<InstrumentoEntity> findByNombreContaining(String nombre);
    
    List<InstrumentoEntity> findByCantidadDePreguntas(Integer cantidadDePreguntas);
    
    List<InstrumentoEntity> findByVisible(Integer visible);
    
    Optional<InstrumentoEntity> findByIdInstrumento(Long idInstrumento);
    
    void deleteByIdInstrumento(Long idInstrumento);
    
    boolean existsByIdInstrumento(Long idInstrumento);
    
    boolean existsByNombre(String nombre);
}