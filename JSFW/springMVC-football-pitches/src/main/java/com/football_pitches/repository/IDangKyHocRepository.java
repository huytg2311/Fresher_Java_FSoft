package com.football_pitches.repository;

import com.football_pitches.model.DangKyHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
/*
 * Account: HuyTG8
 * Birthday: 2001/11/23
 * */
@Repository
public interface IDangKyHocRepository extends JpaRepository<DangKyHoc, String> {
    List<DangKyHoc> findAllByHoTenContaining(String name);
    List<DangKyHoc> findAllByTinhThanhMaTT(String maTT);
}
