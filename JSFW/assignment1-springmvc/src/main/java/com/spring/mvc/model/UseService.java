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
@IdClass(UseServiceID.class)
public class UseService {

    @Id
    @Column(name = "customer_id")
    private String customerId;

    @Id
    @Column(name = "service_id")
    private String serviceId;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private Customer customer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "service_id", insertable = false, updatable = false)
    private Service service;

    @Id
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate useDate;

    @Id
    @Min(value = 1, message = "Use time must over 0!")
    private int useTime;

    @Min(value = 1, message = "Quantity must over one!")
    private int quantity;


}
