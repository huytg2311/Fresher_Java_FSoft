package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "usecomputer")
@IdClass(UseComputerID.class)
public class UseComputer {

    @ManyToOne
    @JoinColumn(name = "cus_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "computer_id")
    private Computer computer;

    @Id
    private LocalDate useDate;

    @Id
    private LocalTime useTime;

    private int hour;
}
