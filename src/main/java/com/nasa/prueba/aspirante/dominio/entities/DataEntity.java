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
@Table(name = "prueba" , schema = "public")
public class DataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String href;
    private String center;
    private String title;
    @Column(name = "nasa_id")
    private String nasaId;
    @Column(name = "created_date", updatable = false)
    private Date createdDate;

}
