package com.binar.schedules.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ScheduleDto {

    private Long filmId;

    private LocalDate tanggal;

    private LocalTime jamMulai;

    private LocalTime jamSelesai;

    private Long harga;
}
