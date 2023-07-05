package com.nasa.prueba.aspirante.dominio.dao.clientrest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Item{
    private String href;
    private List<HashMap<Object, Object>> data;
    private List<Link> links;
}