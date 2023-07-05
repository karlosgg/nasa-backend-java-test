package com.nasa.prueba.aspirante.dominio.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DataEntityTest {

    private DataEntity entity;
    private Date date = new Date();

    @BeforeEach
    void init(){
        entity = new DataEntity(0L, "href", "center","title","nasa_id",date);
    }

    @Test
    void whenIConstructWithAllArgs(){
        var ent = this.entity;
        assertEquals(0L, ent.getId());
        assertEquals("href", ent.getHref());
        assertEquals("center", ent.getCenter());
        assertEquals("title", ent.getTitle());
        assertEquals("nasa_id", ent.getNasaId());
        assertEquals(date, ent.getCreatedDate());
    }

    @Test
    void whenIConstructWithNoArgs(){
        var ent = new DataEntity();
        ent.setId(0L);
        ent.setHref("href");
        ent.setCenter("center");
        ent.setTitle("title");
        ent.setNasaId("nasa_id");
        ent.setCreatedDate(date);

        assertEquals(0L, ent.getId());
        assertEquals("href", ent.getHref());
        assertEquals("center", ent.getCenter());
        assertEquals("title", ent.getTitle());
        assertEquals("nasa_id", ent.getNasaId());
        assertEquals(date, ent.getCreatedDate());
    }
}
