package cl.cachoza.web001.service.impl;

import cl.cachoza.web001.dto.InstrumentoInstanciaDTO;
import cl.cachoza.web001.entity.InstrumentoInstanciaEntity;
import cl.cachoza.web001.repository.InstrumentoInstanciaRepository;
import cl.cachoza.web001.service.InstrumentoInstanciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstrumentoInstanciaServiceImpl implements InstrumentoInstanciaService {

    private final InstrumentoInstanciaRepository repository;

    @Autowired
    public InstrumentoInstanciaServiceImpl(InstrumentoInstanciaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<InstrumentoInstanciaDTO> obtenerPorInstrumentoId(Long instrumentoId) {
        return repository.findByInstrumentoId(instrumentoId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<InstrumentoInstanciaDTO> obtenerPorEstado(Integer estado) {
        return repository.findByEstado(estado)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<InstrumentoInstanciaDTO> obtenerPorCodigoCursoId(Long codigoCursoId) {
        return repository.findByCodigoCursoId(codigoCursoId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<InstrumentoInstanciaDTO> obtenerPorEditableOffline(Boolean editableOffline) {
        return repository.findByEditableOffline(editableOffline)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<InstrumentoInstanciaDTO> obtenerPorInstrumentoIdYCodigoCursoId(Long instrumentoId, Long codigoCursoId) {
        return repository.findByInstrumentoIdAndCodigoCursoId(instrumentoId, codigoCursoId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public InstrumentoInstanciaDTO obtenerPorId(Long id) {
        InstrumentoInstanciaEntity entity = repository.findByIdInstancia(id)
                .orElseThrow(() -> new EntityNotFoundException("InstrumentoInstancia no encontrado con ID: " + id));
        return toDTO(entity);
    }

    @Override
    public InstrumentoInstanciaDTO guardar(InstrumentoInstanciaDTO dto) {
        InstrumentoInstanciaEntity entity = toEntity(dto);
        InstrumentoInstanciaEntity saved = repository.save(entity);
        return toDTO(saved);
    }

    @Override
    public InstrumentoInstanciaDTO actualizar(Long id, InstrumentoInstanciaDTO dto) {
        if (!repository.existsByIdInstancia(id)) {
            throw new EntityNotFoundException("InstrumentoInstancia no encontrado con ID: " + id);
        }
        
        InstrumentoInstanciaEntity entity = toEntity(dto);
        entity.setIdInstancia(id);
        InstrumentoInstanciaEntity updated = repository.save(entity);
        return toDTO(updated);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsByIdInstancia(id)) {
            throw new EntityNotFoundException("InstrumentoInstancia no encontrado con ID: " + id);
        }
        repository.deleteByIdInstancia(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return repository.existsByIdInstancia(id);
    }

    @Override
    public boolean existePorInstrumentoIdYCodigoCursoId(Long instrumentoId, Long codigoCursoId) {
        return repository.existsByInstrumentoIdAndCodigoCursoId(instrumentoId, codigoCursoId);
    }

    private InstrumentoInstanciaDTO toDTO(InstrumentoInstanciaEntity entity) {
        return new InstrumentoInstanciaDTO(
                entity.getIdInstancia(),
                entity.getInstrumentoId(),
                entity.getEstado(),
                entity.getFechaCreacion(),
                entity.getCodigoCursoId(),
                entity.getFechaInstancia(),
                entity.getEditableOffline()
        );
    }

    private InstrumentoInstanciaEntity toEntity(InstrumentoInstanciaDTO dto) {
        return new InstrumentoInstanciaEntity(
                dto.getInstrumentoId(),
                dto.getEstado(),
                dto.getCodigoCursoId(),
                dto.getFechaInstancia(),
                dto.getEditableOffline()
        );
    }
}