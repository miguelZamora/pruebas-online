package cl.cachoza.web001.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sef_cursos")
public class CursoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Long idCurso;

    @Column(name = "rbd_id", nullable = false)
    private Long rbdId;

    @Column(name = "codigonivel", nullable = false)
    private Long codigoNivel;

    @Column(name = "letra", nullable = false, length = 4)
    private String letra;

    @Column(name = "codigocurso", nullable = false, length = 200)
    private String codigoCurso;

    @Column(name = "anio", nullable = false)
    private Integer anio;

    @Column(name = "estado", nullable = false)
    private Integer estado;

    // Constructores
    public CursoEntity() {}

    public CursoEntity(Long rbdId, Long codigoNivel, String letra, String codigoCurso, Integer anio, Integer estado) {
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