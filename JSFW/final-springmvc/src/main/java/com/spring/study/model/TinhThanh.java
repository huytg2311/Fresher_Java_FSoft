package com.spring.study.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tinhThanh")
public class TinhThanh {

    @Id
    @Column(columnDefinition = "varchar(10)", name = "maTT")
    private String maTT;

    private String tenTT;

    @OneToMany(mappedBy = "tinhThanh")
    private List<DangKyHoc> dangKyHocList;
}
