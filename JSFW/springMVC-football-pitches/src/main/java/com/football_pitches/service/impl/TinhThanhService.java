package com.football_pitches.service.impl;

import com.football_pitches.model.TinhThanh;
import com.football_pitches.repository.ITinhThanhRepository;
import com.football_pitches.service.ITinhThanhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/*
 * Account: HuyTG8
 * Birthday: 2001/11/23
 * */
@Service
public class TinhThanhService implements ITinhThanhService {

    @Autowired
    private ITinhThanhRepository iTinhThanhRepository;

    @Override
    public List<TinhThanh> getAll() {
        return iTinhThanhRepository.findAll();
    }

    @Override
    public Optional<TinhThanh> getByID(String id) {
        return iTinhThanhRepository.findById(id);
    }

    public TinhThanh getByIDS(String id) {
        return iTinhThanhRepository.findById(id).orElse(null);
    }

    @Override
    public TinhThanh save(TinhThanh entity) {
        return iTinhThanhRepository.save(entity);
    }

    @Override
    public void delete(String id) {
        iTinhThanhRepository.deleteById(id);
    }

    @Override
    public Boolean existsByMaTT(String maTT) {
        return iTinhThanhRepository.existsByMaTT(maTT);
    }
}
