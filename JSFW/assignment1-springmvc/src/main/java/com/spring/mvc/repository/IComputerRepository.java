package com.spring.mvc.repository;

import com.spring.mvc.model.Computer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IComputerRepository extends JpaRepository<Computer, String>{
//    Computer findComputerByComputerId(String id);
    Page<Computer> findAllByComputerIdContaining(String id, Pageable pageable);
    Boolean existsByComputerId(String id);
}
