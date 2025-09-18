package cl.cachoza.web001.dto;

public class TablaBDTO {

    private Long idTablaB;
    private Integer preguntaId;
    private String opcion;
    private Integer orden;

    // Constructores
    public TablaBDTO() {}

    public TablaBDTO(Long idTablaB, Integer preguntaId, String opcion, Integer orden) {
        this.idTablaB = idTablaB;
        this.preguntaId = preguntaId;
        this.opcion = opcion;
        this.orden = orden;
    }

    // Getters y Setters
    public Long getIdTablaB() {
        return idTablaB;
    }

    public void setIdTablaB(Long idTablaB) {
        this.idTablaB = idTablaB;
    }

    public Integer getPreguntaId() {
        return preguntaId;
    }

    public void setPreguntaId(Integer preguntaId) {
        this.preguntaId = preguntaId;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }
}