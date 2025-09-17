package cl.cachoza.web001.repository;

import cl.cachoza.web001.entity.InstrumentoInstanciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstrumentoInstanciaRepository extends JpaRepository<InstrumentoInstanciaEntity, Long> {
    
    List<InstrumentoInstanciaEntity> findByInstrumentoId(Long instrumentoId);
    
    List<InstrumentoInstanciaEntity> findByEstado(Integer estado);
    
    List<InstrumentoInstanciaEntity> findByCodigoCursoId(Long codigoCursoId);
    
    List<InstrumentoInstanciaEntity> findByEditableOffline(Boolean editableOffline);
    
    Optional<InstrumentoInstanciaEntity> findByIdInstancia(Long idInstancia);
    
    void deleteByIdInstancia(Long idInstancia);
    
    boolean existsByIdInstancia(Long idInstancia);
    
    boolean existsByInstrumentoIdAndCodigoCursoId(Long instrumentoId, Long codigoCursoId);
    
    List<InstrumentoInstanciaEntity> findByInstrumentoIdAndCodigoCursoId(Long instrumentoId, Long codigoCursoId);
}