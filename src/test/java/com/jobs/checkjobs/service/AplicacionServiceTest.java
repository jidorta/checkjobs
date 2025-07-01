package com.jobs.checkjobs.service;

import com.jobs.checkjobs.entity.Aplicacion;
import com.jobs.checkjobs.entity.OfertaEmpleo;
import com.jobs.checkjobs.entity.User;
import com.jobs.checkjobs.repository.AplicacionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AplicacionServiceTest {

    @Mock
    AplicacionRepository aplicacionRepository;

    @InjectMocks
    AplicacionService aplicacionService;

    @Test
    public void guardarAplicacion_deberiaGuardarYRetornarAplicacion(){
        User usuario = new User();
        OfertaEmpleo oferta = new OfertaEmpleo();

        when(aplicacionRepository.findByUsuarioAndOferta(usuario,oferta)).thenReturn(Optional.empty());
        when(aplicacionRepository.save(any(Aplicacion.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Aplicacion result = aplicacionService.guardarAplicacion(usuario,oferta);
    }

}
