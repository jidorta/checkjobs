package com.jobs.checkjobs.controller;

import com.jobs.checkjobs.entity.OfertaEmpleo;
import com.jobs.checkjobs.entity.User;
import com.jobs.checkjobs.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    void listarUsuarios_deberiaDevolverListaDeUsuarios(){

        User user1 =  new User(1L,"iban","ibandorta@gmail.com");
        User user2 = new User(2L,"Leura","leura@gmail.com");
        List<User> listaUsuarios = List.of(user1,user2);


        when(userService.obtenerTodos()).thenReturn(listaUsuarios);

     List<User> resultado = userController.listarUsuarios();

     //Assert
        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        assertEquals("iban", resultado.get(0).getNombre());

    }

    @Test
    void crearUsuarioConOfertas_deberiaCrearUsuarioCorrectamente(){

        User usuario = new User(null, "Iban","ibandorta@gmail.com");

        List<OfertaEmpleo> ofertas = List.of(new OfertaEmpleo(1L, "Java Dev"), new OfertaEmpleo(2L,"Spring Boot"));

        when(userService.crearUsuarioConOfertas(eq(usuario),nullable(List.class))).thenReturn(usuario);

        User resultado = userController.crearUsuarioConOfertas(usuario);

        assertNotNull(resultado);
        assertEquals("Iban",resultado.getNombre());
        //verify(userService,times(1));
        verify(userService, times(1)).crearUsuarioConOfertas(eq(usuario), any());

    }
    @Test
    void crearUsuarioConOfertas_deberiaLanzarExcepcionCuandoServicioFalla(){

        User usuario = new User();
        usuario.setId(null);
        usuario.setNombre("Iban");
        usuario.setEmail("ibandorta@gmail.com");
        usuario.setOfertasPublicadas(List.of());

        //Simulamos que el servicio lanza RuntimeException
        when(userService.crearUsuarioConOfertas(eq(usuario),any()))
                .thenThrow(new RuntimeException("Error en servicio"));

        RuntimeException exception = assertThrows(RuntimeException.class,()->{
            userController.crearUsuarioConOfertas(usuario);
        });

        assertEquals("Error en servicio",exception.getMessage());

        verify(userService,times(1)).crearUsuarioConOfertas(eq(usuario),any());
    }
}
