package cl.cachoza.web001.dto;

public class DictaDTO {

    private Long idDicta;
    private Long userProfesorId;
    private Long codigoCursoId;
    private Long asignaturaId;
    private Integer estado;

    // Constructores
    public DictaDTO() {}

    public DictaDTO(Long idDicta, Long userProfesorId, Long codigoCursoId, Long asignaturaId, Integer estado) {
        this.idDicta = idDicta;
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