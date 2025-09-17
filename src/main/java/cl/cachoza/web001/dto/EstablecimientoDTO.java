package cl.cachoza.web001.dto;

public class EstablecimientoDTO {

    private Long idEstablecimiento;
    private Long rbd;
    private Long dvrbd;
    private String nombre;
    private Boolean eliminar;

    // Constructores
    public EstablecimientoDTO() {}

    public EstablecimientoDTO(Long idEstablecimiento, Long rbd, Long dvrbd, String nombre, Boolean eliminar) {
        this.idEstablecimiento = idEstablecimiento;
        this.rbd = rbd;
        this.dvrbd = dvrbd;
        this.nombre = nombre;
        this.eliminar = eliminar;
    }

    // Getters y Setters
    public Long getIdEstablecimiento() {
        return idEstablecimiento;
    }

    public void setIdEstablecimiento(Long idEstablecimiento) {
        this.idEstablecimiento = idEstablecimiento;
    }

    public Long getRbd() {
        return rbd;
    }

    public void setRbd(Long rbd) {
        this.rbd = rbd;
    }

    public Long getDvrbd() {
        return dvrbd;
    }

    public void setDvrbd(Long dvrbd) {
        this.dvrbd = dvrbd;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getEliminar() {
        return eliminar;
    }

    public void setEliminar(Boolean eliminar) {
        this.eliminar = eliminar;
    }
}