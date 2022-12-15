package com.binar.schedules.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class InvoiceData implements Serializable {
    private String username;
    private String noKursi;
    private String namaFilm;
    private String studio;
    private String tanggal;
    private String jamMulai;
    private String jamSelesai;
}
