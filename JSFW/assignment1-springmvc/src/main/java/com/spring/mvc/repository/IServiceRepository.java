package com.spring.mvc.repository;

import com.spring.mvc.model.Customer;
import com.spring.mvc.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IServiceRepository extends JpaRepository<Service, String>{
    Page<Service> findAllByServiceIdContaining(String id, Pageable pageable);

}
