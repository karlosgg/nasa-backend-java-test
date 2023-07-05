package com.nasa.prueba.aspirante.aplicacion.dataservice;

import com.nasa.prueba.aspirante.dominio.dto.PruebaDto;
import com.nasa.prueba.aspirante.dominio.entities.PruebaEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataServiceImpl implements DataService{

    @Override
    public List<PruebaDto> saveData(List<PruebaEntity> collection) {
        return null;
    }

}
