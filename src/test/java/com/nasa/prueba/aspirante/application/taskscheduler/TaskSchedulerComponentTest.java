package com.nasa.prueba.aspirante.application.taskscheduler;

import com.nasa.prueba.aspirante.aplicacion.taskscheduler.TaskSchedulerComponent;
import com.nasa.prueba.aspirante.dominio.dao.clientrest.*;
import com.nasa.prueba.aspirante.infraestructura.clientrest.NasaClient;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest
class TaskSchedulerComponentTest {

    @Mock
    private NasaClient client;

    @InjectMocks
    @Spy
    private TaskSchedulerComponent component;

    @Test
    void whenSchedule(){
        //given
        var arrayList = new ArrayList<Item>();
        var data = new HashMap<Object, Object>();
        data.put("title", "a");
        data.put("center", "b");
        data.put("nasa_id", "c");
        arrayList.add(new Item("href",List.of(data),List.of(new Link())));
        var arrayList2 = new ArrayList<Link>();
        var root = new Root(
                new Collection("version","href", arrayList,
                        new Metadata(), arrayList2
                )
        );
        //when
        when(client.search(anyString())).thenReturn(ResponseEntity.ok(root));
        component.scheduledProcess();
        //then
        verify(component).scheduledProcess();
    }
}
