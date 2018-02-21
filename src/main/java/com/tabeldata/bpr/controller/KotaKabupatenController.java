/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.bpr.controller;

import com.tabeldata.bpr.entity.master.KotaKabupaten;
import com.tabeldata.bpr.service.WilayahService;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author St0rm
 */
@Controller
@RequestMapping("/kota")
public class KotaKabupatenController {
    @Autowired
    private WilayahService wilayahservice;
    
    @GetMapping(value = {"/","/list"})
    private String getAllKotaKabupaten(ModelMap params){
        params.addAttribute("listKota", wilayahservice.findAllKotaKabupaten());
        return "/pages/kotakabupaten/list";
    }
    @GetMapping("/form")
    public String form(ModelMap modelMap, KotaKabupaten kota) {
        modelMap.addAttribute("listProvinsi", wilayahservice.findAllProvinsi());
        modelMap.addAttribute("kotaKabupaten", kota);
        return "/pages/kotakabupaten/form";
    }
    @PostMapping("/submit")
    public String submitData(@Valid @ModelAttribute KotaKabupaten kota, BindingResult bindingResult, ModelMap params, RedirectAttributes redirectAttributes) {
        kota.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        kota.setCreatedBy("admin");
        if (bindingResult.hasErrors()) {
            params.addAttribute("listProvinsi", wilayahservice.findAllProvinsi());
            return "pages/kotakabupaten/form";
        }
        this.wilayahservice.saveKota(kota);
        redirectAttributes.addFlashAttribute("alertSuccess", "Data berhasil di simpan!");
        return "redirect:/kota/list";
    }
    @GetMapping("/hapus/{kodeKota}")
    public String deleteData(@PathVariable("kodeKota") String kode, RedirectAttributes redirectAttributes) {
        this.wilayahservice.deleteKotaById(kode);
        redirectAttributes.addFlashAttribute("alertSuccess", "Data berhasil dihapus!");
        return "redirect:/kota/list";
    }
    @GetMapping("/form/{id}")
    public String formKotaByID(@PathVariable("id") String kodeKota, ModelMap params, RedirectAttributes redirectAttrs) {
        KotaKabupaten kotaKabupatenById = wilayahservice.findKotaById(kodeKota);
        if (kotaKabupatenById != null) {
            params.addAttribute("kotaKabupaten", kotaKabupatenById);
            params.addAttribute("listProvinsi", wilayahservice.findAllProvinsi());
            return "/pages/kotakabupaten/form";
        } else {
            redirectAttrs.addFlashAttribute("notAvailabel", "Data Tidak ditemukan");
            return "redirect:/kota/list";
        }
    }
}
