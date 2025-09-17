package cl.cachoza.web001.service.impl;

import cl.cachoza.web001.dto.AsignaturaDTO;
import cl.cachoza.web001.entity.AsignaturaEntity;
import cl.cachoza.web001.repository.AsignaturaRepository;
import cl.cachoza.web001.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {

    private final AsignaturaRepository repository;

    @Autowired
    public AsignaturaServiceImpl(AsignaturaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AsignaturaDTO> obtenerTodas() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AsignaturaDTO obtenerPorId(Long id) {
        AsignaturaEntity entity = repository.findByIdAsignatura(id)
                .orElseThrow(() -> new EntityNotFoundException("Asignatura no encontrada con ID: " + id));
        return toDTO(entity);
    }

    @Override
    public AsignaturaDTO guardar(AsignaturaDTO dto) {
        AsignaturaEntity entity = toEntity(dto);
        AsignaturaEntity saved = repository.save(entity);
        return toDTO(saved);
    }

    @Override
    public AsignaturaDTO actualizar(Long id, AsignaturaDTO dto) {
        if (!repository.existsByIdAsignatura(id)) {
            throw new EntityNotFoundException("Asignatura no encontrada con ID: " + id);
        }
        
        AsignaturaEntity entity = toEntity(dto);
        entity.setIdAsignatura(id);
        AsignaturaEntity updated = repository.save(entity);
        return toDTO(updated);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsByIdAsignatura(id)) {
            throw new EntityNotFoundException("Asignatura no encontrada con ID: " + id);
        }
        repository.deleteByIdAsignatura(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return repository.existsByIdAsignatura(id);
    }

    @Override
    public boolean existePorNombre(String nombre) {
        return repository.existsByNombre(nombre);
    }

    private AsignaturaDTO toDTO(AsignaturaEntity entity) {
        return new AsignaturaDTO(
                entity.getIdAsignatura(),
                entity.getNombre(),
                entity.getDescripcion()
        );
    }

    private AsignaturaEntity toEntity(AsignaturaDTO dto) {
        return new AsignaturaEntity(
                dto.getNombre(),
                dto.getDescripcion()
        );
    }
}