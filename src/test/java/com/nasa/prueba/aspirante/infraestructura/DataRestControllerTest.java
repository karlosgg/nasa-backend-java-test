package com.nasa.prueba.aspirante.infraestructura;

import com.nasa.prueba.aspirante.aplicacion.dataservice.DataService;
import com.nasa.prueba.aspirante.dominio.dto.DataDto;
import com.nasa.prueba.aspirante.infraestructura.restcontroller.DataRestController;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class DataRestControllerTest {

    @Mock
    private DataService service;

    @InjectMocks
    @Spy
    private DataRestController controller;

    @Test
    void whenIGetAllData(){
        //given
        var dto = new DataDto(0L, "href", "center", "title", "nasaid", new Date());
        //when
        when(service.getData()).thenReturn(List.of(dto));
        //then
        var result = controller.getAll();
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }
}
