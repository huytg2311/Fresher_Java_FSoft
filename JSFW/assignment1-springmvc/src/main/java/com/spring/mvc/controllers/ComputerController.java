package com.spring.mvc.controllers;

import com.spring.mvc.model.Computer;
import com.spring.mvc.service.IComputerService;
import com.spring.mvc.service.impl.ComputerService;
import com.spring.mvc.service.impl.UseComputerService;
import com.spring.mvc.service.impl.UseServiceService;
import com.spring.mvc.validate.ComputerValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/computer")
public class ComputerController {

    @Autowired
    private ComputerService computerService;

    @Autowired
    private UseComputerService useComputerService;

    @Autowired
    private UseServiceService useServiceService;

    @Autowired
    private ComputerValidate computerValidate;

    @GetMapping("")
    private ModelAndView getAllComputer(@PageableDefault(size = 5) Pageable pageable ) {
        Page<Computer> computerPage = computerService.PaginationComputer(pageable);
        ModelAndView modelAndView = new ModelAndView("/computer/list");
        modelAndView.addObject("computer", computerPage);
//        model.addAttribute("computer", computerPage);
        return modelAndView;
    }

    @GetMapping("/search")
    private ModelAndView showComputerByID(@RequestParam(value = "searchValue") Optional<String> searchValue,@PageableDefault(size = 5) Pageable pageable) {
        Page<Computer> computers;
        if (searchValue.isPresent()) {
            computers = computerService.listAllComputerByID(searchValue.get(), pageable);
        } else {
            computers = computerService.PaginationComputer(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/computer/list-table");
        modelAndView.addObject("computer", computers);
        return modelAndView;
    }

//    @GetMapping("/search")
//    private String showComputerByI(
//            Model model,
//            @PageableDefault(size = 5) Pageable pageable,
//            @RequestParam(value = "searchValue") Optional<String> searchValue) {
//        if (searchValue.isPresent()) {
//            model.addAttribute("computer", computerService.listAllComputerByID(searchValue.get(), pageable));
//        } else {
//            model.addAttribute("computer", computerService.PaginationComputer(pageable));
//        }
//
//        return "computer/list-table";
//    }

    @GetMapping("/create")
    private ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("/computer/add");
        modelAndView.addObject("computer", new Computer());
        return modelAndView;
    }

    @PostMapping("/create")
    public String createComputer(@Valid @ModelAttribute("computer") Computer computer, BindingResult bindingResult) {
        computerValidate.validate(computer, bindingResult);
        if (bindingResult.hasErrors()) {
            System.out.println("1");
            return "/computer/add";
        }
        computerService.save(computer);
        return "redirect:/computer";
    }

//    @GetMapping("/update")
//    public String formUpdateComputer(@RequestParam("computer_id") String computer_id, Model model) {
//        Computer computer = computerService.getComputer(computer_id);
//        model.addAttribute("computer", computer);
//        return "/computer/edit";
//    }

        @GetMapping("/update/{id}")
    public String formUpdateComputer(@PathVariable("id") String id, Model model) {
            Optional<Computer> computer = computerService.getByID(id);
        model.addAttribute("computer", computer);
        return "/computer/edit";
    }

    @PostMapping("/saveComputer")
    public String saveComputer(@Valid @ModelAttribute Computer computer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/computer/edit";
        }
        computerService.save(computer);
        return "redirect:/computer";
    }

    @GetMapping("/delete/{id}")
    public String deleteComputer(@PathVariable("id") String id) {
        computerService.delete(id);
        return "redirect:/computer";
    }

}
