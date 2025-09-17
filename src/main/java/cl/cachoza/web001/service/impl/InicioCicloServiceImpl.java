package cl.cachoza.web001.service.impl;

import cl.cachoza.web001.dto.InicioCicloDTO;
import cl.cachoza.web001.entity.InicioCicloEntity;
import cl.cachoza.web001.repository.InicioCicloRepository;
import cl.cachoza.web001.service.InicioCicloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InicioCicloServiceImpl implements InicioCicloService {

    private final InicioCicloRepository repository;

    @Autowired
    public InicioCicloServiceImpl(InicioCicloRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<InicioCicloDTO> obtenerPorUsuarioIdWp(Long usuarioIdWp) {
        return repository.findByUsuarioIdWp(usuarioIdWp)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<InicioCicloDTO> obtenerPorRbdId(Long rbdId) {
        return repository.findByRbdId(rbdId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<InicioCicloDTO> obtenerPorUsuarioIdWpYRbdId(Long usuarioIdWp, Long rbdId) {
        return repository.findByUsuarioIdWpAndRbdId(usuarioIdWp, rbdId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public InicioCicloDTO obtenerPorId(Long id) {
        InicioCicloEntity entity = repository.findByIdInicioCiclo(id)
                .orElseThrow(() -> new EntityNotFoundException("InicioCiclo no encontrado con ID: " + id));
        return toDTO(entity);
    }

    @Override
    public InicioCicloDTO guardar(InicioCicloDTO dto) {
        InicioCicloEntity entity = toEntity(dto);
        InicioCicloEntity saved = repository.save(entity);
        return toDTO(saved);
    }

    @Override
    public InicioCicloDTO actualizar(Long id, InicioCicloDTO dto) {
        if (!repository.existsByIdInicioCiclo(id)) {
            throw new EntityNotFoundException("InicioCiclo no encontrado con ID: " + id);
        }
        
        InicioCicloEntity entity = toEntity(dto);
        entity.setIdInicioCiclo(id);
        InicioCicloEntity updated = repository.save(entity);
        return toDTO(updated);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsByIdInicioCiclo(id)) {
            throw new EntityNotFoundException("InicioCiclo no encontrado con ID: " + id);
        }
        repository.deleteByIdInicioCiclo(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return repository.existsByIdInicioCiclo(id);
    }

    @Override
    public boolean existePorUsuarioIdWpYRbdId(Long usuarioIdWp, Long rbdId) {
        return repository.existsByUsuarioIdWpAndRbdId(usuarioIdWp, rbdId);
    }

    private InicioCicloDTO toDTO(InicioCicloEntity entity) {
        return new InicioCicloDTO(
                entity.getIdInicioCiclo(),
                entity.getUsuarioIdWp(),
                entity.getRbdId()
        );
    }

    private InicioCicloEntity toEntity(InicioCicloDTO dto) {
        return new InicioCicloEntity(
                dto.getUsuarioIdWp(),
                dto.getRbdId()
        );
    }
}