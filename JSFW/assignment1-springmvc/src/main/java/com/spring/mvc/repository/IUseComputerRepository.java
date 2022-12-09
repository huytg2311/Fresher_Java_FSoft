package com.spring.mvc.repository;

import com.spring.mvc.model.UseComputer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Repository
public interface IUseComputerRepository extends JpaRepository<UseComputer, String> {
    void deleteUseComputersByCustomerId(String id);
    void deleteUseComputersByComputerId(String id);
    boolean getUseComputersByComputerId(String id);
    boolean getUseComputersByCustomerId(String id);

}
