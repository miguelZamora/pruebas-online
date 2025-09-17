package cl.cachoza.web001.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sef_dicta")
public class DictaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dicta")
    private Long idDicta;

    @Column(name = "user_profesor_id", nullable = false)
    private Long userProfesorId;

    @Column(name = "codigocurso_id", nullable = false)
    private Long codigoCursoId;

    @Column(name = "asignatura_id", nullable = false)
    private Long asignaturaId;

    @Column(name = "estado", nullable = false)
    private Integer estado = 1;

    // Constructores
    public DictaEntity() {}

    public DictaEntity(Long userProfesorId, Long codigoCursoId, Long asignaturaId, Integer estado) {
        this.userProfesorId = userProfesorId;
        this.codigoCursoId = codigoCursoId;
        this.asignaturaId = asignaturaId;
        this.estado = estado;
    }

    // Getters y Setters
    public Long getIdDicta() {
        return idDicta;
    }

    public void setIdDicta(Long idDicta) {
        this.idDicta = idDicta;
    }

    public Long getUserProfesorId() {
        return userProfesorId;
    }

    public void setUserProfesorId(Long userProfesorId) {
        this.userProfesorId = userProfesorId;
    }

    public Long getCodigoCursoId() {
        return codigoCursoId;
    }

    public void setCodigoCursoId(Long codigoCursoId) {
        this.codigoCursoId = codigoCursoId;
    }

    public Long getAsignaturaId() {
        return asignaturaId;
    }

    public void setAsignaturaId(Long asignaturaId) {
        this.asignaturaId = asignaturaId;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}