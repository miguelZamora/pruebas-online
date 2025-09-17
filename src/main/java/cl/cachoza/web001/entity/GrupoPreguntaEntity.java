package cl.cachoza.web001.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sef_grupo_preguntas")
public class GrupoPreguntaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grupo_preguntas")
    private Long idGrupoPreguntas;

    @Column(name = "instrumento_id", nullable = false)
    private Long instrumentoId;

    @Column(name = "pregunta_id", nullable = false)
    private Long preguntaId;

    @Column(name = "orden", nullable = false)
    private Integer orden;

    @Column(name = "pregunta_numero")
    private Integer preguntaNumero;

    // Constructores
    public GrupoPreguntaEntity() {}

    public GrupoPreguntaEntity(Long instrumentoId, Long preguntaId, Integer orden, Integer preguntaNumero) {
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