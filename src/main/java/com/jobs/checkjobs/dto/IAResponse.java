package com.jobs.checkjobs.dto;

import lombok.Data;


public class IAResponse {
    private String descripcion;

    public IAResponse() {
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
