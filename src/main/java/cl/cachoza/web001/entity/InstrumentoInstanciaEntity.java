package cl.cachoza.web001.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sef_instrumento_instancia")
public class InstrumentoInstanciaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_instancia")
    private Long idInstancia;

    @Column(name = "instrumento_id", nullable = false)
    private Long instrumentoId;

    @Column(name = "estado", nullable = false)
    private Integer estado = 1;

    @Column(name = "fechacreacion", nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "codigo_curso_id", nullable = false)
    private Long codigoCursoId;

    @Column(name = "fecha_instancia", nullable = false, columnDefinition = "TINYTEXT")
    private String fechaInstancia;

    @Column(name = "editable_offline", nullable = false)
    private Boolean editableOffline = true;

    // Constructores
    public InstrumentoInstanciaEntity() {
        this.fechaCreacion = LocalDateTime.now();
    }

    public InstrumentoInstanciaEntity(Long instrumentoId, Integer estado, Long codigoCursoId, String fechaInstancia, Boolean editableOffline) {
        this.instrumentoId = instrumentoId;
        this.estado = estado;
        this.codigoCursoId = codigoCursoId;
        this.fechaInstancia = fechaInstancia;
        this.editableOffline = editableOffline;
        this.fechaCreacion = LocalDateTime.now();
    }

    // Getters y Setters
    public Long getIdInstancia() {
        return idInstancia;
    }

    public void setIdInstancia(Long idInstancia) {
        this.idInstancia = idInstancia;
    }

    public Long getInstrumentoId() {
        return instrumentoId;
    }

    public void setInstrumentoId(Long instrumentoId) {
        this.instrumentoId = instrumentoId;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Long getCodigoCursoId() {
        return codigoCursoId;
    }

    public void setCodigoCursoId(Long codigoCursoId) {
        this.codigoCursoId = codigoCursoId;
    }

    public String getFechaInstancia() {
        return fechaInstancia;
    }

    public void setFechaInstancia(String fechaInstancia) {
        this.fechaInstancia = fechaInstancia;
    }

    public Boolean getEditableOffline() {
        return editableOffline;
    }

    public void setEditableOffline(Boolean editableOffline) {
        this.editableOffline = editableOffline;
    }
}