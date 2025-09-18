package cl.cachoza.web001.service.impl;

import cl.cachoza.web001.dto.WpUserDTO;
import cl.cachoza.web001.entity.WpUserEntity;
import cl.cachoza.web001.repository.WpUserRepository;
import cl.cachoza.web001.service.WpUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WpUserServiceImpl implements WpUserService {

    private final WpUserRepository repository;

    @Autowired
    public WpUserServiceImpl(WpUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<WpUserDTO> obtenerTodos() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<WpUserDTO> obtenerPorId(Long id) {
        return repository.findById(id)
                .map(this::toDTO);
    }

    @Override
    public Optional<WpUserDTO> obtenerPorUserLogin(String userLogin) {
        return repository.findByUserLogin(userLogin)
                .map(this::toDTO);
    }

    @Override
    public Optional<WpUserDTO> obtenerPorUserEmail(String userEmail) {
        return repository.findByUserEmail(userEmail)
                .map(this::toDTO);
    }

    @Override
    public WpUserDTO guardar(WpUserDTO dto) {
        WpUserEntity entity = toEntity(dto);
        WpUserEntity saved = repository.save(entity);
        return toDTO(saved);
    }

    @Override
    public WpUserDTO actualizar(Long id, WpUserDTO dto) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Usuario no encontrado con ID: " + id);
        }
        
        WpUserEntity entity = toEntity(dto);
        entity.setId(id);
        WpUserEntity updated = repository.save(entity);
        return toDTO(updated);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Usuario no encontrado con ID: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return repository.existsById(id);
    }

    @Override
    public boolean existePorUserLogin(String userLogin) {
        return repository.existsByUserLogin(userLogin);
    }

    @Override
    public boolean existePorUserEmail(String userEmail) {
        return repository.existsByUserEmail(userEmail);
    }

    private WpUserDTO toDTO(WpUserEntity entity) {
        return new WpUserDTO(
                entity.getId(),
                entity.getUserLogin(),
                entity.getUserPass(),
                entity.getUserNicename(),
                entity.getUserEmail(),
                entity.getUserUrl(),
                entity.getUserRegistered(),
                entity.getUserActivationKey(),
                entity.getUserStatus(),
                entity.getDisplayName()
        );
    }

    private WpUserEntity toEntity(WpUserDTO dto) {
        return new WpUserEntity(
                dto.getUserLogin(),
                dto.getUserPass(),
                dto.getUserNicename(),
                dto.getUserEmail(),
                dto.getUserUrl(),
                dto.getUserRegistered(),
                dto.getUserActivationKey(),
                dto.getUserStatus(),
                dto.getDisplayName()
        );
    }
}