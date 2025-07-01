package com.jobs.checkjobs.service;

import com.jobs.checkjobs.entity.Aplicacion;
import com.jobs.checkjobs.entity.OfertaEmpleo;
import com.jobs.checkjobs.entity.User;
import com.jobs.checkjobs.repository.AplicacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AplicacionService {
    private final AplicacionRepository aplicacionRepository;


    public AplicacionService(AplicacionRepository aplicacionRepository) {
        this.aplicacionRepository = aplicacionRepository;
    }

    public Aplicacion guardarAplicacion(User usuario, OfertaEmpleo oferta){
        boolean existe = aplicacionRepository.findByUsuarioAndOferta(usuario,oferta).isPresent();
        if (existe){
            throw new IllegalStateException("Ya existe una aplicacion para esta oferta");
        }

        Aplicacion aplicacion = new Aplicacion();
        aplicacion.setUsuario(usuario);
        aplicacion.setOferta(oferta);
        return aplicacionRepository.save(aplicacion);


    }

    public List<Aplicacion>obtenerTodas(){
        return aplicacionRepository.findAll();
    }
}
