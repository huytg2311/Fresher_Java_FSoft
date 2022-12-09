package com.spring.mvc.service.impl;

import com.spring.mvc.model.Computer;
import com.spring.mvc.model.Customer;
import com.spring.mvc.repository.ICustomerRepository;
import com.spring.mvc.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;


    @Override
    public List<Customer> getAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Optional<Customer> getByID(String id) {
        return iCustomerRepository.findById(id);
    }

    public Customer getByIDS(String id) {
        return iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer save(Customer entity) {
        return iCustomerRepository.save(entity);
    }

    @Override
    public void delete(String id) {
        iCustomerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> getAllCustomerPageable(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> listAllCustomerByID(String id, Pageable pageable) {
        return iCustomerRepository.findAllByCustomerIdContaining(id, pageable);
    }

    @Override
    public List<Customer> findAllByCustomerIdContaining(String id) {
        return iCustomerRepository.findAllByCustomerIdContaining(id);
    }
}
