package org.binar.challenge4_bejava.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;


@Setter
@Getter
@Entity
@Table(name = "Schedules")
public class ScheduleEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_schedule")
    private Long idSchedule;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_film")
    private FilmEntity film;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate tanggal;

    @JsonFormat(pattern = "HH:mm")
    @Column(name = "jam_mulai")
    private LocalTime jamMulai;

    @JsonFormat(pattern = "HH:mm")
    @Column(name = "jam_selesai")
    private LocalTime jamSelesai;

    private Long harga;
}
