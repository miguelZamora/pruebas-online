package cl.cachoza.web001.dto;


public class AlternativaDTO {

    private Long idAlternativa;

    private Long preguntaId;

    private Integer orden;

    private String alternativaValor;

    // Constructores
    public AlternativaDTO() {}

    public AlternativaDTO(Long idAlternativa, Long preguntaId, Integer orden, String alternativaValor) {
        this.idAlternativa = idAlternativa;
        this.preguntaId = preguntaId;
        this.orden = orden;
        this.alternativaValor = alternativaValor;
    }

    // Getters y Setters
    public Long getIdAlternativa() {
        return idAlternativa;
    }

    public void setIdAlternativa(Long idAlternativa) {
        this.idAlternativa = idAlternativa;
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

    public String getAlternativaValor() {
        return alternativaValor;
    }

    public void setAlternativaValor(String alternativaValor) {
        this.alternativaValor = alternativaValor;
    }
}