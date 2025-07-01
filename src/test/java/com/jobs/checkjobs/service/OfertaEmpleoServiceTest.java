package com.jobs.checkjobs.service;


import com.jobs.checkjobs.entity.OfertaEmpleo;
import com.jobs.checkjobs.repository.OfertaEmpleoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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

    @Test
    void eliminarOfertaEmpleo_deberiaEliminarCuandoExiste(){
        Long id = 1L;

        when(ofertaEmpleoRepository.existsById(id)).thenReturn(true);

        boolean resultado = ofertaEmpleoService.eliminarOfertaEmpleo(id);

        assertTrue(resultado);
        verify(ofertaEmpleoRepository).deleteById(id);
    }

    @Test
    void eliminarOfertaEmpleo_deberiaRetornarFalseCuandoNoExiste(){
        Long id = 2L;

        when(ofertaEmpleoRepository.existsById(id)).thenReturn(false);


        boolean resultado = ofertaEmpleoService.eliminarOfertaEmpleo(id);

        assertFalse(resultado);
        verify(ofertaEmpleoRepository, never()).deleteById(anyLong());
    }
}
