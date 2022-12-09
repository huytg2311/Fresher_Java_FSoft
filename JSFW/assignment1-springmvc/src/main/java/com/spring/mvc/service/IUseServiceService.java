package com.spring.mvc.service;

import com.spring.mvc.model.UseService;

import java.util.List;

public interface IUseServiceService extends IService<UseService, String> {
    void deleteUseServicesByCustomerId(String id);
    void deleteUseServicesByServiceId(String id);
    boolean getUseServicesByServiceId(String id);
    boolean getUseServicesByCustomerId(String id);
}
