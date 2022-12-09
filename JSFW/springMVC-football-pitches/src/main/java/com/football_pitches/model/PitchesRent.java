//package com.football_pitches.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.springframework.format.annotation.DateTimeFormat;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "pitches_rent")
//public class PitchesRent {
////    @GeneratedValue (strategy = GenerationType.IDENTITY)
//    @Id
//    @Column(columnDefinition = "varchar(10)", name = "rent_id")
//    private String rentId;
//
//    private String customerName;
//
//    private String phone;
//
//    private int quantity;
//
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
//    private LocalDateTime startRent;
//
//    private int deposit;
//
//    private int totalPrice;
//
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private LocalDate dateDeposit;
//
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private LocalDate dateTotalPrice;
//
//    private int status;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "pitches_id")
//    private PitchesType pitchesType;
//}
