package com.football_pitches.service;

import com.football_pitches.model.TinhThanh;
/*
 * Account: HuyTG8
 * Birthday: 2001/11/23
 * */
public interface ITinhThanhService extends IService<TinhThanh, String>{
    Boolean existsByMaTT(String maTT);

}
