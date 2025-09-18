package cl.cachoza.web001.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sef_preguntas_frecuentes_bitacora")
public class PreguntaFrecuenteBitacoraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bitacora")
    private Long idBitacora;

    @Column(name = "busqueda", nullable = false, length = 255)
    private String busqueda;

    @Column(name = "ip", nullable = false, length = 200)
    private String ip;

    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    // Constructores
    public PreguntaFrecuenteBitacoraEntity() {}

    public PreguntaFrecuenteBitacoraEntity(String busqueda, String ip, Long idUsuario, LocalDateTime fecha) {
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