package com.spring.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(columnDefinition = "varchar(20)", name = "customer_id")
    @Pattern(regexp = "^CUS[0-9]{3,4}$", message = "PLease input format CUS(Number)")
    @NotBlank(message = "Input not can be empty")
    private String customerId;

    @NotBlank(message = "Input can not be empty")
    private String name;

    @NotBlank(message = "Input can not be empty!")
    private String address;

//    ^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$
    @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[\\d]{7}$", message = "Invalid phone!")
    @NotBlank(message = "Input can not be empty")
    private String phone;

    @Pattern(regexp = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$",
    message = "Invalid Email!")
    @NotBlank(message = "Input can not be empty!")
    private String email;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SELECT)
    private List<UseService> useServiceList;

    @OneToMany(mappedBy = "useCustomer", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SELECT)
    private List<UseComputer> useComputerList;
}
