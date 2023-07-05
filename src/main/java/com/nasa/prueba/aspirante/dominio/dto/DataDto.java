package com.nasa.prueba.aspirante.dominio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Date;

@Getter
@AllArgsConstructor
public class DataDto {
    private Long id;
    private String href;
    private String center;
    private String title;
    private String nasaId;
    private Date dateAdded;
}
