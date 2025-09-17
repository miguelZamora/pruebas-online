package cl.cachoza.web001.dto;

import java.time.LocalDateTime;

public class DirectoresRbdDTO {

    private Long idUsuariosDirectores;
    private String rut;
    private String rbd;
    private String tipoW;
    private String origen;
    private Boolean esTest;
    private LocalDateTime fechaCreacion;

    // Constructores
    public DirectoresRbdDTO() {}

    public DirectoresRbdDTO(Long idUsuariosDirectores, String rut, String rbd, String tipoW, String origen, Boolean esTest, LocalDateTime fechaCreacion) {
        this.idUsuariosDirectores = idUsuariosDirectores;
        this.rut = rut;
        this.rbd = rbd;
        this.tipoW = tipoW;
        this.origen = origen;
        this.esTest = esTest;
        this.fechaCreacion = fechaCreacion;
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