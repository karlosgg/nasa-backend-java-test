package com.nasa.prueba.aspirante.aplicacion.taskscheduler;

import com.nasa.prueba.aspirante.aplicacion.dataservice.DataService;
import com.nasa.prueba.aspirante.dominio.entities.DataEntity;
import com.nasa.prueba.aspirante.infraestructura.clientrest.NasaClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;

@Slf4j
@Component
public class TaskSchedulerComponent{

    @Autowired
    private NasaClient nasaClient;

    @Autowired
    private DataService dataService;

    @Scheduled(cron = "1 * * * * *")
    public void scheduledProcess(){

        log.info("Task every minute "+ Date.from(Instant.now()));
        var response = nasaClient.search("apollo%2011");
        var body = response.getBody();
        var listToPersist = new ArrayList<DataEntity>();

        if(body!=null && body.getCollection()!=null && body.getCollection().getItems()!=null){
            body.getCollection().getItems().forEach(i->{
                var ent = new DataEntity();
                ent.setHref(i.getHref());
                ent.setTitle(i.getData().get(0).get("title").toString());
                ent.setCenter(i.getData().get(0).get("center").toString());
                ent.setNasaId(i.getData().get(0).get("nasa_id").toString());
                ent.setCreatedDate(new java.util.Date());
                log.debug("{}, {}, {}, {}", ent.getHref(),ent.getTitle(),
                        ent.getCenter(), ent.getNasaId());
                listToPersist.add(ent);
            });
        }

        if(!listToPersist.isEmpty())
            dataService.saveData(listToPersist);
    }
}
