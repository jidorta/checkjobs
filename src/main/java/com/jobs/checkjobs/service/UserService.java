package com.jobs.checkjobs.service;


import com.jobs.checkjobs.entity.OfertaEmpleo;
import com.jobs.checkjobs.entity.User;
import com.jobs.checkjobs.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

  private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User crearUsuarioConOfertas(User user, List<OfertaEmpleo> ofertas){
        for (OfertaEmpleo oferta : ofertas){
            oferta.setCreador(user);
        }
        user.setOfertasPublicadas(ofertas);
        return userRepository.save(user);
    }

    public List<User>obtenerTodos(){
        return userRepository.findAll();
    }

}
