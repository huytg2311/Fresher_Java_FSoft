package com.spring.mvc.test;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name="CART") // tên này trùng với tên Table trong database .
public class Cart {

    @Id
    private Long id;

    @OneToMany(mappedBy="cart") // chú ý biến cart này được khai báo trong Class Item bên dưới. Chúng phải giống y chang nhau cái tên
    private Set<Items> items;

    public Set<Items> getItems () {
        return items ;
    }
}
