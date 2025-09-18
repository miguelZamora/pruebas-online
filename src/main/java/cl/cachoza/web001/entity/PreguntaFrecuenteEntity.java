package cl.cachoza.web001.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sef_preguntas_frecuentes")
public class PreguntaFrecuenteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "palabras_claves", nullable = false, columnDefinition = "TEXT")
    private String palabrasClaves;

    @Column(name = "respuesta", nullable = false, columnDefinition = "TEXT")
    private String respuesta;

    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "comentarios", length = 200)
    private String comentarios;

    // Constructores
    public PreguntaFrecuenteEntity() {}

    public PreguntaFrecuenteEntity(String palabrasClaves, String respuesta, Long idUsuario, String comentarios) {
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