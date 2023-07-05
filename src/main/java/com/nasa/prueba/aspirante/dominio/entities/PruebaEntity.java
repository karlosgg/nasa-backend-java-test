package com.nasa.prueba.aspirante.dominio.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Prueba")
public class PruebaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String href;
    private String center;
    private String title;
    @Column(name = "nasa_id")
    private String nasaId;
    @CreatedDate
    @Column(name = "date_added", nullable = false, updatable = false)
    private Date dateAdded;

}
