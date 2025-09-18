package cl.cachoza.web001.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sef_preguntas")
public class PreguntaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pregunta")
    private Long idPregunta;

    @Column(name = "enunciado", nullable = false, columnDefinition = "TEXT")
    private String enunciado;

    @Column(name = "tipo", nullable = false, length = 20)
    private String tipo;

    @Column(name = "cantidad_alternativas", nullable = false)
    private Integer cantidadAlternativas;

    @Column(name = "texto_asociado_id")
    private Integer textoAsociadoId;

    @Column(name = "id_antiguo", nullable = false, length = 20)
    private String idAntiguo;

    @Column(name = "nivel", nullable = false, length = 2)
    private String nivel;

    @Column(name = "curso", nullable = false, length = 2)
    private String curso;

    @Column(name = "asignatura", nullable = false, length = 3)
    private String asignatura;

    @Column(name = "eje", nullable = false, columnDefinition = "TEXT")
    private String eje;

    @Column(name = "dominio_cognitivo", nullable = false, columnDefinition = "TEXT")
    private String dominioCognitivo;

    @Column(name = "objetivo_general", nullable = false, columnDefinition = "TEXT")
    private String objetivoGeneral;

    @Column(name = "nombre_estimulo", nullable = false, columnDefinition = "TEXT")
    private String nombreEstimulo;

    @Column(name = "semi_offline", nullable = false)
    private Boolean semiOffline = false;

    @Column(name = "autor_item", columnDefinition = "TEXT")
    private String autorItem;

    @Column(name = "genero_textual", columnDefinition = "TEXT")
    private String generoTextual;

    @Column(name = "referencia_curricular", columnDefinition = "TEXT")
    private String referenciaCurricular;

    @Column(name = "oah_of", columnDefinition = "TEXT")
    private String oahOf;

    @Column(name = "oac_cmo", columnDefinition = "TEXT")
    private String oacCmo;

    @Column(name = "objetivo_de_evaluacion_especifico", columnDefinition = "TEXT")
    private String objetivoEvaluacionEspecifico;

    @Column(name = "fuente_estimulo", columnDefinition = "TEXT")
    private String fuenteEstimulo;

    @Column(name = "fuentes_item", columnDefinition = "TEXT")
    private String fuentesItem;

    @Column(name = "estado_item", columnDefinition = "TEXT")
    private String estadoItem;

    @Column(name = "observaciones", columnDefinition = "TEXT")
    private String observaciones;

    @Column(name = "puntaje_de_respuestas_correcta", columnDefinition = "TEXT")
    private String puntajeRespuestasCorrecta;

    @Column(name = "respuestas_parcialmente_correctas", columnDefinition = "TEXT")
    private String respuestasParcialmenteCorrectas;

    @Column(name = "puntaje_de_respuestas_parcialmente_correctas", columnDefinition = "TEXT")
    private String puntajeRespuestasParcialmenteCorrectas;

    @Column(name = "respuesta_correcta", columnDefinition = "TEXT")
    private String respuestaCorrecta;

    @Column(name = "peso", nullable = false)
    private Float peso = 1.0f;

    // Constructores
    public PreguntaEntity() {}

    public PreguntaEntity(String enunciado, String tipo, Integer cantidadAlternativas, String idAntiguo,
                        String nivel, String curso, String asignatura, String eje, String dominioCognitivo,
                        String objetivoGeneral, String nombreEstimulo, Boolean semiOffline, Float peso) {
        this.enunciado = enunciado;
        this.tipo = tipo;
        this.cantidadAlternativas = cantidadAlternativas;
        this.idAntiguo = idAntiguo;
        this.nivel = nivel;
        this.curso = curso;
        this.asignatura = asignatura;
        this.eje = eje;
        this.dominioCognitivo = dominioCognitivo;
        this.objetivoGeneral = objetivoGeneral;
        this.nombreEstimulo = nombreEstimulo;
        this.semiOffline = semiOffline;
        this.peso = peso;
    }

    // Getters y Setters
    public Long getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Long idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getCantidadAlternativas() {
        return cantidadAlternativas;
    }

    public void setCantidadAlternativas(Integer cantidadAlternativas) {
        this.cantidadAlternativas = cantidadAlternativas;
    }

    public Integer getTextoAsociadoId() {
        return textoAsociadoId;
    }

    public void setTextoAsociadoId(Integer textoAsociadoId) {
        this.textoAsociadoId = textoAsociadoId;
    }

    public String getIdAntiguo() {
        return idAntiguo;
    }

    public void setIdAntiguo(String idAntiguo) {
        this.idAntiguo = idAntiguo;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getEje() {
        return eje;
    }

    public void setEje(String eje) {
        this.eje = eje;
    }

    public String getDominioCognitivo() {
        return dominioCognitivo;
    }

    public void setDominioCognitivo(String dominioCognitivo) {
        this.dominioCognitivo = dominioCognitivo;
    }

    public String getObjetivoGeneral() {
        return objetivoGeneral;
    }

    public void setObjetivoGeneral(String objetivoGeneral) {
        this.objetivoGeneral = objetivoGeneral;
    }

    public String getNombreEstimulo() {
        return nombreEstimulo;
    }

    public void setNombreEstimulo(String nombreEstimulo) {
        this.nombreEstimulo = nombreEstimulo;
    }

    public Boolean getSemiOffline() {
        return semiOffline;
    }

    public void setSemiOffline(Boolean semiOffline) {
        this.semiOffline = semiOffline;
    }

    public String getAutorItem() {
        return autorItem;
    }

    public void setAutorItem(String autorItem) {
        this.autorItem = autorItem;
    }

    public String getGeneroTextual() {
        return generoTextual;
    }

    public void setGeneroTextual(String generoTextual) {
        this.generoTextual = generoTextual;
    }

    public String getReferenciaCurricular() {
        return referenciaCurricular;
    }

    public void setReferenciaCurricular(String referenciaCurricular) {
        this.referenciaCurricular = referenciaCurricular;
    }

    public String getOahOf() {
        return oahOf;
    }

    public void setOahOf(String oahOf) {
        this.oahOf = oahOf;
    }

    public String getOacCmo() {
        return oacCmo;
    }

    public void setOacCmo(String oacCmo) {
        this.oacCmo = oacCmo;
    }

    public String getObjetivoEvaluacionEspecifico() {
        return objetivoEvaluacionEspecifico;
    }

    public void setObjetivoEvaluacionEspecifico(String objetivoEvaluacionEspecifico) {
        this.objetivoEvaluacionEspecifico = objetivoEvaluacionEspecifico;
    }

    public String getFuenteEstimulo() {
        return fuenteEstimulo;
    }

    public void setFuenteEstimulo(String fuenteEstimulo) {
        this.fuenteEstimulo = fuenteEstimulo;
    }

    public String getFuentesItem() {
        return fuentesItem;
    }

    public void setFuentesItem(String fuentesItem) {
        this.fuentesItem = fuentesItem;
    }

    public String getEstadoItem() {
        return estadoItem;
    }

    public void setEstadoItem(String estadoItem) {
        this.estadoItem = estadoItem;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getPuntajeRespuestasCorrecta() {
        return puntajeRespuestasCorrecta;
    }

    public void setPuntajeRespuestasCorrecta(String puntajeRespuestasCorrecta) {
        this.puntajeRespuestasCorrecta = puntajeRespuestasCorrecta;
    }

    public String getRespuestasParcialmenteCorrectas() {
        return respuestasParcialmenteCorrectas;
    }

    public void setRespuestasParcialmenteCorrectas(String respuestasParcialmenteCorrectas) {
        this.respuestasParcialmenteCorrectas = respuestasParcialmenteCorrectas;
    }

    public String getPuntajeRespuestasParcialmenteCorrectas() {
        return puntajeRespuestasParcialmenteCorrectas;
    }

    public void setPuntajeRespuestasParcialmenteCorrectas(String puntajeRespuestasParcialmenteCorrectas) {
        this.puntajeRespuestasParcialmenteCorrectas = puntajeRespuestasParcialmenteCorrectas;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }
}