package com.nasa.prueba.aspirante.infraestructura.clientrest;

import com.nasa.prueba.aspirante.dominio.dao.clientrest.Root;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "${clients.resource.name}", url = "${clients.resource.domain}")
public interface NasaClient {

    @GetMapping(path = "/${clients.resource.endpoint}", produces = "application/json", consumes = "application/json")
    ResponseEntity<Root> search(@RequestParam(name = "q") String q);

}
