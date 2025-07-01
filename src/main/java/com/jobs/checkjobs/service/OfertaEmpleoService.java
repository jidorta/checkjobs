package com.jobs.checkjobs.service;

import com.jobs.checkjobs.entity.OfertaEmpleo;
import com.jobs.checkjobs.repository.OfertaEmpleoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfertaEmpleoService {
    private final OfertaEmpleoRepository ofertaEmpleoRepository;

    public OfertaEmpleoService(OfertaEmpleoRepository ofertaEmpleoRepository) {
        this.ofertaEmpleoRepository = ofertaEmpleoRepository;
    }

    public List<OfertaEmpleo> obtenerTodas(){
        return ofertaEmpleoRepository.findAll();
    }

    public OfertaEmpleo crearOferta(OfertaEmpleo oferta){
        return ofertaEmpleoRepository.save(oferta);
    }

    public OfertaEmpleo actualizar(Long id, OfertaEmpleo ofertaNueva){
        return ofertaEmpleoRepository.findById(id)
                .map(ofertaExistente ->{
                    ofertaExistente.setTitulo(ofertaNueva.getTitulo());
                    ofertaExistente.setSalario(ofertaNueva.getSalario());
                    return ofertaEmpleoRepository.save(ofertaExistente);
                })
                .orElse(null);
    }

    public boolean eliminarOfertaEmpleo(Long id){
        if(ofertaEmpleoRepository.existsById(id)){
            ofertaEmpleoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
