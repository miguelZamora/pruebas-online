package cl.cachoza.web001.repository;

import cl.cachoza.web001.entity.GuardarTablaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GuardarTablaRepository extends JpaRepository<GuardarTablaEntity, Long> {
    
    List<GuardarTablaEntity> findByGuardarId(Long guardarId);
    
    List<GuardarTablaEntity> findByPosicionContaining(String posicion);
    
    List<GuardarTablaEntity> findByValorContaining(String valor);
    
    Optional<GuardarTablaEntity> findByIdGuardarTabla(Long idGuardarTabla);
    
    void deleteByIdGuardarTabla(Long idGuardarTabla);
    
    boolean existsByIdGuardarTabla(Long idGuardarTabla);
    
    boolean existsByGuardarIdAndPosicion(Long guardarId, String posicion);
    
    List<GuardarTablaEntity> findByGuardarIdAndPosicion(Long guardarId, String posicion);
}