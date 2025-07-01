package com.jobs.checkjobs.entity;

import jakarta.persistence.*;

@Entity
@Table(name ="aplicaciones")
public class Aplicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name= "usuario_id", nullable = false)
    private User usuario;

    @ManyToOne(optional = false)
    @JoinColumn(name="oferta_id",nullable = false)
    private OfertaEmpleo oferta;

    @Column(name="fecha_aplicacion")
    private String fechaAplicacion;

    public Aplicacion() {
    }

    public Aplicacion(Long id, User usuario, OfertaEmpleo oferta, String fechaAplicacion) {
        this.id = id;
        this.usuario = usuario;
        this.oferta = oferta;
        this.fechaAplicacion = fechaAplicacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public OfertaEmpleo getOferta() {
        return oferta;
    }

    public void setOferta(OfertaEmpleo oferta) {
        this.oferta = oferta;
    }

    public String getFechaAplicacion() {
        return fechaAplicacion;
    }

    public void setFechaAplicacion(String fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }
}
