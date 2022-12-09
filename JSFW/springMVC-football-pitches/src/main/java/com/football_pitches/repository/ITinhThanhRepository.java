package com.football_pitches.repository;

import com.football_pitches.model.TinhThanh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/*
 * Account: HuyTG8
 * Birthday: 2001/11/23
 * */
@Repository
public interface ITinhThanhRepository extends JpaRepository<TinhThanh, String> {
    Boolean existsByMaTT(String maTT);
}
