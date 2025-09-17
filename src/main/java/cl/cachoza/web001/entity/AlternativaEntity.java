package cl.cachoza.web001.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sef_alternativas")
public class AlternativaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alternativa")
    private Long idAlternativa;

    @Column(name = "pregunta_id", nullable = false)
    private Long preguntaId;

    @Column(name = "orden", nullable = false)
    private Integer orden;

    @Column(name = "alternativa_valor", nullable = false, columnDefinition = "TEXT")
    private String alternativaValor;

    // Constructores
    public AlternativaEntity() {}

    public AlternativaEntity(Long preguntaId, Integer orden, String alternativaValor) {
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