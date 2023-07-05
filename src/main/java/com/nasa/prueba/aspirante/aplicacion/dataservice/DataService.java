package com.nasa.prueba.aspirante.aplicacion.dataservice;

import com.nasa.prueba.aspirante.dominio.dto.DataDto;
import com.nasa.prueba.aspirante.dominio.entities.DataEntity;

import java.util.ArrayList;
import java.util.List;

public interface DataService {
    List<DataDto> saveData(ArrayList<DataEntity> collection);
}
