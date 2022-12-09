package com.spring.mvc.service.impl;

import com.spring.mvc.model.Customer;
import com.spring.mvc.model.Service;
import com.spring.mvc.repository.IServiceRepository;
import com.spring.mvc.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceService implements IServiceService {

    @Autowired
    private IServiceRepository iServiceRepository;


    @Override
    public List<Service> getAll() {
        return iServiceRepository.findAll();
    }

    @Override
    public Optional<Service> getByID(String id) {
        return iServiceRepository.findById(id);
    }

    @Override
    public Service save(Service entity) {
        return iServiceRepository.save(entity);
    }

    @Override
    public void delete(String id) {
        iServiceRepository.deleteById(id);
    }

    @Override
    public Page<Service> getAllServicePageable(Pageable pageable) {
        return iServiceRepository.findAll(pageable);
    }

    @Override
    public Page<Service> listAllServiceByID(String id, Pageable pageable) {
        return iServiceRepository.findAllByServiceIdContaining(id, pageable);
    }
}
