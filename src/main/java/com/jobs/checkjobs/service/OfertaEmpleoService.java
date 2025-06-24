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
}
