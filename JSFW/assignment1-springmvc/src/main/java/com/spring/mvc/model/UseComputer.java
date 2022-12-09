package com.spring.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(UseComputerID.class)
public class UseComputer {


    @Id
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate useDate;

    @Id
    private LocalTime useTime;

    @Id
    @Column(columnDefinition = "varchar(20)", name = "customer_id")
    private String customerId;
    @Id
    @Column(columnDefinition = "varchar(225)", name = "computer_id")
    private String computerId;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private Customer useCustomer;


    @ManyToOne(optional = false)
    @JoinColumn(name = "computer_id", insertable = false, updatable = false)
    private Computer useComputer;

    @Min(value = 1, message = "Hour must over 0!")
    private int hour;



}
