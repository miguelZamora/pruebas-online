package cl.cachoza.web001.dto;

public class GuardarDTO {

    private Long idGuardar;
    private Long profesorId;
    private Long cursoId;
    private Long instrumentoId;
    private String valor;
    private Boolean papel;

    // Constructores
    public GuardarDTO() {}

    public GuardarDTO(Long idGuardar, Long profesorId, Long cursoId, Long instrumentoId, String valor, Boolean papel) {
        this.idGuardar = idGuardar;
        this.profesorId = profesorId;
        this.cursoId = cursoId;
        this.instrumentoId = instrumentoId;
        this.valor = valor;
        this.papel = papel;
    }

    // Getters y Setters
    public Long getIdGuardar() {
        return idGuardar;
    }

    public void setIdGuardar(Long idGuardar) {
        this.idGuardar = idGuardar;
    }

    public Long getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(Long profesorId) {
        this.profesorId = profesorId;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }

    public Long getInstrumentoId() {
        return instrumentoId;
    }

    public void setInstrumentoId(Long instrumentoId) {
        this.instrumentoId = instrumentoId;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Boolean getPapel() {
        return papel;
    }

    public void setPapel(Boolean papel) {
        this.papel = papel;
    }
}