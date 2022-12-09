package com.football_pitches.controller;

import com.football_pitches.model.DangKyHoc;
import com.football_pitches.model.TinhThanh;
import com.football_pitches.service.impl.DangKyHocService;
import com.football_pitches.service.impl.TinhThanhService;
import com.football_pitches.validation.TinhThanhValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


/*
 * Account: HuyTG8
 * Birthday: 2001/11/23
 * Controller
 * */
@Controller
@RequestMapping("/dangKyHoc")
public class DangKyHocController {

    @Autowired
    private DangKyHocService dangKyHocService;

    @Autowired
    private TinhThanhService tinhThanhService;

    @Autowired
    private TinhThanhValidation tinhThanhValidation;


/*
* ham hien thi danh sach
* */
    @GetMapping("")
    private ModelAndView getAllDangKyHoc() {
        List<DangKyHoc> dangKyHocList = dangKyHocService.getAll();
        List<TinhThanh> tinhThanhList = tinhThanhService.getAll();
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("dangKyHocList", dangKyHocList);
        modelAndView.addObject("tinhThanhList", tinhThanhList);
        return modelAndView;
    }

    /*
     * tim kiem theo maTT
     * */
    @GetMapping("/searchTT")
    private ModelAndView showMaTT(@RequestParam(value = "searchTT") Optional<String> searchTT) {
        List<DangKyHoc> dangKyHocList;
        if (searchTT.isPresent()) {
            dangKyHocList = dangKyHocService.findAllByTinhThanhMaTT(searchTT.get());
        } else {
            dangKyHocList = dangKyHocService.getAll();
        }
        ModelAndView modelAndView = new ModelAndView("/list-table");
        modelAndView.addObject("dangKyHocList", dangKyHocList);
        return modelAndView;
    }

    /*
     * tim kiem theo ten
     * */
    @GetMapping("/search")
    private ModelAndView showMaDangKyID(@RequestParam(value = "searchValue") Optional<String> searchValue) {
        List<DangKyHoc> dangKyHocList;
        if (searchValue.isPresent()) {
            dangKyHocList = dangKyHocService.findAllByHoTenContaining(searchValue.get());
        } else {
            dangKyHocList = dangKyHocService.getAll();
        }
        ModelAndView modelAndView = new ModelAndView("/list-table");
        modelAndView.addObject("dangKyHocList", dangKyHocList);
        return modelAndView;
    }

    /*
     * hien thi form tao
     * */
    @GetMapping("/create")
    private ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("/add");
        modelAndView.addObject("dangKyHoc", new DangKyHoc());
        return modelAndView;
    }

    /*
     * xu li dang ky
     * */
    @PostMapping("/create")
    private String createDangKyHoc(@Valid @ModelAttribute("dangKyHoc") DangKyHoc dangKyHoc, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "/add";
        }

        if (!tinhThanhService.existsByMaTT(dangKyHoc.getTinhThanh().getMaTT())) {
            model.addAttribute("maTTError", "Khong ton tai tinh thanh trong HT");
            return "/add";
        }
        dangKyHoc.setTongTien(1);
        TinhThanh tinhThanh = tinhThanhService.getByIDS(dangKyHoc.getTinhThanh().getMaTT());
        int price = dangKyHoc.getSoLuong() * 4000000;
        if (tinhThanh.getTenTT().equals("Da Nang")) {
            dangKyHoc.setTongTien(price * 90 / 100);
            if (dangKyHoc.getSoLuong() > 2) {
                dangKyHoc.setTongTien(price * 80 / 100);
            }
        } else if (dangKyHoc.getSoLuong() > 2) {
            dangKyHoc.setTongTien(price * 90 / 100);
        } else {
            dangKyHoc.setTongTien(dangKyHoc.getSoLuong() * 4000000);
        }

        dangKyHocService.save(dangKyHoc);
        return "redirect:/dangKyHoc";
    }

    /*
     * hien thi thong tin update
     * */
    @GetMapping("/update/{id}")
    private String formUpdateDangKyHoc(@PathVariable("id") String id, Model model) {
        Optional<DangKyHoc> dangKyHoc = dangKyHocService.getByID(id);
        model.addAttribute("dangKyHoc", dangKyHoc);
        return "/edit";
    }

    /*
     * xu ly updtae
     * */
    @PostMapping("/update")
    private String saveDangKyHoc(@Valid @ModelAttribute DangKyHoc dangKyHoc, BindingResult bindingResult, Model model) {
        DangKyHoc dangKyHoc1 = dangKyHocService.getByIDS(dangKyHoc.getMaDK());

        if (bindingResult.hasErrors()) {
            return "/edit";
        }

        if (dangKyHoc.getSoLuong() < dangKyHoc1.getSoLuong()) {
            model.addAttribute("soLuongError", "Error_[20220512]:So luong thay doi khong hop le");
            return "/edit";
        }
        dangKyHoc.setTongTien(1);
        TinhThanh tinhThanh = tinhThanhService.getByIDS(dangKyHoc.getTinhThanh().getMaTT());
        int price = dangKyHoc.getSoLuong() * 4000000;
        if (tinhThanh.getTenTT().equals("Da Nang")) {
            dangKyHoc.setTongTien(price * 90 / 100);
            if (dangKyHoc.getSoLuong() > 2) {
                dangKyHoc.setTongTien(price * 80 / 100);
            }
        } else if (dangKyHoc.getSoLuong() > 2) {
            dangKyHoc.setTongTien(price * 90 / 100);
        } else {
            dangKyHoc.setTongTien(dangKyHoc.getSoLuong() * 4000000);
        }

        dangKyHocService.save(dangKyHoc);
        model.addAttribute("message", "Update thong tin dang ky hoc thanh cong");
        return "/edit";
    }

}
