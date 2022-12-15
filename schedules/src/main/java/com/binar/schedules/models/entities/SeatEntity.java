package com.binar.schedules.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "Seats")
public class SeatEntity implements Serializable {
    @EmbeddedId
    @Column(name = "id_seat")
    private SeatIdEntity idSeat;

    @ManyToOne
    @JoinColumn(name = "id_studio")
    private StudioEntity studio;
}
