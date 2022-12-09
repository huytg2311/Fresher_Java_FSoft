package com.spring.study.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "dangKyHoc")
public class DangKyHoc {

    @Id
    @Column(columnDefinition = "varchar(10)", name = "maDK")
    private String maDK;

    private String hoTen;

    private String soDienThoai;

    private int soLuong;

    private LocalDate ngayDangKy;

    private String lichHoc;

    private int tongTien;

    @ManyToOne
    @JoinColumn(name = "maTT")
    private TinhThanh tinhThanh;
}
