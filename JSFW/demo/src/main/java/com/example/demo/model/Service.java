package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "service")
public class Service {

    @Id
    private String id;

    private String name;

    private String unit;

    private int price;

    @OneToMany(mappedBy = "service")
    private Set<UseService> useServices;
}
