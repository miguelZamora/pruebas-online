package cl.cachoza.web001.service.impl;

import cl.cachoza.web001.dto.RespondeDTO;
import cl.cachoza.web001.entity.RespondeEntity;
import cl.cachoza.web001.repository.RespondeRepository;
import cl.cachoza.web001.service.RespondeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RespondeServiceImpl implements RespondeService {

    private final RespondeRepository repository;

    @Autowired
    public RespondeServiceImpl(RespondeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<RespondeDTO> obtenerTodos() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<RespondeDTO> obtenerPorInstrumentoInstancia(Integer instrumentoInstanciaId) {
        return repository.findByInstrumentoInstanciaId(instrumentoInstanciaId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<RespondeDTO> obtenerPorAlumno(String alumnoId) {
        return repository.findByAlumnoId(alumnoId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RespondeDTO obtenerPorId(Long id) {
        RespondeEntity entity = repository.findByIdResponde(id)
                .orElseThrow(() -> new EntityNotFoundException("Responde no encontrado con ID: " + id));
        return toDTO(entity);
    }

    @Override
    public RespondeDTO guardar(RespondeDTO dto) {
        RespondeEntity entity = toEntity(dto);
        RespondeEntity saved = repository.save(entity);
        return toDTO(saved);
    }

    @Override
    public RespondeDTO actualizar(Long id, RespondeDTO dto) {
        if (!repository.existsByIdResponde(id)) {
            throw new EntityNotFoundException("Responde no encontrado con ID: " + id);
        }
        
        RespondeEntity entity = toEntity(dto);
        entity.setIdResponde(id);
        RespondeEntity updated = repository.save(entity);
        return toDTO(updated);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsByIdResponde(id)) {
            throw new EntityNotFoundException("Responde no encontrado con ID: " + id);
        }
        repository.deleteByIdResponde(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return repository.existsByIdResponde(id);
    }

    @Override
    public boolean existePorInstrumentoYAlumno(Integer instrumentoInstanciaId, String alumnoId) {
        return repository.existsByInstrumentoInstanciaIdAndAlumnoId(instrumentoInstanciaId, alumnoId);
    }

    @Override
    public long contarPorInstrumentoInstancia(Integer instrumentoInstanciaId) {
        return repository.countByInstrumentoInstanciaId(instrumentoInstanciaId);
    }

    @Override
    public long contarPorAlumno(String alumnoId) {
        return repository.countByAlumnoId(alumnoId);
    }

    private RespondeDTO toDTO(RespondeEntity entity) {
        return new RespondeDTO(
                entity.getIdResponde(),
                entity.getInstrumentoInstanciaId(),
                entity.getAlumnoId()
        );
    }

    private RespondeEntity toEntity(RespondeDTO dto) {
        return new RespondeEntity(
                dto.getInstrumentoInstanciaId(),
                dto.getAlumnoId()
        );
    }
}