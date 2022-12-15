package com.binar.schedules.dto;

import com.binar.schedules.models.entities.FilmEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
