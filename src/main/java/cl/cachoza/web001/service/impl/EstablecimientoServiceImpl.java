package cl.cachoza.web001.service.impl;

import cl.cachoza.web001.dto.EstablecimientoDTO;
import cl.cachoza.web001.entity.EstablecimientoEntity;
import cl.cachoza.web001.repository.EstablecimientoRepository;
import cl.cachoza.web001.service.EstablecimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstablecimientoServiceImpl implements EstablecimientoService {

    private final EstablecimientoRepository repository;

    @Autowired
    public EstablecimientoServiceImpl(EstablecimientoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EstablecimientoDTO> obtenerPorRbd(Long rbd) {
        return repository.findByRbd(rbd)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<EstablecimientoDTO> obtenerPorDvrbd(Long dvrbd) {
        return repository.findByDvrbd(dvrbd)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<EstablecimientoDTO> obtenerPorNombre(String nombre) {
        return repository.findByNombreContaining(nombre)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<EstablecimientoDTO> obtenerPorEliminados(Boolean eliminar) {
        return repository.findByEliminar(eliminar)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EstablecimientoDTO obtenerPorId(Long id) {
        EstablecimientoEntity entity = repository.findByIdEstablecimiento(id)
                .orElseThrow(() -> new EntityNotFoundException("Establecimiento no encontrado con ID: " + id));
        return toDTO(entity);
    }

    @Override
    public EstablecimientoDTO guardar(EstablecimientoDTO dto) {
        EstablecimientoEntity entity = toEntity(dto);
        EstablecimientoEntity saved = repository.save(entity);
        return toDTO(saved);
    }

    @Override
    public EstablecimientoDTO actualizar(Long id, EstablecimientoDTO dto) {
        if (!repository.existsByIdEstablecimiento(id)) {
            throw new EntityNotFoundException("Establecimiento no encontrado con ID: " + id);
        }
        
        EstablecimientoEntity entity = toEntity(dto);
        entity.setIdEstablecimiento(id);
        EstablecimientoEntity updated = repository.save(entity);
        return toDTO(updated);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsByIdEstablecimiento(id)) {
            throw new EntityNotFoundException("Establecimiento no encontrado con ID: " + id);
        }
        repository.deleteByIdEstablecimiento(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return repository.existsByIdEstablecimiento(id);
    }

    @Override
    public boolean existePorRbdYDvrbd(Long rbd, Long dvrbd) {
        return repository.existsByRbdAndDvrbd(rbd, dvrbd);
    }

    @Override
    public boolean existePorRbd(Long rbd) {
        return repository.existsByRbd(rbd);
    }

    private EstablecimientoDTO toDTO(EstablecimientoEntity entity) {
        return new EstablecimientoDTO(
                entity.getIdEstablecimiento(),
                entity.getRbd(),
                entity.getDvrbd(),
                entity.getNombre(),
                entity.getEliminar()
        );
    }

    private EstablecimientoEntity toEntity(EstablecimientoDTO dto) {
        return new EstablecimientoEntity(
                dto.getRbd(),
                dto.getDvrbd(),
                dto.getNombre(),
                dto.getEliminar()
        );
    }
}