package com.nasa.prueba.aspirante.dominio.dao.clientrest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Collection {
    private String version;
    private String href;
    private ArrayList<Item> items;
    private Metadata metadata;
    private ArrayList<Link> links;
}
