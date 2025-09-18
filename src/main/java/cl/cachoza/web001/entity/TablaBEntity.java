package cl.cachoza.web001.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sef_tabla_b")
public class TablaBEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tabla_b")
    private Long idTablaB;

    @Column(name = "pregunta_id", nullable = false)
    private Integer preguntaId;

    @Column(name = "opcion", nullable = false, length = 100)
    private String opcion;

    @Column(name = "orden", nullable = false)
    private Integer orden;

    // Constructores
    public TablaBEntity() {}

    public TablaBEntity(Integer preguntaId, String opcion, Integer orden) {
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