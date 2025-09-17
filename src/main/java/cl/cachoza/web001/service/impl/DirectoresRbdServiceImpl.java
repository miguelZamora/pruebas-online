package cl.cachoza.web001.service.impl;

import cl.cachoza.web001.dto.DirectoresRbdDTO;
import cl.cachoza.web001.entity.DirectoresRbdEntity;
import cl.cachoza.web001.repository.DirectoresRbdRepository;
import cl.cachoza.web001.service.DirectoresRbdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DirectoresRbdServiceImpl implements DirectoresRbdService {

    private final DirectoresRbdRepository repository;

    @Autowired
    public DirectoresRbdServiceImpl(DirectoresRbdRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DirectoresRbdDTO> obtenerPorRut(String rut) {
        return repository.findByRut(rut)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DirectoresRbdDTO> obtenerPorRbd(String rbd) {
        return repository.findByRbd(rbd)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DirectoresRbdDTO> obtenerPorTipoW(String tipoW) {
        return repository.findByTipoW(tipoW)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DirectoresRbdDTO> obtenerPorOrigen(String origen) {
        return repository.findByOrigen(origen)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DirectoresRbdDTO> obtenerPorEsTest(Boolean esTest) {
        return repository.findByEsTest(esTest)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DirectoresRbdDTO obtenerPorId(Long id) {
        DirectoresRbdEntity entity = repository.findByIdUsuariosDirectores(id)
                .orElseThrow(() -> new EntityNotFoundException("Director RBD no encontrado con ID: " + id));
        return toDTO(entity);
    }

    @Override
    public DirectoresRbdDTO guardar(DirectoresRbdDTO dto) {
        DirectoresRbdEntity entity = toEntity(dto);
        DirectoresRbdEntity saved = repository.save(entity);
        return toDTO(saved);
    }

    @Override
    public DirectoresRbdDTO actualizar(Long id, DirectoresRbdDTO dto) {
        if (!repository.existsByIdUsuariosDirectores(id)) {
            throw new EntityNotFoundException("Director RBD no encontrado con ID: " + id);
        }
        
        DirectoresRbdEntity entity = toEntity(dto);
        entity.setIdUsuariosDirectores(id);
        DirectoresRbdEntity updated = repository.save(entity);
        return toDTO(updated);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsByIdUsuariosDirectores(id)) {
            throw new EntityNotFoundException("Director RBD no encontrado con ID: " + id);
        }
        repository.deleteByIdUsuariosDirectores(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return repository.existsByIdUsuariosDirectores(id);
    }

    @Override
    public boolean existePorRutYRbd(String rut, String rbd) {
        return repository.existsByRutAndRbd(rut, rbd);
    }

    private DirectoresRbdDTO toDTO(DirectoresRbdEntity entity) {
        return new DirectoresRbdDTO(
                entity.getIdUsuariosDirectores(),
                entity.getRut(),
                entity.getRbd(),
                entity.getTipoW(),
                entity.getOrigen(),
                entity.getEsTest(),
                entity.getFechaCreacion()
        );
    }

    private DirectoresRbdEntity toEntity(DirectoresRbdDTO dto) {
        return new DirectoresRbdEntity(
                dto.getRut(),
                dto.getRbd(),
                dto.getTipoW(),
                dto.getOrigen(),
                dto.getEsTest()
        );
    }
}