package cl.cachoza.web001.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sef_respuestas")
public class RespuestaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_respuesta")
    private Long idRespuesta;

    @Column(name = "pregunta_id")
    private Long preguntaId;

    @Column(name = "respuesta", nullable = false, length = 250)
    private String respuesta;

    // Constructores
    public RespuestaEntity() {}

    public RespuestaEntity(Long preguntaId, String respuesta) {
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