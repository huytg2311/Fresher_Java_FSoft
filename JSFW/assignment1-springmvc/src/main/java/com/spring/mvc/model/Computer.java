package com.spring.mvc.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "computer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Computer {

    @Id
    @Column(columnDefinition = "varchar(225)", name = "computer_id")
    @Pattern(regexp = "^COM[0-9]{3,4}$", message = "PLease input format COM(Number)")
    private String computerId;

    @Min(value = 1, message = "Place must > 0!")
    private int place;

    private String status;


    @OneToMany(mappedBy = "useComputer", cascade = CascadeType.ALL)
    private List<UseComputer> useComputerList;

}
