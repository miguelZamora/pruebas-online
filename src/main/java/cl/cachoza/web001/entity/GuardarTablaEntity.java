package cl.cachoza.web001.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sef_guardar_tabla")
public class GuardarTablaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_guardar_tabla")
    private Long idGuardarTabla;

    @Column(name = "guardar_id", nullable = false)
    private Long guardarId;

    @Column(name = "posicion", nullable = false, columnDefinition = "TEXT")
    private String posicion;

    @Column(name = "valor", nullable = false, columnDefinition = "TEXT")
    private String valor;

    // Constructores
    public GuardarTablaEntity() {}

    public GuardarTablaEntity(Long guardarId, String posicion, String valor) {
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