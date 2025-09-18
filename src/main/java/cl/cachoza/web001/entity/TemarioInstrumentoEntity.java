package cl.cachoza.web001.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sef_temario_instrumentos")
public class TemarioInstrumentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_temario")
    private Long idTemario;

    @Column(name = "instrumento_id", nullable = false)
    private Long instrumentoId;

    @Column(name = "curso_id", nullable = false)
    private Long cursoId;

    // Constructores
    public TemarioInstrumentoEntity() {}

    public TemarioInstrumentoEntity(Long instrumentoId, Long cursoId) {
        this.instrumentoId = instrumentoId;
        this.cursoId = cursoId;
    }

    // Getters y Setters
    public Long getIdTemario() {
        return idTemario;
    }

    public void setIdTemario(Long idTemario) {
        this.idTemario = idTemario;
    }

    public Long getInstrumentoId() {
        return instrumentoId;
    }

    public void setInstrumentoId(Long instrumentoId) {
        this.instrumentoId = instrumentoId;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }
}