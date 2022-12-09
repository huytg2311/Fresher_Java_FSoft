package com.spring.mvc.service;

import com.spring.mvc.model.Computer;
import com.spring.mvc.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ICustomerService extends IService<Customer, String>{
    Page<Customer> getAllCustomerPageable(Pageable pageable);
    Page<Customer> listAllCustomerByID(String id, Pageable pageable);
    List<Customer> findAllByCustomerIdContaining(String id);

}
