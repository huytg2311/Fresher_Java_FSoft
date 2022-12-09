package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "computer")
public class Computer {

    @Id
    private String id;

    private int place;

    private EComputer eComputer;

    @OneToMany(mappedBy = "computer")
    private Set<UseComputer> useComputers;

}
