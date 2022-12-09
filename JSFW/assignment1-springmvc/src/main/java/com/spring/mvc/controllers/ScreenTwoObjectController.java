package com.spring.mvc.controllers;

import com.spring.mvc.model.Customer;
import com.spring.mvc.model.UseComputer;
import com.spring.mvc.model.UseService;
import com.spring.mvc.service.impl.CustomerService;
import com.spring.mvc.service.impl.UseComputerService;
import com.spring.mvc.service.impl.UseServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("")
public class ScreenTwoObjectController {
    @Autowired
    private UseComputerService useComputerService;

    @Autowired
    private UseServiceService useServiceService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    private String showAll(Model model) {
        List<Customer> customers = customerService.getAll();
        List<UseComputer> computers = useComputerService.getAll();
        List<UseService> services = useServiceService.getAll();
        model.addAttribute("computers", computers);
        model.addAttribute("services", services);
        model.addAttribute("customers", customers);
        return "/manage/list";
    }

    @GetMapping("/search")
    private ModelAndView searchHomePageByIDCustomer(@RequestParam(value = "searchValue")Optional<String> searchValue) {
        List<Customer> customers ;
        if (searchValue.isPresent()) {
            customers = customerService.findAllByCustomerIdContaining(searchValue.get());
        } else {
            customers = customerService.getAll();
        }
        ModelAndView modelAndView = new ModelAndView("/manage/list-table");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
}
