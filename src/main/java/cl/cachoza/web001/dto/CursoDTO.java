package cl.cachoza.web001.dto;

public class CursoDTO {

    private Long idCurso;
    private Long rbdId;
    private Long codigoNivel;
    private String letra;
    private String codigoCurso;
    private Integer anio;
    private Integer estado;

    // Constructores
    public CursoDTO() {}

    public CursoDTO(Long idCurso, Long rbdId, Long codigoNivel, String letra, String codigoCurso, Integer anio, Integer estado) {
        this.idCurso = idCurso;
        this.rbdId = rbdId;
        this.codigoNivel = codigoNivel;
        this.letra = letra;
        this.codigoCurso = codigoCurso;
        this.anio = anio;
        this.estado = estado;
    }

    // Getters y Setters
    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public Long getRbdId() {
        return rbdId;
    }

    public void setRbdId(Long rbdId) {
        this.rbdId = rbdId;
    }

    public Long getCodigoNivel() {
        return codigoNivel;
    }

    public void setCodigoNivel(Long codigoNivel) {
        this.codigoNivel = codigoNivel;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}