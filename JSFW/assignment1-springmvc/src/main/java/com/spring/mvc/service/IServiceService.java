package com.spring.mvc.service;

import com.spring.mvc.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceService extends IService<Service, String>{
    Page<Service> getAllServicePageable(Pageable pageable);
    Page<Service> listAllServiceByID(String id, Pageable pageable);
}
