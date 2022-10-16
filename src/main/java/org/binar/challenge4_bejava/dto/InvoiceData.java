package org.binar.challenge4_bejava.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
public class InvoiceData implements Serializable {
    public String username;
    public String noKursi;
    public String namaFilm;
    public String studio;
    private String tanggal;
    private String jamMulai;
    private String jamSelesai;
}
