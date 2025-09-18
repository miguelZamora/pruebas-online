package cl.cachoza.web001.dto;

public class InstrumentoDTO {

    private Long idInstrumento;
    private String nombre;
    private String descripcion;
    private Integer cantidadDePreguntas;
    private String insuficiente;
    private String adecuado;
    private Integer visible;

    // Constructores
    public InstrumentoDTO() {}

    public InstrumentoDTO(Long idInstrumento, String nombre, String descripcion, Integer cantidadDePreguntas, 
                         String insuficiente, String adecuado, Integer visible) {
        this.idInstrumento = idInstrumento;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidadDePreguntas = cantidadDePreguntas;
        this.insuficiente = insuficiente;
        this.adecuado = adecuado;
        this.visible = visible;
    }

    // Getters y Setters
    public Long getIdInstrumento() {
        return idInstrumento;
    }

    public void setIdInstrumento(Long idInstrumento) {
        this.idInstrumento = idInstrumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCantidadDePreguntas() {
        return cantidadDePreguntas;
    }

    public void setCantidadDePreguntas(Integer cantidadDePreguntas) {
        this.cantidadDePreguntas = cantidadDePreguntas;
    }

    public String getInsuficiente() {
        return insuficiente;
    }

    public void setInsuficiente(String insuficiente) {
        this.insuficiente = insuficiente;
    }

    public String getAdecuado() {
        return adecuado;
    }

    public void setAdecuado(String adecuado) {
        this.adecuado = adecuado;
    }

    public Integer getVisible() {
        return visible;
    }

    public void setVisible(Integer visible) {
        this.visible = visible;
    }
}