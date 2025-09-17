package cl.cachoza.web001.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sef_guardar")
public class GuardarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_guardar")
    private Long idGuardar;

    @Column(name = "profesor_id", nullable = false)
    private Long profesorId;

    @Column(name = "curso_id", nullable = false)
    private Long cursoId;

    @Column(name = "instrumento_id", nullable = false)
    private Long instrumentoId;

    @Column(name = "valor", nullable = false, columnDefinition = "TEXT")
    private String valor;

    @Column(name = "papel")
    private Boolean papel = false;

    // Constructores
    public GuardarEntity() {}

    public GuardarEntity(Long profesorId, Long cursoId, Long instrumentoId, String valor, Boolean papel) {
        this.profesorId = profesorId;
        this.cursoId = cursoId;
        this.instrumentoId = instrumentoId;
        this.valor = valor;
        this.papel = papel;
    }

    // Getters y Setters
    public Long getIdGuardar() {
        return idGuardar;
    }

    public void setIdGuardar(Long idGuardar) {
        this.idGuardar = idGuardar;
    }

    public Long getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(Long profesorId) {
        this.profesorId = profesorId;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }

    public Long getInstrumentoId() {
        return instrumentoId;
    }

    public void setInstrumentoId(Long instrumentoId) {
        this.instrumentoId = instrumentoId;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Boolean getPapel() {
        return papel;
    }

    public void setPapel(Boolean papel) {
        this.papel = papel;
    }
}