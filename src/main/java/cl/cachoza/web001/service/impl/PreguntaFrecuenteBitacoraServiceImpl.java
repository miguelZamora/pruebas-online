package cl.cachoza.web001.service.impl;

import cl.cachoza.web001.dto.PreguntaFrecuenteBitacoraDTO;
import cl.cachoza.web001.entity.PreguntaFrecuenteBitacoraEntity;
import cl.cachoza.web001.repository.PreguntaFrecuenteBitacoraRepository;
import cl.cachoza.web001.service.PreguntaFrecuenteBitacoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PreguntaFrecuenteBitacoraServiceImpl implements PreguntaFrecuenteBitacoraService {

    private final PreguntaFrecuenteBitacoraRepository repository;

    @Autowired
    public PreguntaFrecuenteBitacoraServiceImpl(PreguntaFrecuenteBitacoraRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PreguntaFrecuenteBitacoraDTO> obtenerTodos() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PreguntaFrecuenteBitacoraDTO> obtenerPorBusqueda(String busqueda) {
        return repository.findByBusquedaContaining(busqueda)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PreguntaFrecuenteBitacoraDTO> obtenerPorUsuario(Long idUsuario) {
        return repository.findByIdUsuario(idUsuario)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PreguntaFrecuenteBitacoraDTO> obtenerPorIp(String ip) {
        return repository.findByIp(ip)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PreguntaFrecuenteBitacoraDTO> obtenerPorRangoFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        return repository.findByFechaBetween(fechaInicio, fechaFin)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PreguntaFrecuenteBitacoraDTO obtenerPorId(Long id) {
        PreguntaFrecuenteBitacoraEntity entity = repository.findByIdBitacora(id)
                .orElseThrow(() -> new EntityNotFoundException("Bitácora no encontrada con ID: " + id));
        return toDTO(entity);
    }

    @Override
    public PreguntaFrecuenteBitacoraDTO guardar(PreguntaFrecuenteBitacoraDTO dto) {
        PreguntaFrecuenteBitacoraEntity entity = toEntity(dto);
        PreguntaFrecuenteBitacoraEntity saved = repository.save(entity);
        return toDTO(saved);
    }

    @Override
    public PreguntaFrecuenteBitacoraDTO actualizar(Long id, PreguntaFrecuenteBitacoraDTO dto) {
        if (!repository.existsByIdBitacora(id)) {
            throw new EntityNotFoundException("Bitácora no encontrada con ID: " + id);
        }
        
        PreguntaFrecuenteBitacoraEntity entity = toEntity(dto);
        entity.setIdBitacora(id);
        PreguntaFrecuenteBitacoraEntity updated = repository.save(entity);
        return toDTO(updated);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsByIdBitacora(id)) {
            throw new EntityNotFoundException("Bitácora no encontrada con ID: " + id);
        }
        repository.deleteByIdBitacora(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return repository.existsByIdBitacora(id);
    }

    @Override
    public long contarPorUsuario(Long idUsuario) {
        return repository.countByIdUsuario(idUsuario);
    }

    @Override
    public long contarPorBusqueda(String busqueda) {
        return repository.countByBusquedaContaining(busqueda);
    }

    private PreguntaFrecuenteBitacoraDTO toDTO(PreguntaFrecuenteBitacoraEntity entity) {
        return new PreguntaFrecuenteBitacoraDTO(
                entity.getIdBitacora(),
                entity.getBusqueda(),
                entity.getIp(),
                entity.getIdUsuario(),
                entity.getFecha()
        );
    }

    private PreguntaFrecuenteBitacoraEntity toEntity(PreguntaFrecuenteBitacoraDTO dto) {
        return new PreguntaFrecuenteBitacoraEntity(
                dto.getBusqueda(),
                dto.getIp(),
                dto.getIdUsuario(),
                dto.getFecha()
        );
    }
}