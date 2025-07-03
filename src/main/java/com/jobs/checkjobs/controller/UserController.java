package com.jobs.checkjobs.controller;

import com.jobs.checkjobs.entity.User;
import com.jobs.checkjobs.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User crearUsuarioConOfertas(@RequestBody User user){
        return userService.crearUsuarioConOfertas(user, user.getOfertasPublicadas());
    }

    @GetMapping
    public List<User> listarUsuarios(){
        return userService.obtenerTodos();
    }
}
