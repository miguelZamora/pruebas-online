package cl.cachoza.web001.repository;

import cl.cachoza.web001.entity.GrupoPreguntaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GrupoPreguntaRepository extends JpaRepository<GrupoPreguntaEntity, Long> {
    
    List<GrupoPreguntaEntity> findByInstrumentoId(Long instrumentoId);
    
    List<GrupoPreguntaEntity> findByPreguntaId(Long preguntaId);
    
    List<GrupoPreguntaEntity> findByOrden(Integer orden);
    
    List<GrupoPreguntaEntity> findByPreguntaNumero(Integer preguntaNumero);
    
    Optional<GrupoPreguntaEntity> findByIdGrupoPreguntas(Long idGrupoPreguntas);
    
    void deleteByIdGrupoPreguntas(Long idGrupoPreguntas);
    
    boolean existsByIdGrupoPreguntas(Long idGrupoPreguntas);
    
    boolean existsByInstrumentoIdAndPreguntaId(Long instrumentoId, Long preguntaId);
    
    boolean existsByInstrumentoIdAndOrden(Long instrumentoId, Integer orden);
}