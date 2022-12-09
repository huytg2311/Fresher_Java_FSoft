package com.spring.mvc.service.impl;

import com.spring.mvc.model.UseService;
import com.spring.mvc.repository.IUseServiceRepository;
import com.spring.mvc.service.IUseServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UseServiceService implements IUseServiceService {

    @Autowired
    private IUseServiceRepository iUseServiceRepository;


    @Override
    public List<UseService> getAll() {
        return iUseServiceRepository.findAll();
    }

    @Override
    public Optional<UseService> getByID(String id) {
        return iUseServiceRepository.findById(id);
    }

    @Override
    public UseService save(UseService entity) {
        return iUseServiceRepository.save(entity);
    }

    @Override
    public void delete(String id) {
        iUseServiceRepository.deleteById(id);
    }

    @Override
    public void deleteUseServicesByCustomerId(String id) {
        iUseServiceRepository.deleteUseServicesByCustomerId(id);
    }

    @Override
    public void deleteUseServicesByServiceId(String id) {
        iUseServiceRepository.deleteUseServicesByServiceId(id);
    }

    @Override
    public boolean getUseServicesByServiceId(String id) {
        return iUseServiceRepository.getUseServicesByServiceId(id);
    }

    @Override
    public boolean getUseServicesByCustomerId(String id) {
        return iUseServiceRepository.getUseServicesByCustomerId(id);
    }
}
