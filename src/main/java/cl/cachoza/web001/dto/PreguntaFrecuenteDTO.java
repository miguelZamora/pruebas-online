package cl.cachoza.web001.dto;

public class PreguntaFrecuenteDTO {

    private Long id;
    private String palabrasClaves;
    private String respuesta;
    private Long idUsuario;
    private String comentarios;

    // Constructores
    public PreguntaFrecuenteDTO() {}

    public PreguntaFrecuenteDTO(Long id, String palabrasClaves, String respuesta, Long idUsuario, String comentarios) {
        this.id = id;
        this.palabrasClaves = palabrasClaves;
        this.respuesta = respuesta;
        this.idUsuario = idUsuario;
        this.comentarios = comentarios;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPalabrasClaves() {
        return palabrasClaves;
    }

    public void setPalabrasClaves(String palabrasClaves) {
        this.palabrasClaves = palabrasClaves;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
}