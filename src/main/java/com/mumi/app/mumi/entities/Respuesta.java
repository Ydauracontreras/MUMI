package com.mumi.app.mumi.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.mumi.app.mumi.entities.Opcion.OpcionEnum;

@Entity
@Table(name = "respuesta")
public class Respuesta {
    @Id
    @Column(name = "respuesta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "pregunta_id")
    private Pregunta preguntaId;
    @Column(name = "opcion_elegida_id")
    private Integer opcionElegidaId; // mapea el enum de opciones cuando se crea la respuesta
    @Column(name = "opcion_elegida")
    private String opcionElegida;
    private Integer point; // por cada respuesta
    @Column(name = "opcion_enum")
    private OpcionEnum opcionEnum;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "respuesta_id")
    private Respuesta respuesta;

    public Respuesta() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Respuesta(Integer id, Integer point) {
        this.id = id;
        this.point = point;
    }

    public Pregunta getPreguntaId() {
        return preguntaId;
    }

    public void setPreguntaId(Pregunta preguntaId) {
        this.preguntaId = preguntaId;
    }

    public Integer getOpcionElegidaId() {
        return opcionElegidaId;
    }

    public void setOpcionElegidaId(Integer opcionElegidaId) {
        this.opcionElegidaId = opcionElegidaId;
    }

    public void setOpcionElegida(String opcionElegida) {
        this.opcionElegida = opcionElegida;
    }

    public String getOpcionElegida() {
        return opcionElegida;
    }

    public OpcionEnum getOpcionEnum() {
        return opcionEnum;
    }

    public void setOpcionEnum(OpcionEnum opcionEnum) {
        this.opcionEnum = opcionEnum;
    }

    public void agregarPregunta(Pregunta pregunta) {
        pregunta.setRespuesta(this);
    }

}
