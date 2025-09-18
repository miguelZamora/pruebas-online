package cl.cachoza.web001.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sef_instrumento_instancia_alumnos")
public class InstrumentoInstanciaAlumnoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_intru_insta_alumnos")
    private Long idIntruInstaAlumnos;

    @Column(name = "instancia_grupo_id", nullable = false)
    private Long instanciaGrupoId;

    @Column(name = "alumno_id", nullable = false)
    private Long alumnoId;

    @Column(name = "codigo_curso_id", nullable = false)
    private Long codigoCursoId;

    @Column(name = "fechacreacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "estado", nullable = false)
    private Integer estado;

    @Column(name = "fecha_instancia", nullable = false, columnDefinition = "TEXT")
    private String fechaInstancia;

    @Column(name = "instrumento_id", nullable = false)
    private Integer instrumentoId;

    // Constructores
    public InstrumentoInstanciaAlumnoEntity() {}

    public InstrumentoInstanciaAlumnoEntity(Long instanciaGrupoId, Long alumnoId, Long codigoCursoId, 
                                          Integer estado, String fechaInstancia, Integer instrumentoId) {
        this.instanciaGrupoId = instanciaGrupoId;
        this.alumnoId = alumnoId;
        this.codigoCursoId = codigoCursoId;
        this.estado = estado;
        this.fechaInstancia = fechaInstancia;
        this.instrumentoId = instrumentoId;
        this.fechaCreacion = LocalDateTime.now();
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