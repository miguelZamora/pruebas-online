package cl.cachoza.web001.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sef_texto_asociado")
public class TextoAsociadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_texto_asociado")
    private Long idTextoAsociado;

    @Column(name = "texto", nullable = false, columnDefinition = "TEXT")
    private String texto;

    // Constructores
    public TextoAsociadoEntity() {}

    public TextoAsociadoEntity(String texto) {
        this.texto = texto;
    }

    // Getters y Setters
    public Long getIdTextoAsociado() {
        return idTextoAsociado;
    }

    public void setIdTextoAsociado(Long idTextoAsociado) {
        this.idTextoAsociado = idTextoAsociado;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}