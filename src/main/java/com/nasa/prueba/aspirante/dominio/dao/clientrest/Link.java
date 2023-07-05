package com.nasa.prueba.aspirante.dominio.dao.clientrest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Link{
    private String href;
    private String rel;
    private String render;
    public String prompt;
}