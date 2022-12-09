package com.football_pitches.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/*
 * Account: HuyTG8
 * Birthday: 2001/11/23
 * Model Tinh Thanh
 * */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
