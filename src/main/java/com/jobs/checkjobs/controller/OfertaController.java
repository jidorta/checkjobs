package com.jobs.checkjobs.controller;

import com.jobs.checkjobs.entity.OfertaEmpleo;
import com.jobs.checkjobs.service.OfertaEmpleoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ofertas")
public class OfertaController {

    private final OfertaEmpleoService ofertaEmpleoService;

    public OfertaController(OfertaEmpleoService ofertaEmpleoService) {
        this.ofertaEmpleoService = ofertaEmpleoService;
    }

    @GetMapping
    public List<OfertaEmpleo>obtenerTodas(){
        return ofertaEmpleoService.obtenerTodas();
    }

    @PostMapping
    public ResponseEntity<OfertaEmpleo>crear(@RequestBody OfertaEmpleo ofertaEmpleo){
        OfertaEmpleo guardada = ofertaEmpleoService.crearOferta(ofertaEmpleo);
        return new ResponseEntity<>(guardada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OfertaEmpleo>actualizar(@PathVariable Long id, @RequestBody OfertaEmpleo ofertaEmpleo){
        OfertaEmpleo actualizada = ofertaEmpleoService.actualizar(id,ofertaEmpleo);
        if (actualizada == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        boolean eliminado = ofertaEmpleoService.eliminarOfertaEmpleo(id);
        if(!eliminado){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

}
