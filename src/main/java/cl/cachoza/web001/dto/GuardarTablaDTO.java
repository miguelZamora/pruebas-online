package cl.cachoza.web001.dto;

public class GuardarTablaDTO {

    private Long idGuardarTabla;
    private Long guardarId;
    private String posicion;
    private String valor;

    // Constructores
    public GuardarTablaDTO() {}

    public GuardarTablaDTO(Long idGuardarTabla, Long guardarId, String posicion, String valor) {
        this.idGuardarTabla = idGuardarTabla;
        this.guardarId = guardarId;
        this.posicion = posicion;
        this.valor = valor;
    }

    // Getters y Setters
    public Long getIdGuardarTabla() {
        return idGuardarTabla;
    }

    public void setIdGuardarTabla(Long idGuardarTabla) {
        this.idGuardarTabla = idGuardarTabla;
    }

    public Long getGuardarId() {
        return guardarId;
    }

    public void setGuardarId(Long guardarId) {
        this.guardarId = guardarId;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}