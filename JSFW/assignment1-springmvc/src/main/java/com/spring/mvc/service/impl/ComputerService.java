package com.spring.mvc.service.impl;

import com.spring.mvc.model.Computer;
import com.spring.mvc.repository.IComputerRepository;
import com.spring.mvc.service.IComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComputerService implements IComputerService {

    @Autowired
    private IComputerRepository iComputerRepository;

    @Override
    public List<Computer> getAll() {
        return iComputerRepository.findAll();
    }

    @Override
    public Optional<Computer> getByID(String id) {
        return iComputerRepository.findById(id);
    }

    public Computer getByIDS(String id) {
        return iComputerRepository.findById(id).orElse(null);
    }

    @Override
    public Computer save(Computer entity) {
        return iComputerRepository.save(entity);
    }

    @Override
    public void delete(String id) {
        iComputerRepository.deleteById(id);
    }

    @Override
    public Page<Computer> PaginationComputer(Pageable pageable) {
        return iComputerRepository.findAll(pageable);
    }

    @Override
    public Page<Computer> listAllComputerByID(String id, Pageable pageable) {
        return iComputerRepository.findAllByComputerIdContaining(id, pageable);
    }

    @Override
    public Boolean existsByComputerId(String id) {
        return iComputerRepository.existsByComputerId(id);
    }


}
