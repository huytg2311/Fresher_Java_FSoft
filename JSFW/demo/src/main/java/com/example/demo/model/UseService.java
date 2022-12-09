package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "useservice")
@IdClass(UseServiceID.class)
public class UseService {

    @ManyToOne
    @JoinColumn(name = "cus_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    @Id
    private LocalDate useDate;

    @Id
    private LocalTime useTime;

    private int quantity;


}
