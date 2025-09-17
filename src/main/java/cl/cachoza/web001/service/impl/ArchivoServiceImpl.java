package cl.cachoza.web001.service.impl;

import cl.cachoza.web001.dto.ArchivoDTO;
import cl.cachoza.web001.entity.ArchivoEntity;
import cl.cachoza.web001.repository.ArchivoRepository;
import cl.cachoza.web001.service.ArchivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArchivoServiceImpl implements ArchivoService {

    private final ArchivoRepository repository;

    @Autowired
    public ArchivoServiceImpl(ArchivoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ArchivoDTO> obtenerPorPregunta(Long idPregunta) {
        return repository.findByIdPregunta(idPregunta)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ArchivoDTO obtenerPorId(Long id) {
        ArchivoEntity entity = repository.findByIdArchivo(id)
                .orElseThrow(() -> new EntityNotFoundException("Archivo no encontrado con ID: " + id));
        return toDTO(entity);
    }

    @Override
    public ArchivoDTO guardar(ArchivoDTO dto) {
        ArchivoEntity entity = toEntity(dto);
        ArchivoEntity saved = repository.save(entity);
        return toDTO(saved);
    }

    @Override
    public ArchivoDTO actualizar(Long id, ArchivoDTO dto) {
        if (!repository.existsByIdArchivo(id)) {
            throw new EntityNotFoundException("Archivo no encontrado con ID: " + id);
        }
        
        ArchivoEntity entity = toEntity(dto);
        entity.setIdArchivo(id);
        ArchivoEntity updated = repository.save(entity);
        return toDTO(updated);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsByIdArchivo(id)) {
            throw new EntityNotFoundException("Archivo no encontrado con ID: " + id);
        }
        repository.deleteByIdArchivo(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return repository.existsByIdArchivo(id);
    }

    @Override
    public boolean existePorPregunta(Long idPregunta) {
        return repository.existsByIdPregunta(idPregunta);
    }

    private ArchivoDTO toDTO(ArchivoEntity entity) {
        return new ArchivoDTO(
                entity.getIdArchivo(),
                entity.getIdPregunta(),
                entity.getContenido()
        );
    }

    private ArchivoEntity toEntity(ArchivoDTO dto) {
        return new ArchivoEntity(
                dto.getIdPregunta(),
                dto.getContenido()
        );
    }
}