package cl.cachoza.web001.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sef_cursos_alumnos")
public class CursoAlumnoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cursos_alumno")
    private Long idCursosAlumno;

    @Column(name = "alumno_id", nullable = false)
    private Long alumnoId;

    @Column(name = "curso_id", nullable = false)
    private Long cursoId;

    @Column(name = "fecha_inscripcion", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaInscripcion;

    @Column(name = "estado", columnDefinition = "INT DEFAULT 1")
    private Integer estado;

    // Constructores
    public CursoAlumnoEntity() {}

    public CursoAlumnoEntity(Long alumnoId, Long cursoId, LocalDateTime fechaInscripcion, Integer estado) {
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