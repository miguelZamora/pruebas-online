package cl.cachoza.web001.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sef_archivos")
public class ArchivoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_archivo")
    private Long idArchivo;

    @Column(name = "id_pregunta", nullable = false)
    private Long idPregunta;

    @Column(name = "contenido", nullable = false, columnDefinition = "TEXT")
    private String contenido;

    // Constructores
    public ArchivoEntity() {}

    public ArchivoEntity(Long idPregunta, String contenido) {
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