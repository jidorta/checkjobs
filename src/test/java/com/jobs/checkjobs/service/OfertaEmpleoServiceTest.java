package com.jobs.checkjobs.service;


import com.jobs.checkjobs.entity.OfertaEmpleo;
import com.jobs.checkjobs.repository.OfertaEmpleoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

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

    @Test
    void actualizar_deberiaActualizarCuandoExiste(){
        Long id = 1L;
        OfertaEmpleo ofertaEmpleoExistente = new OfertaEmpleo();
        ofertaEmpleoExistente.setTitulo("Antigua");
        ofertaEmpleoExistente.setSalario(1000.0);

        OfertaEmpleo ofertaEmpleoNueva = new OfertaEmpleo();
        ofertaEmpleoNueva.setTitulo("Nueva");
        ofertaEmpleoNueva.setSalario(1500.0);

        when(ofertaEmpleoRepository.findById(id)).thenReturn(java.util.Optional.of(ofertaEmpleoExistente));
        when(ofertaEmpleoRepository.save(ofertaEmpleoExistente)).thenReturn(ofertaEmpleoExistente);

        OfertaEmpleo resultado = ofertaEmpleoService.actualizar(id,ofertaEmpleoNueva);

        assertNotNull(resultado);
        assertEquals("Nueva", resultado.getTitulo());
        assertEquals(1500.0,resultado.getSalario());
        verify(ofertaEmpleoRepository).findById(id);
        verify(ofertaEmpleoRepository).save(ofertaEmpleoExistente);
    }

    @Test
    void actualizar_deberiaRetornarNullCuandoNoExiste(){
        Long id = 2L;
        OfertaEmpleo ofertaNueva = new OfertaEmpleo();

        when(ofertaEmpleoRepository.findById(id)).thenReturn(Optional.empty());

        OfertaEmpleo resultado = ofertaEmpleoService.actualizar(id,ofertaNueva);

        assertNull(resultado);
        verify(ofertaEmpleoRepository).findById(id);
        verify(ofertaEmpleoRepository,never()).save(any());
    }
}
