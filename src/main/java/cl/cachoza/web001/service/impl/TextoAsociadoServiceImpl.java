package cl.cachoza.web001.service.impl;

import cl.cachoza.web001.dto.TextoAsociadoDTO;
import cl.cachoza.web001.entity.TextoAsociadoEntity;
import cl.cachoza.web001.repository.TextoAsociadoRepository;
import cl.cachoza.web001.service.TextoAsociadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TextoAsociadoServiceImpl implements TextoAsociadoService {

    private final TextoAsociadoRepository repository;

    @Autowired
    public TextoAsociadoServiceImpl(TextoAsociadoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TextoAsociadoDTO> obtenerTodos() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TextoAsociadoDTO obtenerPorId(Long id) {
        TextoAsociadoEntity entity = repository.findByIdTextoAsociado(id)
                .orElseThrow(() -> new EntityNotFoundException("Texto asociado no encontrado con ID: " + id));
        return toDTO(entity);
    }

    @Override
    public TextoAsociadoDTO guardar(TextoAsociadoDTO dto) {
        TextoAsociadoEntity entity = toEntity(dto);
        TextoAsociadoEntity saved = repository.save(entity);
        return toDTO(saved);
    }

    @Override
    public TextoAsociadoDTO actualizar(Long id, TextoAsociadoDTO dto) {
        if (!repository.existsByIdTextoAsociado(id)) {
            throw new EntityNotFoundException("Texto asociado no encontrado con ID: " + id);
        }
        
        TextoAsociadoEntity entity = toEntity(dto);
        entity.setIdTextoAsociado(id);
        TextoAsociadoEntity updated = repository.save(entity);
        return toDTO(updated);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsByIdTextoAsociado(id)) {
            throw new EntityNotFoundException("Texto asociado no encontrado con ID: " + id);
        }
        repository.deleteByIdTextoAsociado(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return repository.existsByIdTextoAsociado(id);
    }

    private TextoAsociadoDTO toDTO(TextoAsociadoEntity entity) {
        return new TextoAsociadoDTO(
                entity.getIdTextoAsociado(),
                entity.getTexto()
        );
    }

    private TextoAsociadoEntity toEntity(TextoAsociadoDTO dto) {
        return new TextoAsociadoEntity(
                dto.getTexto()
        );
    }
}