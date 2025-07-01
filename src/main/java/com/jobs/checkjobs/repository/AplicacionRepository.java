package com.jobs.checkjobs.repository;

import com.jobs.checkjobs.entity.Aplicacion;
import com.jobs.checkjobs.entity.OfertaEmpleo;
import com.jobs.checkjobs.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AplicacionRepository extends JpaRepository<Aplicacion, Long> {
    Optional<Aplicacion> findByUsuarioAndOferta(User usuario, OfertaEmpleo oferta);
}
