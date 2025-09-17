package cl.cachoza.web001.service.impl;

import cl.cachoza.web001.dto.GuardarTablaDTO;
import cl.cachoza.web001.entity.GuardarTablaEntity;
import cl.cachoza.web001.repository.GuardarTablaRepository;
import cl.cachoza.web001.service.GuardarTablaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuardarTablaServiceImpl implements GuardarTablaService {

    private final GuardarTablaRepository repository;

    @Autowired
    public GuardarTablaServiceImpl(GuardarTablaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<GuardarTablaDTO> obtenerPorGuardarId(Long guardarId) {
        return repository.findByGuardarId(guardarId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<GuardarTablaDTO> obtenerPorPosicion(String posicion) {
        return repository.findByPosicionContaining(posicion)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<GuardarTablaDTO> obtenerPorValor(String valor) {
        return repository.findByValorContaining(valor)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<GuardarTablaDTO> obtenerPorGuardarIdYPosicion(Long guardarId, String posicion) {
        return repository.findByGuardarIdAndPosicion(guardarId, posicion)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public GuardarTablaDTO obtenerPorId(Long id) {
        GuardarTablaEntity entity = repository.findByIdGuardarTabla(id)
                .orElseThrow(() -> new EntityNotFoundException("GuardarTabla no encontrado con ID: " + id));
        return toDTO(entity);
    }

    @Override
    public GuardarTablaDTO guardar(GuardarTablaDTO dto) {
        GuardarTablaEntity entity = toEntity(dto);
        GuardarTablaEntity saved = repository.save(entity);
        return toDTO(saved);
    }

    @Override
    public GuardarTablaDTO actualizar(Long id, GuardarTablaDTO dto) {
        if (!repository.existsByIdGuardarTabla(id)) {
            throw new EntityNotFoundException("GuardarTabla no encontrado con ID: " + id);
        }
        
        GuardarTablaEntity entity = toEntity(dto);
        entity.setIdGuardarTabla(id);
        GuardarTablaEntity updated = repository.save(entity);
        return toDTO(updated);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsByIdGuardarTabla(id)) {
            throw new EntityNotFoundException("GuardarTabla no encontrado con ID: " + id);
        }
        repository.deleteByIdGuardarTabla(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return repository.existsByIdGuardarTabla(id);
    }

    @Override
    public boolean existePorGuardarIdYPosicion(Long guardarId, String posicion) {
        return repository.existsByGuardarIdAndPosicion(guardarId, posicion);
    }

    private GuardarTablaDTO toDTO(GuardarTablaEntity entity) {
        return new GuardarTablaDTO(
                entity.getIdGuardarTabla(),
                entity.getGuardarId(),
                entity.getPosicion(),
                entity.getValor()
        );
    }

    private GuardarTablaEntity toEntity(GuardarTablaDTO dto) {
        return new GuardarTablaEntity(
                dto.getGuardarId(),
                dto.getPosicion(),
                dto.getValor()
        );
    }
}