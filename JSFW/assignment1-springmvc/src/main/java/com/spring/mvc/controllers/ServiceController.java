package com.spring.mvc.controllers;

import com.spring.mvc.model.Service;
import com.spring.mvc.service.IServiceService;
import com.spring.mvc.service.impl.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @GetMapping("")
    private String getListService(@PageableDefault(size = 5) Pageable pageable, Model model) {
        Page<Service> serviceList = serviceService.getAllServicePageable(pageable);
        model.addAttribute("service", serviceList);
        return "/service/list";
    }
    @GetMapping("/search")
    private ModelAndView showServiceByID(@RequestParam(value = "searchValue")Optional<String> searchValue,
                                         @PageableDefault(size = 5) Pageable pageable) {
        Page<Service> services;
        if (searchValue.isPresent()) {
            services = serviceService.listAllServiceByID(searchValue.get(), pageable);
        } else {
            services = serviceService.getAllServicePageable(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/service/list-table");
        modelAndView.addObject("service", services);
        return modelAndView;
    }

    @GetMapping("/create")
    private String createFormService(Model model) {
        model.addAttribute("service", new Service());
        return "/service/add";
    }

    @PostMapping("/create")
    private String createService(@Valid @ModelAttribute("service") Service service, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/service/add";
        }
        serviceService.save(service);
        return "redirect:/service";
    }

    @GetMapping("/update/{id}")
    private String updateFormService(@PathVariable("id") Service service, Model model) {

        model.addAttribute("service", service);
        return "/service/edit";
    }

    @PostMapping("/update")
    private String updateService(@Valid @ModelAttribute("service") Service service, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/service/edit";
        }
        serviceService.save(service);
        return "redirect:/service";
    }

    @GetMapping("/delete/{id}")
    private String deleteService(@PathVariable("id") String serviceId) {
        serviceService.delete(serviceId);
        return "redirect:/service";
    }
}
