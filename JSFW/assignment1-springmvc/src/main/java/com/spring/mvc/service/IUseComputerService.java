package com.spring.mvc.service;

import com.spring.mvc.model.UseComputer;

import java.time.LocalDate;
import java.util.List;

public interface IUseComputerService extends IService<UseComputer, String>{
    void deleteUseComputersByCustomerId(String id);
    void deleteUseComputersByComputerId(String id);
    boolean getUseComputersByComputerId(String id);
    boolean getUseComputersByCustomerId(String id);
}
