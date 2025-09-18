package cl.cachoza.web001.dto;

public class RespondeDTO {

    private Long idResponde;
    private Integer instrumentoInstanciaId;
    private String alumnoId;

    // Constructores
    public RespondeDTO() {}

    public RespondeDTO(Long idResponde, Integer instrumentoInstanciaId, String alumnoId) {
        this.idResponde = idResponde;
        this.instrumentoInstanciaId = instrumentoInstanciaId;
        this.alumnoId = alumnoId;
    }

    // Getters y Setters
    public Long getIdResponde() {
        return idResponde;
    }

    public void setIdResponde(Long idResponde) {
        this.idResponde = idResponde;
    }

    public Integer getInstrumentoInstanciaId() {
        return instrumentoInstanciaId;
    }

    public void setInstrumentoInstanciaId(Integer instrumentoInstanciaId) {
        this.instrumentoInstanciaId = instrumentoInstanciaId;
    }

    public String getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(String alumnoId) {
        this.alumnoId = alumnoId;
    }
}