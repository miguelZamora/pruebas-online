package cl.cachoza.web001.dto;

import java.time.LocalDateTime;

public class InstrumentoInstanciaDTO {

    private Long idInstancia;
    private Long instrumentoId;
    private Integer estado;
    private LocalDateTime fechaCreacion;
    private Long codigoCursoId;
    private String fechaInstancia;
    private Boolean editableOffline;

    // Constructores
    public InstrumentoInstanciaDTO() {}

    public InstrumentoInstanciaDTO(Long idInstancia, Long instrumentoId, Integer estado, LocalDateTime fechaCreacion, Long codigoCursoId, String fechaInstancia, Boolean editableOffline) {
        this.idInstancia = idInstancia;
        this.instrumentoId = instrumentoId;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.codigoCursoId = codigoCursoId;
        this.fechaInstancia = fechaInstancia;
        this.editableOffline = editableOffline;
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