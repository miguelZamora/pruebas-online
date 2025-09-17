package cl.cachoza.web001.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ArchivoDTO {

    private Long idArchivo;

    @NotNull(message = "El ID de pregunta es obligatorio")
    private Long idPregunta;

    @NotBlank(message = "El contenido es obligatorio")
    private String contenido;

    // Constructores
    public ArchivoDTO() {}

    public ArchivoDTO(Long idArchivo, Long idPregunta, String contenido) {
        this.idArchivo = idArchivo;
        this.idPregunta = idPregunta;
        this.contenido = contenido;
    }

    // Getters y Setters
    public Long getIdArchivo() {
        return idArchivo;
    }

    public void setIdArchivo(Long idArchivo) {
        this.idArchivo = idArchivo;
    }

    public Long getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Long idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}