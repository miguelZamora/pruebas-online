package cl.cachoza.web001.dto;

public class TextoAsociadoDTO {

    private Long idTextoAsociado;
    private String texto;

    // Constructores
    public TextoAsociadoDTO() {}

    public TextoAsociadoDTO(Long idTextoAsociado, String texto) {
        this.idTextoAsociado = idTextoAsociado;
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