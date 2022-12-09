package com.spring.mvc.service.impl;

import com.spring.mvc.model.UseComputer;
import com.spring.mvc.repository.IUseComputerRepository;
import com.spring.mvc.repository.IUseServiceRepository;
import com.spring.mvc.service.IUseComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UseComputerService implements IUseComputerService {

    @Autowired
    private IUseComputerRepository iUseComputerRepository;


    @Override
    public List<UseComputer> getAll() {
        return iUseComputerRepository.findAll();
    }

    @Override
    public Optional<UseComputer> getByID(String id) {
        return iUseComputerRepository.findById(id);
    }

    @Override
    public UseComputer save(UseComputer entity) {
        return iUseComputerRepository.save(entity);
    }

    @Override
    public void delete(String id) {
        iUseComputerRepository.deleteById(id);
    }

    @Override
    public void deleteUseComputersByCustomerId(String id) {
        iUseComputerRepository.deleteUseComputersByCustomerId(id);
    }

    @Override
    public void deleteUseComputersByComputerId(String id) {
        iUseComputerRepository.deleteUseComputersByComputerId(id);
    }

    @Override
    public boolean getUseComputersByComputerId(String id) {
        return iUseComputerRepository.getUseComputersByComputerId(id);
    }

    @Override
    public boolean getUseComputersByCustomerId(String id) {
        return iUseComputerRepository.getUseComputersByCustomerId(id);
    }
}
