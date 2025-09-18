package cl.cachoza.web001.service.impl;

import cl.cachoza.web001.dto.PreguntaFrecuenteDTO;
import cl.cachoza.web001.entity.PreguntaFrecuenteEntity;
import cl.cachoza.web001.repository.PreguntaFrecuenteRepository;
import cl.cachoza.web001.service.PreguntaFrecuenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PreguntaFrecuenteServiceImpl implements PreguntaFrecuenteService {

    private final PreguntaFrecuenteRepository repository;

    @Autowired
    public PreguntaFrecuenteServiceImpl(PreguntaFrecuenteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PreguntaFrecuenteDTO> obtenerTodos() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PreguntaFrecuenteDTO> obtenerPorPalabrasClaves(String palabrasClaves) {
        return repository.findByPalabrasClavesContaining(palabrasClaves)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PreguntaFrecuenteDTO> obtenerPorUsuario(Long idUsuario) {
        return repository.findByIdUsuario(idUsuario)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PreguntaFrecuenteDTO obtenerPorId(Long id) {
        PreguntaFrecuenteEntity entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pregunta frecuente no encontrada con ID: " + id));
        return toDTO(entity);
    }

    @Override
    public PreguntaFrecuenteDTO guardar(PreguntaFrecuenteDTO dto) {
        PreguntaFrecuenteEntity entity = toEntity(dto);
        PreguntaFrecuenteEntity saved = repository.save(entity);
        return toDTO(saved);
    }

    @Override
    public PreguntaFrecuenteDTO actualizar(Long id, PreguntaFrecuenteDTO dto) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Pregunta frecuente no encontrada con ID: " + id);
        }
        
        PreguntaFrecuenteEntity entity = toEntity(dto);
        entity.setId(id);
        PreguntaFrecuenteEntity updated = repository.save(entity);
        return toDTO(updated);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Pregunta frecuente no encontrada con ID: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return repository.existsById(id);
    }

    @Override
    public boolean existePorPalabrasClaves(String palabrasClaves) {
        return repository.existsByPalabrasClavesContaining(palabrasClaves);
    }

    private PreguntaFrecuenteDTO toDTO(PreguntaFrecuenteEntity entity) {
        return new PreguntaFrecuenteDTO(
                entity.getId(),
                entity.getPalabrasClaves(),
                entity.getRespuesta(),
                entity.getIdUsuario(),
                entity.getComentarios()
        );
    }

    private PreguntaFrecuenteEntity toEntity(PreguntaFrecuenteDTO dto) {
        return new PreguntaFrecuenteEntity(
                dto.getPalabrasClaves(),
                dto.getRespuesta(),
                dto.getIdUsuario(),
                dto.getComentarios()
        );
    }
}