package com.spring.mvc.controllers;

import com.spring.mvc.model.Customer;
import com.spring.mvc.model.Service;
import com.spring.mvc.model.UseService;
import com.spring.mvc.service.IUseServiceService;
import com.spring.mvc.service.impl.CustomerService;
import com.spring.mvc.service.impl.ServiceService;
import com.spring.mvc.service.impl.UseServiceService;
import com.spring.mvc.validate.UseServiceValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/useService")
public class UseServiceController {

    @Autowired
    private UseServiceService useServiceService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private UseServiceValidate useServiceValidate;

    @GetMapping("/create")
    private String createFormUserService(Model model) {
        List<Customer> customerList = customerService.getAll();
        List<Service> serviceList = serviceService.getAll();
        model.addAttribute("useService", new UseService());
        model.addAttribute("customerList", customerList);
        model.addAttribute("serviceList", serviceList);
        return "/use-service/add";
    }

    @PostMapping("/create")
    private String createUseService(@Valid @ModelAttribute("useService") UseService useService, BindingResult bindingResult, Model model) {
        useServiceValidate.validate(useService, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/use-service/add";
        }
        useServiceService.save(useService);
        model.addAttribute("message", "Create use service success!");
        return "/use-service/add";
    }

}
