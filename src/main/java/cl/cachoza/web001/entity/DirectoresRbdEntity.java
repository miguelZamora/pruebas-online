package cl.cachoza.web001.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sef_directores_rbd")
public class DirectoresRbdEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuarios_directores")
    private Long idUsuariosDirectores;

    @Column(name = "rut", length = 10)
    private String rut;

    @Column(name = "rbd", length = 45)
    private String rbd;

    @Column(name = "tipow", length = 50)
    private String tipoW;

    @Column(name = "origen", length = 50)
    private String origen;

    @Column(name = "es_test", nullable = false)
    private Boolean esTest = false;

    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    // Constructores
    public DirectoresRbdEntity() {
        this.fechaCreacion = LocalDateTime.now();
    }

    public DirectoresRbdEntity(String rut, String rbd, String tipoW, String origen, Boolean esTest) {
        this.rut = rut;
        this.rbd = rbd;
        this.tipoW = tipoW;
        this.origen = origen;
        this.esTest = esTest;
        this.fechaCreacion = LocalDateTime.now();
    }

    // Getters y Setters
    public Long getIdUsuariosDirectores() {
        return idUsuariosDirectores;
    }

    public void setIdUsuariosDirectores(Long idUsuariosDirectores) {
        this.idUsuariosDirectores = idUsuariosDirectores;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getRbd() {
        return rbd;
    }

    public void setRbd(String rbd) {
        this.rbd = rbd;
    }

    public String getTipoW() {
        return tipoW;
    }

    public void setTipoW(String tipoW) {
        this.tipoW = tipoW;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public Boolean getEsTest() {
        return esTest;
    }

    public void setEsTest(Boolean esTest) {
        this.esTest = esTest;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}