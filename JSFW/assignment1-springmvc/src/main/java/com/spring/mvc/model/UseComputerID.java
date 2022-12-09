package com.spring.mvc.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

//@Embeddable

@Data
public class UseComputerID implements Serializable {
    private String customerId;
    private String computerId;
    private LocalDate useDate;
    private LocalTime useTime;
}
