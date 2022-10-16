//package org.binar.challenge4_bejava.models.entities;
//
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.data.annotation.CreatedDate;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.Date;
//
//@Setter
//@Getter
//@Entity
//@Table(name = "Orders")
//public class OrderEntity implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id_order")
//    private Long idOrder;
//
//    @ManyToOne
//    @JoinColumn(name = "id_user")
//    private UserEntity user;
//
//    @ManyToOne
//    @JoinColumn(name = "id_schedule")
//    private ScheduleEntity schedule;
//
//    @ManyToOne
//    @JoinColumn(name = "id_seat")
//    private SeatEntity seat;
//
//
//}


