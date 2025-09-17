package cl.cachoza.web001.dto;

public class AsignaturaDTO {

    private Long idAsignatura;
    private String nombre;
    private String descripcion;

    // Constructores
    public AsignaturaDTO() {}

    public AsignaturaDTO(Long idAsignatura, String nombre, String descripcion) {
        this.idAsignatura = idAsignatura;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public Long getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Long idAsignatura) {
        this.idAsignatura = idAsignatura;
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