package com.jobs.checkjobs.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class IAServiceTest {

    @Test
    void consultaIA_deberiaDevolverRespuesta(){
        IAService iaService = new IAService("dummy-api-key");
        String respuesta = iaService.consultaIA("Hola IA");

        assertTrue(respuesta.contains("Hola IA"));
    }
}
