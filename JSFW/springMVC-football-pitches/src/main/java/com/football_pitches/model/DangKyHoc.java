package com.football_pitches.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

/*
* Account: HuyTG8
* Birthday: 2001/11/23
* Model Dang Ky Hoc
* */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dangKyHoc")
public class DangKyHoc {

    @Id
    @Column(columnDefinition = "varchar(10)", name = "maDK")
    private String maDK;

    private String hoTen;

    @Pattern(regexp = "^0[0-9]{9}$", message = "So dien thoai chua dung")
    private String soDienThoai;

    @Min(value = 1, message = "So luong khong hop le")
    private int soLuong;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate ngayDangKy;

    private String lichHoc;

    private int tongTien;

    @ManyToOne
    @JoinColumn(name = "maTT")
    private TinhThanh tinhThanh;
}
