package com.spring.mvc.test;

import javax.persistence.*;

@Entity
@Table(name="ITEMS")
public class Items {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name="cart_id", nullable=false) //cart_id chính là trường khoá phụ trong table Item liên kết với khóa chính trong table Cart
    private Cart cart;

    public Items() {}

    // getters and setters
}
