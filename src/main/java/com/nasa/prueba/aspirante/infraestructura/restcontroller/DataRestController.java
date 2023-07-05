package com.nasa.prueba.aspirante.infraestructura.restcontroller;

import com.nasa.prueba.aspirante.aplicacion.dataservice.DataService;
import com.nasa.prueba.aspirante.dominio.dto.DataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DataRestController {

    @Autowired
    private DataService service;

    @GetMapping("")
    public ResponseEntity<List<DataDto>> getAll(){
        return ResponseEntity.ok( service.getData());
    }

}
