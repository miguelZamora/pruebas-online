package cl.cachoza.web001.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sef_responde")
public class RespondeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_responde")
    private Long idResponde;

    @Column(name = "instrumento_instancia_id", nullable = false)
    private Integer instrumentoInstanciaId;

    @Column(name = "alumno_id", nullable = false, length = 15)
    private String alumnoId;

    // Constructores
    public RespondeEntity() {}

    public RespondeEntity(Integer instrumentoInstanciaId, String alumnoId) {
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