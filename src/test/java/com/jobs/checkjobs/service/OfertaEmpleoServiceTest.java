package com.jobs.checkjobs.service;


import com.jobs.checkjobs.entity.OfertaEmpleo;
import com.jobs.checkjobs.repository.OfertaEmpleoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OfertaEmpleoServiceTest {

    @Mock
    OfertaEmpleoRepository ofertaEmpleoRepository;

    @InjectMocks
    OfertaEmpleoService ofertaEmpleoService;

    @Test
    void obtenerTodas_deberiaRetornarLista(){
        List<OfertaEmpleo> ofertas = List.of(new OfertaEmpleo(), new OfertaEmpleo());
        when(ofertaEmpleoRepository.findAll()).thenReturn(ofertas);

        List<OfertaEmpleo> resultado = ofertaEmpleoService.obtenerTodas();

        assertEquals(2,resultado.size());
        verify(ofertaEmpleoRepository).findAll();

    }

    @Test
    void crearOferta_deberiaGuardarOferta(){
        OfertaEmpleo oferta = new OfertaEmpleo();
        when(ofertaEmpleoRepository.save(oferta)).thenReturn(oferta);

        OfertaEmpleo resultado = ofertaEmpleoService.crearOferta(oferta);

        assertEquals(oferta,resultado);
        verify(ofertaEmpleoRepository).save(oferta);
    }
}
