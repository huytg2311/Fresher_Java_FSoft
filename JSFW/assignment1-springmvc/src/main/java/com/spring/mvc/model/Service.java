package com.spring.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "service")
public class Service {

    @Id
    @Column(columnDefinition = "varchar(20)", name = "service_id")
    @Pattern(regexp = "^SE[0-9]{3,4}$", message = "PLease input format SE(Number)!")
    @NotBlank(message = "Input not be empty!")
    private String serviceId;

    @NotBlank(message = "Input not be empty!")
    private String name;

    @NotBlank(message = "Input not be empty!")
    private String unit;

    @Min(value = 1, message = "Price must > 0")
    private int price;

    @OneToMany(mappedBy = "service",cascade = CascadeType.ALL)
    private List<UseService> useServiceList;
}
