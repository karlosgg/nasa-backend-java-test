package com.nasa.prueba.aspirante.application.dataservice;

import com.nasa.prueba.aspirante.aplicacion.dataservice.DataServiceImpl;
import com.nasa.prueba.aspirante.dominio.dto.DataDto;
import com.nasa.prueba.aspirante.dominio.entities.DataEntity;
import com.nasa.prueba.aspirante.infraestructura.repository.DataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyCollection;
import static org.mockito.Mockito.when;

@SpringBootTest
class DataServiceTest {

    @Mock
    private DataRepository repository;
    @InjectMocks
    @Spy
    private DataServiceImpl dataService;

    private DataDto dto;
    private Date date;
    private DataEntity entity;

    @BeforeEach
    void init(){
        date = new Date();
        entity = new DataEntity(0L, "href","center","title","nasaid", date);
        dto = new DataDto(0L, "href","center","title","nasaid", date);
    }

    @Test
    void whenISaveACollection(){
        //given
        var result = 0L;
        var arrayList = new ArrayList<DataEntity>();
        arrayList.add(entity);
        //when
        when(repository.saveAll(anyCollection())).thenReturn(List.of(entity));
        //then
        var saved = dataService.saveData(arrayList);
        assertEquals(result, saved.get(0).getId());
    }

    @Test
    void whenIGetAllData(){
        //when
        when(repository.findAll(Sort.by(Sort.Order.desc("id")))).thenReturn(List.of(entity));
        //then
        var result = dataService.getData();
        assertEquals(1, result.size());
    }
}
