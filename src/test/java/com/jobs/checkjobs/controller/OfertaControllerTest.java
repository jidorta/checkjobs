package com.jobs.checkjobs.controller;

import com.jobs.checkjobs.service.OfertaEmpleoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OfertaController.class)
public class OfertaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private OfertaEmpleoService ofertaEmpleoService;

    @Test
    void eliminarOferta_deberiaRetomarNoContentSiExiste() throws Exception{
        Long id = 1L;

        when(ofertaEmpleoService.eliminarOfertaEmpleo(id)).thenReturn(true);

        mockMvc.perform(delete("/ofertas/{id}",id))
                .andExpect(status().isNoContent());
    }

    @Test
    void eliminarOferta_deberiaRetornarNotFoundSiNoExiste() throws Exception{
        Long id = 999L;
        when(ofertaEmpleoService.eliminarOfertaEmpleo(id)).thenReturn(false);

        mockMvc.perform(delete("/ofertas/{id}",id))
                .andExpect(status().isNotFound());
    }
}
