package com.spring.mvc.controllers;

import com.spring.mvc.model.Computer;
import com.spring.mvc.model.Customer;
import com.spring.mvc.model.UseComputer;
import com.spring.mvc.service.IUseComputerService;
import com.spring.mvc.service.impl.ComputerService;
import com.spring.mvc.service.impl.CustomerService;
import com.spring.mvc.service.impl.UseComputerService;
import com.spring.mvc.validate.CustomerValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/useComputer")
public class UseComputerController {

    @Autowired
    private UseComputerService useComputerService;

    @Autowired
    private ComputerService computerService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerValidate customerValidate;

    @GetMapping("/create")
    public String createFormUseComputer(Model model) {
        List<Computer> computerList = computerService.getAll();
        List<Customer> customerList = customerService.getAll();
        model.addAttribute("computerList", computerList);
        model.addAttribute("customerList", customerList);
        model.addAttribute("useComputer", new UseComputer());
        return "/use-computer/add";
    }

    @PostMapping("/create")
    public String createComputer(@Valid @ModelAttribute("useComputer") UseComputer useComputer, BindingResult bindingResult, Model model) {
        customerValidate.validate(useComputer, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/use-computer/add";
        }
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
//        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalTime lt =LocalTime.parse(formatter.format(useComputer.getUseTime()));
//        LocalDate ld = LocalDate.parse(formatter2.format(useComputer.getUseDate()));
//        useComputer.setUseTime(lt);
//        useComputer.setUseDate(ld);
//        useComputer.getUseTime().format(test);

//        LocalDate localDate = LocalDate.now();
//        LocalTime localTime = LocalTime.now();
//        useComputer.setUseDate(localDate);
//        useComputer.setUseTime(localTime);
        Computer computer = computerService.getByIDS(useComputer.getComputerId());
        Customer customer = customerService.getByIDS(useComputer.getComputerId());
        useComputer.setComputerId(useComputer.getComputerId());
        useComputer.setCustomerId(useComputer.getCustomerId());
//        useComputer.setCustomer_id(useComputer.getCustomer().getCustomerId());
//        useComputer.setComputer_id(useComputer.getComputer().getComputerId());

        useComputerService.save(useComputer);
        model.addAttribute("message", "Create use computer success!");
        return "/use-computer/add";
    }
}
