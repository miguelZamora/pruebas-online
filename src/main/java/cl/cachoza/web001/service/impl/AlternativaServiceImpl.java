package cl.cachoza.web001.service.impl;

import cl.cachoza.web001.dto.AlternativaDTO;
import cl.cachoza.web001.entity.AlternativaEntity;
import cl.cachoza.web001.repository.AlternativaRepository;
import cl.cachoza.web001.service.AlternativaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlternativaServiceImpl implements AlternativaService {

    private final AlternativaRepository repository;

    @Autowired
    public AlternativaServiceImpl(AlternativaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AlternativaDTO> obtenerPorPregunta(Long preguntaId) {
        return repository.findByPreguntaId(preguntaId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AlternativaDTO obtenerPorId(Long id) {
        AlternativaEntity entity = repository.findByIdAlternativa(id)
                .orElseThrow(() -> new EntityNotFoundException("Alternativa no encontrada con ID: " + id));
        return toDTO(entity);
    }

    @Override
    public AlternativaDTO guardar(AlternativaDTO dto) {
        AlternativaEntity entity = toEntity(dto);
        AlternativaEntity saved = repository.save(entity);
        return toDTO(saved);
    }

    @Override
    public AlternativaDTO actualizar(Long id, AlternativaDTO dto) {
        if (!repository.existsByIdAlternativa(id)) {
            throw new EntityNotFoundException("Alternativa no encontrada con ID: " + id);
        }
        
        AlternativaEntity entity = toEntity(dto);
        entity.setIdAlternativa(id);
        AlternativaEntity updated = repository.save(entity);
        return toDTO(updated);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsByIdAlternativa(id)) {
            throw new EntityNotFoundException("Alternativa no encontrada con ID: " + id);
        }
        repository.deleteByIdAlternativa(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return repository.existsByIdAlternativa(id);
    }

    private AlternativaDTO toDTO(AlternativaEntity entity) {
        return new AlternativaDTO(
                entity.getIdAlternativa(),
                entity.getPreguntaId(),
                entity.getOrden(),
                entity.getAlternativaValor()
        );
    }

    private AlternativaEntity toEntity(AlternativaDTO dto) {
        return new AlternativaEntity(
                dto.getPreguntaId(),
                dto.getOrden(),
                dto.getAlternativaValor()
        );
    }
}