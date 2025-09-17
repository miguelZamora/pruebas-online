package cl.cachoza.web001.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sef_establecimientos")
public class EstablecimientoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_establecimiento")
    private Long idEstablecimiento;

    @Column(name = "rbd", nullable = false)
    private Long rbd;

    @Column(name = "dvrbd", nullable = false)
    private Long dvrbd;

    @Column(name = "nombre", nullable = false, columnDefinition = "TEXT")
    private String nombre;

    @Column(name = "eliminar", nullable = false)
    private Boolean eliminar = false;

    // Constructores
    public EstablecimientoEntity() {}

    public EstablecimientoEntity(Long rbd, Long dvrbd, String nombre, Boolean eliminar) {
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