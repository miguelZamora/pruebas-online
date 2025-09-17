package cl.cachoza.web001.dto;

public class InicioCicloDTO {

    private Long idInicioCiclo;
    private Long usuarioIdWp;
    private Long rbdId;

    // Constructores
    public InicioCicloDTO() {}

    public InicioCicloDTO(Long idInicioCiclo, Long usuarioIdWp, Long rbdId) {
        this.idInicioCiclo = idInicioCiclo;
        this.usuarioIdWp = usuarioIdWp;
        this.rbdId = rbdId;
    }

    // Getters y Setters
    public Long getIdInicioCiclo() {
        return idInicioCiclo;
    }

    public void setIdInicioCiclo(Long idInicioCiclo) {
        this.idInicioCiclo = idInicioCiclo;
    }

    public Long getUsuarioIdWp() {
        return usuarioIdWp;
    }

    public void setUsuarioIdWp(Long usuarioIdWp) {
        this.usuarioIdWp = usuarioIdWp;
    }

    public Long getRbdId() {
        return rbdId;
    }

    public void setRbdId(Long rbdId) {
        this.rbdId = rbdId;
    }
}