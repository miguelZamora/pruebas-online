package cl.cachoza.web001.dto;

import java.time.LocalDateTime;

public class RespuestaAlumnoDTO {

    private Long idRespuestasAlumno;
    private Integer respondeId;
    private Integer preguntaId;
    private String alternativaEscogida;
    private Integer intentoNumero;
    private LocalDateTime hora;
    private Float correcta;
    private String tipo;
    private String desarrollo;
    private Boolean papel;

    // Constructores
    public RespuestaAlumnoDTO() {}

    public RespuestaAlumnoDTO(Long idRespuestasAlumno, Integer respondeId, Integer preguntaId, 
                            String alternativaEscogida, Integer intentoNumero, LocalDateTime hora, 
                            Float correcta, String tipo, String desarrollo, Boolean papel) {
        this.idRespuestasAlumno = idRespuestasAlumno;
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