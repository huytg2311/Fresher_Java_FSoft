package com.spring.mvc.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

//@Embeddable
@Data
public class UseServiceID  implements Serializable {

    private String customerId;

    private String serviceId;

    private LocalDate useDate;

    private int useTime;

//    private Customer customer;
//    private Service service;


}
