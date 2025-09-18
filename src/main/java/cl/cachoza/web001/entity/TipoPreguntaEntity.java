package cl.cachoza.web001.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sef_tipo_pregunta")
public class TipoPreguntaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_pregunta")
    private Long idTipoPregunta;

    @Column(name = "nombre", nullable = false, length = 20)
    private String nombre;

    @Column(name = "descripcion", nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    // Constructores
    public TipoPreguntaEntity() {}

    public TipoPreguntaEntity(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public Long getIdTipoPregunta() {
        return idTipoPregunta;
    }

    public void setIdTipoPregunta(Long idTipoPregunta) {
        this.idTipoPregunta = idTipoPregunta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}