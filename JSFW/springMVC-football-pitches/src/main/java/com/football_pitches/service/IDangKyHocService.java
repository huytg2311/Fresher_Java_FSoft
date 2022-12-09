package com.football_pitches.service;

import com.football_pitches.model.DangKyHoc;

import java.util.List;
/*
 * Account: HuyTG8
 * Birthday: 2001/11/23
 * */
public interface IDangKyHocService extends IService<DangKyHoc, String>{
    List<DangKyHoc> findAllByHoTenContaining(String name);
    List<DangKyHoc> findAllByTinhThanhMaTT(String maTT);

}
