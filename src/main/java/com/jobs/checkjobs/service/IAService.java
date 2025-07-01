package com.jobs.checkjobs.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

import java.util.List;
import java.util.Map;
//import java.net.http.HttpHeaders;

@Service
public class IAService {
    public IAService(String s) {
    }

    private final RestTemplate restTemplate = new RestTemplate();

    public String generarDescripcion(String titulo, String requisitos){
        String prompt ="Redacta una descripción profesional de una oferta de trabajo con el título: \"" + titulo +
                "\" y los siguientes requisitos: " + requisitos;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
      //  headers.setBearerAuth(MI_API_KEY);

        Map<String, Object>requestBody = Map.of(
                "model","gpt-3.5-turbo",
                "messages", List.of(
                        Map.of("role","user","content",prompt)
                )
        );

        HttpEntity<Map<String,Object>> requestEntity = new HttpEntity<>(requestBody,headers);

        ResponseEntity<Map> response = restTemplate.postForEntity("OPENAI_URL",requestEntity,Map.class);

        if (response.getStatusCode().is2xxSuccessful()){
          List<Map<String,Object>> choices = (List<Map<String, Object>>) response.getBody().get("choices");
          Map<String, Object> message = (Map<String, Object>) choices.get(0).get("message");
          return(String) message.get("content");
        }
        return "No se pudo generar la descripción";
    }

    public String consultaIA(String prompt){

        // Aquí llamas al cliente OpenAI con la apiKey
        // Por simplicidad devolvemos un dummy:
        return "Respuesta simulada para; "+ prompt;
    }
}
