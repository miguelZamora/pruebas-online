package cl.cachoza.web001.service.impl;

import cl.cachoza.web001.dto.CursoDTO;
import cl.cachoza.web001.entity.CursoEntity;
import cl.cachoza.web001.repository.CursoRepository;
import cl.cachoza.web001.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoServiceImpl implements CursoService {

    private final CursoRepository repository;

    @Autowired
    public CursoServiceImpl(CursoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CursoDTO> obtenerTodos() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CursoDTO obtenerPorId(Long id) {
        CursoEntity entity = repository.findByIdCurso(id)
                .orElseThrow(() -> new EntityNotFoundException("Curso no encontrado con ID: " + id));
        return toDTO(entity);
    }

    @Override
    public List<CursoDTO> obtenerPorRbd(Long rbdId) {
        return repository.findByRbdId(rbdId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CursoDTO> obtenerPorAnio(Integer anio) {
        return repository.findByAnio(anio)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CursoDTO> obtenerPorEstado(Integer estado) {
        return repository.findByEstado(estado)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CursoDTO guardar(CursoDTO dto) {
        CursoEntity entity = toEntity(dto);
        CursoEntity saved = repository.save(entity);
        return toDTO(saved);
    }

    @Override
    public CursoDTO actualizar(Long id, CursoDTO dto) {
        if (!repository.existsByIdCurso(id)) {
            throw new EntityNotFoundException("Curso no encontrado con ID: " + id);
        }
        
        CursoEntity entity = toEntity(dto);
        entity.setIdCurso(id);
        CursoEntity updated = repository.save(entity);
        return toDTO(updated);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsByIdCurso(id)) {
            throw new EntityNotFoundException("Curso no encontrado con ID: " + id);
        }
        repository.deleteByIdCurso(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return repository.existsByIdCurso(id);
    }

    @Override
    public boolean existePorCodigoCurso(String codigoCurso) {
        return repository.existsByCodigoCurso(codigoCurso);
    }

    @Override
    public boolean existeCursoDuplicado(Long rbdId, Long codigoNivel, String letra, Integer anio) {
        return repository.existsByRbdIdAndCodigoNivelAndLetraAndAnio(rbdId, codigoNivel, letra, anio);
    }

    private CursoDTO toDTO(CursoEntity entity) {
        return new CursoDTO(
                entity.getIdCurso(),
                entity.getRbdId(),
                entity.getCodigoNivel(),
                entity.getLetra(),
                entity.getCodigoCurso(),
                entity.getAnio(),
                entity.getEstado()
        );
    }

    private CursoEntity toEntity(CursoDTO dto) {
        return new CursoEntity(
                dto.getRbdId(),
                dto.getCodigoNivel(),
                dto.getLetra(),
                dto.getCodigoCurso(),
                dto.getAnio(),
                dto.getEstado()
        );
    }
}