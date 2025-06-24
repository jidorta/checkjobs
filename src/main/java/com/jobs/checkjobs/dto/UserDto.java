package com.jobs.checkjobs.dto;

import com.jobs.checkjobs.entity.OfertaEmpleo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


public class UserDto {
    private Long id;
    private String nombre;
    private String email;
    private String telefono;
    private String descripcion;

    private List<OfertaEmpleoDto> ofertasPublicadas;

    public UserDto(Long id, String nombre, String email, String telefono, List<OfertaEmpleoDto> ofertasPublicadas) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.ofertasPublicadas = ofertasPublicadas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public UserDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<OfertaEmpleoDto> getOfertasPublicadas() {
        return ofertasPublicadas;
    }

    public void setOfertasPublicadas(List<OfertaEmpleoDto> ofertasPublicadas) {
        this.ofertasPublicadas = ofertasPublicadas;
    }
}
