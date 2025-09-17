package cl.cachoza.web001.dto;

public class GrupoPreguntaDTO {

    private Long idGrupoPreguntas;
    private Long instrumentoId;
    private Long preguntaId;
    private Integer orden;
    private Integer preguntaNumero;

    // Constructores
    public GrupoPreguntaDTO() {}

    public GrupoPreguntaDTO(Long idGrupoPreguntas, Long instrumentoId, Long preguntaId, Integer orden, Integer preguntaNumero) {
        this.idGrupoPreguntas = idGrupoPreguntas;
        this.instrumentoId = instrumentoId;
        this.preguntaId = preguntaId;
        this.orden = orden;
        this.preguntaNumero = preguntaNumero;
    }

    // Getters y Setters
    public Long getIdGrupoPreguntas() {
        return idGrupoPreguntas;
    }

    public void setIdGrupoPreguntas(Long idGrupoPreguntas) {
        this.idGrupoPreguntas = idGrupoPreguntas;
    }

    public Long getInstrumentoId() {
        return instrumentoId;
    }

    public void setInstrumentoId(Long instrumentoId) {
        this.instrumentoId = instrumentoId;
    }

    public Long getPreguntaId() {
        return preguntaId;
    }

    public void setPreguntaId(Long preguntaId) {
        this.preguntaId = preguntaId;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Integer getPreguntaNumero() {
        return preguntaNumero;
    }

    public void setPreguntaNumero(Integer preguntaNumero) {
        this.preguntaNumero = preguntaNumero;
    }
}