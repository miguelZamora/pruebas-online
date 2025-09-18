package cl.cachoza.web001.dto;

public class RespuestaDTO {

    private Long idRespuesta;
    private Long preguntaId;
    private String respuesta;

    // Constructores
    public RespuestaDTO() {}

    public RespuestaDTO(Long idRespuesta, Long preguntaId, String respuesta) {
        this.idRespuesta = idRespuesta;
        this.preguntaId = preguntaId;
        this.respuesta = respuesta;
    }

    // Getters y Setters
    public Long getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(Long idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public Long getPreguntaId() {
        return preguntaId;
    }

    public void setPreguntaId(Long preguntaId) {
        this.preguntaId = preguntaId;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}