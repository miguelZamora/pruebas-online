package cl.cachoza.web001.service.impl;

import cl.cachoza.web001.dto.AlumnoDTO;
import cl.cachoza.web001.entity.AlumnoEntity;
import cl.cachoza.web001.repository.AlumnoRepository;
import cl.cachoza.web001.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository repository;

    @Autowired
    public AlumnoServiceImpl(AlumnoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AlumnoDTO> obtenerTodos() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AlumnoDTO obtenerPorId(Long id) {
        AlumnoEntity entity = repository.findByIdAlumno(id)
                .orElseThrow(() -> new EntityNotFoundException("Alumno no encontrado con ID: " + id));
        return toDTO(entity);
    }

    @Override
    public AlumnoDTO obtenerPorUsuario(String usuario) {
        AlumnoEntity entity = repository.findByUsuario(usuario)
                .orElseThrow(() -> new EntityNotFoundException("Alumno no encontrado con usuario: " + usuario));
        return toDTO(entity);
    }

    @Override
    public List<AlumnoDTO> buscarPorNombres(String nombres) {
        return repository.findByNombresContainingIgnoreCase(nombres)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AlumnoDTO> obtenerPorEstado(Boolean estado) {
        return repository.findByEstado(estado)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AlumnoDTO guardar(AlumnoDTO dto) {
        if (repository.existsByUsuario(dto.getUsuario())) {
            throw new IllegalArgumentException("Ya existe un alumno con el usuario: " + dto.getUsuario());
        }
        
        AlumnoEntity entity = toEntity(dto);
        AlumnoEntity saved = repository.save(entity);
        return toDTO(saved);
    }

    @Override
    public AlumnoDTO actualizar(Long id, AlumnoDTO dto) {
        if (!repository.existsByIdAlumno(id)) {
            throw new EntityNotFoundException("Alumno no encontrado con ID: " + id);
        }
        
        // Verificar si el usuario ya existe en otro registro
        Optional<AlumnoEntity> alumnoConMismoUsuario = repository.findByUsuario(dto.getUsuario());
        if (alumnoConMismoUsuario.isPresent() && !alumnoConMismoUsuario.get().getIdAlumno().equals(id)) {
            throw new IllegalArgumentException("Ya existe otro alumno con el usuario: " + dto.getUsuario());
        }
        
        AlumnoEntity entity = toEntity(dto);
        entity.setIdAlumno(id);
        AlumnoEntity updated = repository.save(entity);
        return toDTO(updated);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsByIdAlumno(id)) {
            throw new EntityNotFoundException("Alumno no encontrado con ID: " + id);
        }
        repository.deleteByIdAlumno(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return repository.existsByIdAlumno(id);
    }

    @Override
    public boolean existePorUsuario(String usuario) {
        return repository.existsByUsuario(usuario);
    }

    private AlumnoDTO toDTO(AlumnoEntity entity) {
        return new AlumnoDTO(
                entity.getIdAlumno(),
                entity.getUsuario(),
                entity.getClave(),
                entity.getNombres(),
                entity.getApellidoPaterno(),
                entity.getApellidoMaterno(),
                entity.getEstado(),
                entity.getFechaIngreso(),
                entity.getSerie()
        );
    }

    private AlumnoEntity toEntity(AlumnoDTO dto) {
        return new AlumnoEntity(
                dto.getUsuario(),
                dto.getClave(),
                dto.getNombres(),
                dto.getApellidoPaterno(),
                dto.getApellidoMaterno(),
                dto.getEstado(),
                dto.getFechaIngreso(),
                dto.getSerie()
        );
    }
}