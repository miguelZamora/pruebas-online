package cl.cachoza.web001.dto;

public class TipoPreguntaDTO {

    private Long idTipoPregunta;
    private String nombre;
    private String descripcion;

    // Constructores
    public TipoPreguntaDTO() {}

    public TipoPreguntaDTO(Long idTipoPregunta, String nombre, String descripcion) {
        this.idTipoPregunta = idTipoPregunta;
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