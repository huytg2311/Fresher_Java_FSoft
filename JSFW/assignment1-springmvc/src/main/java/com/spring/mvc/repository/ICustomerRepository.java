package com.spring.mvc.repository;

import com.spring.mvc.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, String>{
    Page<Customer> findAllByCustomerIdContaining(String id, Pageable pageable);
    List<Customer> findAllByCustomerIdContaining(String id);
}
