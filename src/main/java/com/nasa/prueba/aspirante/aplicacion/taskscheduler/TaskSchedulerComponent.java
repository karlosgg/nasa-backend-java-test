package com.nasa.prueba.aspirante.aplicacion.taskscheduler;

import com.nasa.prueba.aspirante.dominio.entities.PruebaEntity;
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

    @Scheduled(cron = "1 * * * * *")
    public void scheduledProcess(){

        log.info("Task every minute "+ Date.from(Instant.now()));
        var response = nasaClient.search("apollo%2011");
        var body = response.getBody();
        var listToPersist = new ArrayList<>();

        if(body!=null && body.getCollection()!=null && body.getCollection().getItems()!=null){
            body.getCollection().getItems().forEach(i->{
                var ent = new PruebaEntity();
                ent.setHref(i.getHref());
                ent.setTitle(i.getData().get(0).get("title").toString());
                ent.setCenter(i.getData().get(0).get("center").toString());
                ent.setNasaId(i.getData().get(0).get("nasa_id").toString());
                log.debug("{}, {}, {}, {}", ent.getHref(),ent.getTitle(),
                        ent.getCenter(), ent.getNasaId());
                listToPersist.add(ent);
            });
        }

        if(!listToPersist.isEmpty())
            log.debug("Ready to save");
    }
}
