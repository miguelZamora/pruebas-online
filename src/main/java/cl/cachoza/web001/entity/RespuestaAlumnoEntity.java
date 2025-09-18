package cl.cachoza.web001.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sef_respuestas_alumno")
public class RespuestaAlumnoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_respuestas_alumno")
    private Long idRespuestasAlumno;

    @Column(name = "responde_id", nullable = false)
    private Integer respondeId;

    @Column(name = "pregunta_id", nullable = false)
    private Integer preguntaId;

    @Column(name = "alternativa_escogida", nullable = false, columnDefinition = "TEXT")
    private String alternativaEscogida;

    @Column(name = "intento_numero", nullable = false)
    private Integer intentoNumero;

    @Column(name = "hora", nullable = false)
    private LocalDateTime hora;

    @Column(name = "correcta", nullable = false)
    private Float correcta;

    @Column(name = "tipo", nullable = false, length = 20)
    private String tipo;

    @Column(name = "desarrollo", columnDefinition = "TEXT")
    private String desarrollo;

    @Column(name = "papel")
    private Boolean papel = false;

    // Constructores
    public RespuestaAlumnoEntity() {}

    public RespuestaAlumnoEntity(Integer respondeId, Integer preguntaId, String alternativaEscogida, 
                               Integer intentoNumero, LocalDateTime hora, Float correcta, 
                               String tipo, String desarrollo, Boolean papel) {
        this.respondeId = respondeId;
        this.preguntaId = preguntaId;
        this.alternativaEscogida = alternativaEscogida;
        this.intentoNumero = intentoNumero;
        this.hora = hora;
        this.correcta = correcta;
        this.tipo = tipo;
        this.desarrollo = desarrollo;
        this.papel = papel;
    }

    // Getters y Setters
    public Long getIdRespuestasAlumno() {
        return idRespuestasAlumno;
    }

    public void setIdRespuestasAlumno(Long idRespuestasAlumno) {
        this.idRespuestasAlumno = idRespuestasAlumno;
    }

    public Integer getRespondeId() {
        return respondeId;
    }

    public void setRespondeId(Integer respondeId) {
        this.respondeId = respondeId;
    }

    public Integer getPreguntaId() {
        return preguntaId;
    }

    public void setPreguntaId(Integer preguntaId) {
        this.preguntaId = preguntaId;
    }

    public String getAlternativaEscogida() {
        return alternativaEscogida;
    }

    public void setAlternativaEscogida(String alternativaEscogida) {
        this.alternativaEscogida = alternativaEscogida;
    }

    public Integer getIntentoNumero() {
        return intentoNumero;
    }

    public void setIntentoNumero(Integer intentoNumero) {
        this.intentoNumero = intentoNumero;
    }

    public LocalDateTime getHora() {
        return hora;
    }

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }

    public Float getCorrecta() {
        return correcta;
    }

    public void setCorrecta(Float correcta) {
        this.correcta = correcta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDesarrollo() {
        return desarrollo;
    }

    public void setDesarrollo(String desarrollo) {
        this.desarrollo = desarrollo;
    }

    public Boolean getPapel() {
        return papel;
    }

    public void setPapel(Boolean papel) {
        this.papel = papel;
    }
}