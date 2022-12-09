package com.spring.mvc.controllers;

import com.spring.mvc.model.Customer;
import com.spring.mvc.service.ICustomerService;
import com.spring.mvc.service.impl.CustomerService;
import com.spring.mvc.service.impl.UseComputerService;
import com.spring.mvc.service.impl.UseServiceService;
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
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private UseComputerService useComputerService;

    @Autowired
    private UseServiceService useServiceService;

    @GetMapping("")
    public String getAllCustomer(@PageableDefault(size = 5)Pageable pageable, Model model) {
        Page<Customer> customers = customerService.getAllCustomerPageable(pageable);
        model.addAttribute("customer", customers);
        return "/customer/list";
    }

    @GetMapping("/search")
    private ModelAndView showCustomerByID(@RequestParam(value = "searchValue")Optional<String> searchValue,
                                          @PageableDefault(size = 5) Pageable pageable) {
        Page<Customer> customers;
        if (searchValue.isPresent()) {
            customers = customerService.listAllCustomerByID(searchValue.get(), pageable);
        } else {
            customers = customerService.getAllCustomerPageable(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/customer/list-table");
        modelAndView.addObject("customer", customers);
        return modelAndView;
    }

    @GetMapping("/create")
    public String createCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "/customer/add";
    }

    @PostMapping("/create")
    public String createCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result) {
        if (result.hasErrors()) {
            return "/customer/add";
        }
        customerService.save(customer);
        return "redirect:/customer";
    }

    @GetMapping("/update/{id}")
    public String formUpdateCustomer(@PathVariable("id") Customer customer, Model model) {

        model.addAttribute("customer", customer);
        return "/customer/edit";
    }

    @PostMapping("/update")
    public String saveCustomer( @Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/customer/edit";
        }
        customerService.save(customer);
        return "redirect:/customer";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") String customer_id) {
        customerService.delete(customer_id);
        return "redirect:/customer";
    }

}
