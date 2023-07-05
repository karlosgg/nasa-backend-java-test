package com.nasa.prueba.aspirante.aplicacion.dataservice;

import com.nasa.prueba.aspirante.dominio.dao.clientrest.Collection;
import com.nasa.prueba.aspirante.dominio.dto.PruebaDto;
import com.nasa.prueba.aspirante.dominio.entities.PruebaEntity;

import java.util.List;

public interface DataService {
    List<PruebaDto> saveData(List<PruebaEntity> collection);
}
