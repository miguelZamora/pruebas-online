package cl.cachoza.web001.service.impl;

import cl.cachoza.web001.dto.RespuestaAlumnoDTO;
import cl.cachoza.web001.entity.RespuestaAlumnoEntity;
import cl.cachoza.web001.repository.RespuestaAlumnoRepository;
import cl.cachoza.web001.service.RespuestaAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RespuestaAlumnoServiceImpl implements RespuestaAlumnoService {

    private final RespuestaAlumnoRepository repository;

    @Autowired
    public RespuestaAlumnoServiceImpl(RespuestaAlumnoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<RespuestaAlumnoDTO> obtenerTodos() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<RespuestaAlumnoDTO> obtenerPorRespondeId(Integer respondeId) {
        return repository.findByRespondeId(respondeId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<RespuestaAlumnoDTO> obtenerPorPreguntaId(Integer preguntaId) {
        return repository.findByPreguntaId(preguntaId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<RespuestaAlumnoDTO> obtenerPorTipo(String tipo) {
        return repository.findByTipo(tipo)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<RespuestaAlumnoDTO> obtenerPorIntentoNumero(Integer intentoNumero) {
        return repository.findByIntentoNumero(intentoNumero)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<RespuestaAlumnoDTO> obtenerPorRangoFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        return repository.findByHoraBetween(fechaInicio, fechaFin)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<RespuestaAlumnoDTO> obtenerPorRespondeIdYPreguntaId(Integer respondeId, Integer preguntaId) {
        return repository.findByRespondeIdAndPreguntaId(respondeId, preguntaId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RespuestaAlumnoDTO obtenerPorId(Long id) {
        RespuestaAlumnoEntity entity = repository.findByIdRespuestasAlumno(id)
                .orElseThrow(() -> new EntityNotFoundException("Respuesta alumno no encontrada con ID: " + id));
        return toDTO(entity);
    }

    @Override
    public RespuestaAlumnoDTO guardar(RespuestaAlumnoDTO dto) {
        RespuestaAlumnoEntity entity = toEntity(dto);
        RespuestaAlumnoEntity saved = repository.save(entity);
        return toDTO(saved);
    }

    @Override
    public RespuestaAlumnoDTO actualizar(Long id, RespuestaAlumnoDTO dto) {
        if (!repository.existsByIdRespuestasAlumno(id)) {
            throw new EntityNotFoundException("Respuesta alumno no encontrada con ID: " + id);
        }
        
        RespuestaAlumnoEntity entity = toEntity(dto);
        entity.setIdRespuestasAlumno(id);
        RespuestaAlumnoEntity updated = repository.save(entity);
        return toDTO(updated);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsByIdRespuestasAlumno(id)) {
            throw new EntityNotFoundException("Respuesta alumno no encontrada con ID: " + id);
        }
        repository.deleteByIdRespuestasAlumno(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return repository.existsByIdRespuestasAlumno(id);
    }

    @Override
    public boolean existePorRespondePreguntaEIntento(Integer respondeId, Integer preguntaId, Integer intentoNumero) {
        return repository.existsByRespondeIdAndPreguntaIdAndIntentoNumero(respondeId, preguntaId, intentoNumero);
    }

    @Override
    public long contarPorRespondeId(Integer respondeId) {
        return repository.countByRespondeId(respondeId);
    }

    @Override
    public long contarPorPreguntaId(Integer preguntaId) {
        return repository.countByPreguntaId(preguntaId);
    }

    @Override
    public long contarPorTipo(String tipo) {
        return repository.countByTipo(tipo);
    }

    private RespuestaAlumnoDTO toDTO(RespuestaAlumnoEntity entity) {
        return new RespuestaAlumnoDTO(
                entity.getIdRespuestasAlumno(),
                entity.getRespondeId(),
                entity.getPreguntaId(),
                entity.getAlternativaEscogida(),
                entity.getIntentoNumero(),
                entity.getHora(),
                entity.getCorrecta(),
                entity.getTipo(),
                entity.getDesarrollo(),
                entity.getPapel()
        );
    }

    private RespuestaAlumnoEntity toEntity(RespuestaAlumnoDTO dto) {
        return new RespuestaAlumnoEntity(
                dto.getRespondeId(),
                dto.getPreguntaId(),
                dto.getAlternativaEscogida(),
                dto.getIntentoNumero(),
                dto.getHora(),
                dto.getCorrecta(),
                dto.getTipo(),
                dto.getDesarrollo(),
                dto.getPapel()
        );
    }
}