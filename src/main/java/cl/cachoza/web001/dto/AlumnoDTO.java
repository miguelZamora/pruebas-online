package cl.cachoza.web001.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

public class AlumnoDTO {

    private Long idAlumno;

    @NotBlank(message = "El usuario es obligatorio")
    @Size(max = 50, message = "El usuario no puede tener más de 50 caracteres")
    private String usuario;

    @NotBlank(message = "La clave es obligatoria")
    @Size(max = 64, message = "La clave no puede tener más de 64 caracteres")
    private String clave;

    @NotBlank(message = "Los nombres son obligatorios")
    @Size(max = 250, message = "Los nombres no pueden tener más de 250 caracteres")
    private String nombres;

    @NotBlank(message = "El apellido paterno es obligatorio")
    @Size(max = 50, message = "El apellido paterno no puede tener más de 50 caracteres")
    private String apellidoPaterno;

    @NotBlank(message = "El apellido materno es obligatorio")
    @Size(max = 50, message = "El apellido materno no puede tener más de 50 caracteres")
    private String apellidoMaterno;

    @NotNull(message = "El estado es obligatorio")
    private Boolean estado = true;

    private LocalDateTime fechaIngreso;

    @NotNull(message = "La serie es obligatoria")
    private Long serie;

    // Constructores
    public AlumnoDTO() {}

    public AlumnoDTO(Long idAlumno, String usuario, String clave, String nombres, String apellidoPaterno, 
                    String apellidoMaterno, Boolean estado, LocalDateTime fechaIngreso, Long serie) {
        this.idAlumno = idAlumno;
        this.usuario = usuario;
        this.clave = clave;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.estado = estado;
        this.fechaIngreso = fechaIngreso;
        this.serie = serie;
    }

    // Getters y Setters
    public Long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Long getSerie() {
        return serie;
    }

    public void setSerie(Long serie) {
        this.serie = serie;
    }
}