package cl.cachoza.web001.dto;

import java.time.LocalDateTime;

public class CursoAlumnoDTO {

    private Long idCursosAlumno;
    private Long alumnoId;
    private Long cursoId;
    private LocalDateTime fechaInscripcion;
    private Integer estado;

    // Constructores
    public CursoAlumnoDTO() {}

    public CursoAlumnoDTO(Long idCursosAlumno, Long alumnoId, Long cursoId, LocalDateTime fechaInscripcion, Integer estado) {
        this.idCursosAlumno = idCursosAlumno;
        this.alumnoId = alumnoId;
        this.cursoId = cursoId;
        this.fechaInscripcion = fechaInscripcion;
        this.estado = estado;
    }

    // Getters y Setters
    public Long getIdCursosAlumno() {
        return idCursosAlumno;
    }

    public void setIdCursosAlumno(Long idCursosAlumno) {
        this.idCursosAlumno = idCursosAlumno;
    }

    public Long getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(Long alumnoId) {
        this.alumnoId = alumnoId;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }

    public LocalDateTime getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDateTime fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}