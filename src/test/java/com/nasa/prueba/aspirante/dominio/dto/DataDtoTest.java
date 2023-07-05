package com.nasa.prueba.aspirante.dominio.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DataDtoTest {

    private DataDto dto;
    private Date date = new Date();

    @BeforeEach
    void init(){
        dto = new DataDto(0L, "href", "center","title","nasa_id",date);
    }

    @Test
    void whenIConstructWithAllArgs(){
        var ent = this.dto;
        assertEquals(0L, ent.getId());
        assertEquals("href", ent.getHref());
        assertEquals("center", ent.getCenter());
        assertEquals("title", ent.getTitle());
        assertEquals("nasa_id", ent.getNasaId());
        assertEquals(date, ent.getDateAdded());
    }

}
