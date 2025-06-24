package com.jobs.checkjobs.controller;

import com.jobs.checkjobs.dto.IARequest;
import com.jobs.checkjobs.dto.IAResponse;
import com.jobs.checkjobs.service.IAService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ia")
public class IAController {

    private final IAService iaService;

    public IAController(IAService iaService) {
        this.iaService = iaService;
    }

    @PostMapping("/generar-descripcion")
    public ResponseEntity<IAResponse> generarDescripcion(@RequestBody IARequest request){
        String descripcion = iaService.generarDescripcion(request.getTitulo(), request.getRequisitos());
        IAResponse response = new IAResponse();
        response.setDescripcion(descripcion);
        return ResponseEntity.ok(response);
    }
}
