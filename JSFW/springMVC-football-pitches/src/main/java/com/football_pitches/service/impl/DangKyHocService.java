package com.football_pitches.service.impl;

import com.football_pitches.model.DangKyHoc;
import com.football_pitches.repository.IDangKyHocRepository;
import com.football_pitches.service.IDangKyHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/*
 * Account: HuyTG8
 * Birthday: 2001/11/23
 * */
@Service
public class DangKyHocService implements IDangKyHocService {

    @Autowired
    private IDangKyHocRepository iDangKyHocRepository;

    @Override
    public List<DangKyHoc> getAll() {
        return iDangKyHocRepository.findAll();
    }

    @Override
    public Optional<DangKyHoc> getByID(String id) {
        return iDangKyHocRepository.findById(id);
    }

    public DangKyHoc getByIDS(String id) {
        return iDangKyHocRepository.findById(id).orElse(null);
    }

    @Override
    public DangKyHoc save(DangKyHoc entity) {
        return iDangKyHocRepository.save(entity);
    }

    @Override
    public void delete(String id) {
        iDangKyHocRepository.deleteById(id);
    }

    @Override
    public List<DangKyHoc> findAllByHoTenContaining(String name) {
        return iDangKyHocRepository.findAllByHoTenContaining(name);
    }

    @Override
    public List<DangKyHoc> findAllByTinhThanhMaTT(String maTT) {
        return iDangKyHocRepository.findAllByTinhThanhMaTT(maTT);
    }
}
