package cl.cachoza.web001.dto;

import java.time.LocalDateTime;

public class PreguntaFrecuenteBitacoraDTO {

    private Long idBitacora;
    private String busqueda;
    private String ip;
    private Long idUsuario;
    private LocalDateTime fecha;

    // Constructores
    public PreguntaFrecuenteBitacoraDTO() {}

    public PreguntaFrecuenteBitacoraDTO(Long idBitacora, String busqueda, String ip, Long idUsuario, LocalDateTime fecha) {
        this.idBitacora = idBitacora;
        this.busqueda = busqueda;
        this.ip = ip;
        this.idUsuario = idUsuario;
        this.fecha = fecha;
    }

    // Getters y Setters
    public Long getIdBitacora() {
        return idBitacora;
    }

    public void setIdBitacora(Long idBitacora) {
        this.idBitacora = idBitacora;
    }

    public String getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(String busqueda) {
        this.busqueda = busqueda;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}