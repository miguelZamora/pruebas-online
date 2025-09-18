package cl.cachoza.web001.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sef_instrumentos")
public class InstrumentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_instrumento")
    private Long idInstrumento;

    @Column(name = "nombre", length = 200)
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "cantidad_de_preguntas", nullable = false)
    private Integer cantidadDePreguntas;

    @Column(name = "insuficiente", columnDefinition = "TEXT")
    private String insuficiente;

    @Column(name = "adecuado", columnDefinition = "TEXT")
    private String adecuado;

    @Column(name = "visible")
    private Integer visible;

    // Constructores
    public InstrumentoEntity() {}

    public InstrumentoEntity(String nombre, String descripcion, Integer cantidadDePreguntas, 
                           String insuficiente, String adecuado, Integer visible) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidadDePreguntas = cantidadDePreguntas;
        this.insuficiente = insuficiente;
        this.adecuado = adecuado;
        this.visible = visible;
    }

    // Getters y Setters
    public Long getIdInstrumento() {
        return idInstrumento;
    }

    public void setIdInstrumento(Long idInstrumento) {
        this.idInstrumento = idInstrumento;
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

    public Integer getCantidadDePreguntas() {
        return cantidadDePreguntas;
    }

    public void setCantidadDePreguntas(Integer cantidadDePreguntas) {
        this.cantidadDePreguntas = cantidadDePreguntas;
    }

    public String getInsuficiente() {
        return insuficiente;
    }

    public void setInsuficiente(String insuficiente) {
        this.insuficiente = insuficiente;
    }

    public String getAdecuado() {
        return adecuado;
    }

    public void setAdecuado(String adecuado) {
        this.adecuado = adecuado;
    }

    public Integer getVisible() {
        return visible;
    }

    public void setVisible(Integer visible) {
        this.visible = visible;
    }
}