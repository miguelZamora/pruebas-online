package cl.cachoza.web001.dto;

import java.time.LocalDateTime;

public class InstrumentoInstanciaAlumnoDTO {

    private Long idIntruInstaAlumnos;
    private Long instanciaGrupoId;
    private Long alumnoId;
    private Long codigoCursoId;
    private LocalDateTime fechaCreacion;
    private Integer estado;
    private String fechaInstancia;
    private Integer instrumentoId;

    // Constructores
    public InstrumentoInstanciaAlumnoDTO() {}

    public InstrumentoInstanciaAlumnoDTO(Long idIntruInstaAlumnos, Long instanciaGrupoId, Long alumnoId, 
                                       Long codigoCursoId, LocalDateTime fechaCreacion, Integer estado, 
                                       String fechaInstancia, Integer instrumentoId) {
        this.idIntruInstaAlumnos = idIntruInstaAlumnos;
        this.instanciaGrupoId = instanciaGrupoId;
        this.alumnoId = alumnoId;
        this.codigoCursoId = codigoCursoId;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
        this.fechaInstancia = fechaInstancia;
        this.instrumentoId = instrumentoId;
    }

    // Getters y Setters
    public Long getIdIntruInstaAlumnos() {
        return idIntruInstaAlumnos;
    }

    public void setIdIntruInstaAlumnos(Long idIntruInstaAlumnos) {
        this.idIntruInstaAlumnos = idIntruInstaAlumnos;
    }

    public Long getInstanciaGrupoId() {
        return instanciaGrupoId;
    }

    public void setInstanciaGrupoId(Long instanciaGrupoId) {
        this.instanciaGrupoId = instanciaGrupoId;
    }

    public Long getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(Long alumnoId) {
        this.alumnoId = alumnoId;
    }

    public Long getCodigoCursoId() {
        return codigoCursoId;
    }

    public void setCodigoCursoId(Long codigoCursoId) {
        this.codigoCursoId = codigoCursoId;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getFechaInstancia() {
        return fechaInstancia;
    }

    public void setFechaInstancia(String fechaInstancia) {
        this.fechaInstancia = fechaInstancia;
    }

    public Integer getInstrumentoId() {
        return instrumentoId;
    }

    public void setInstrumentoId(Integer instrumentoId) {
        this.instrumentoId = instrumentoId;
    }
}