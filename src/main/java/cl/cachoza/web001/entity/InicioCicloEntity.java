package cl.cachoza.web001.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sef_inicio_ciclo")
public class InicioCicloEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inicio_ciclo")
    private Long idInicioCiclo;

    @Column(name = "usuario_id_wp", nullable = false)
    private Long usuarioIdWp;

    @Column(name = "rbd_id", nullable = false)
    private Long rbdId;

    // Constructores
    public InicioCicloEntity() {}

    public InicioCicloEntity(Long usuarioIdWp, Long rbdId) {
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