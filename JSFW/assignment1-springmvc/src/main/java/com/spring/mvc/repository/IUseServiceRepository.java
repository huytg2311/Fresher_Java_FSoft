package com.spring.mvc.repository;

import com.spring.mvc.model.UseService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUseServiceRepository extends JpaRepository<UseService, String> {
    void deleteUseServicesByCustomerId(String id);
    void deleteUseServicesByServiceId(String id);
    boolean getUseServicesByServiceId(String id);
    boolean getUseServicesByCustomerId(String id);
}
