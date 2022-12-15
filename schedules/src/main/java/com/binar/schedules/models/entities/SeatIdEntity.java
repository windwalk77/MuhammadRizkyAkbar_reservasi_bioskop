package com.binar.schedules.models.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeatIdEntity implements Serializable {
    @Column(name = "seat_number")
    private Character seatNumber;

    @Column(name = "seat_Row")
    private Integer seatRow;
}
