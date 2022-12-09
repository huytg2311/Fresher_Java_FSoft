package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    private String id;

    private String name;

    private String address;

    private String phone;

    private String email;

    @OneToMany(mappedBy = "customer")
    private Set<UseService> useServices;

    @OneToMany(mappedBy = "customer")
    private Set<UseComputer> useComputers;
}
