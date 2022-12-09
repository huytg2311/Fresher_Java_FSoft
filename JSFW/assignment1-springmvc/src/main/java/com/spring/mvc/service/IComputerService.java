package com.spring.mvc.service;

import com.spring.mvc.model.Computer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IComputerService extends IService<Computer, String>{
    Page<Computer> PaginationComputer(Pageable pageable);
    Page<Computer> listAllComputerByID(String id, Pageable pageable);
    Boolean existsByComputerId(String id);


}

