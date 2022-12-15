package com.binar.schedules.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Setter
@Getter
@Entity
@Table(name = "Studios")
public class StudioEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_studio")
    private Long idStudio;

    @Column(name = "nama_studio")
    private String namaStudio;




}
