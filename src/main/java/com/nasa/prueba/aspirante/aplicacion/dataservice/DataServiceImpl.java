package com.nasa.prueba.aspirante.aplicacion.dataservice;

import com.nasa.prueba.aspirante.dominio.dto.DataDto;
import com.nasa.prueba.aspirante.dominio.entities.DataEntity;
import com.nasa.prueba.aspirante.infraestructura.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataServiceImpl implements DataService{

    @Autowired
    private DataRepository repository;

    @Override
    public List<DataDto> saveData(ArrayList<DataEntity> collection) {
        var saved = repository.saveAll(collection);
        return saved.stream().map(this::castToDto).collect(Collectors.toList());
    }

    private DataDto castToDto(DataEntity x){
        return new DataDto(x.getId(), x.getHref(), x.getCenter(),
                x.getTitle(), x.getNasaId(), x.getCreatedDate());
    }

}
