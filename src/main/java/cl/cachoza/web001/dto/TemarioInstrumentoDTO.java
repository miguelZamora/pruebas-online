package cl.cachoza.web001.dto;

public class TemarioInstrumentoDTO {

    private Long idTemario;
    private Long instrumentoId;
    private Long cursoId;

    // Constructores
    public TemarioInstrumentoDTO() {}

    public TemarioInstrumentoDTO(Long idTemario, Long instrumentoId, Long cursoId) {
        this.idTemario = idTemario;
        this.instrumentoId = instrumentoId;
        this.cursoId = cursoId;
    }

    // Getters y Setters
    public Long getIdTemario() {
        return idTemario;
    }

    public void setIdTemario(Long idTemario) {
        this.idTemario = idTemario;
    }

    public Long getInstrumentoId() {
        return instrumentoId;
    }

    public void setInstrumentoId(Long instrumentoId) {
        this.instrumentoId = instrumentoId;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }
}