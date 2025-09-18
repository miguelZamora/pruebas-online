package cl.cachoza.web001.repository;

import cl.cachoza.web001.entity.PreguntaFrecuenteBitacoraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PreguntaFrecuenteBitacoraRepository extends JpaRepository<PreguntaFrecuenteBitacoraEntity, Long> {
    
    List<PreguntaFrecuenteBitacoraEntity> findByBusquedaContaining(String busqueda);
    
    List<PreguntaFrecuenteBitacoraEntity> findByIdUsuario(Long idUsuario);
    
    List<PreguntaFrecuenteBitacoraEntity> findByIp(String ip);
    
    List<PreguntaFrecuenteBitacoraEntity> findByFechaBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);
    
    Optional<PreguntaFrecuenteBitacoraEntity> findByIdBitacora(Long idBitacora);
    
    void deleteByIdBitacora(Long idBitacora);
    
    boolean existsByIdBitacora(Long idBitacora);
    
    long countByIdUsuario(Long idUsuario);
    
    long countByBusquedaContaining(String busqueda);
}