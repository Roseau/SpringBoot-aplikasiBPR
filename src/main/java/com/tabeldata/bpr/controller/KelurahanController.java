/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.bpr.controller;

import com.tabeldata.bpr.entity.master.Kelurahan;
import com.tabeldata.bpr.service.WilayahService;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
@RequestMapping("/kelurahan")
public class KelurahanController {
    @Autowired
    private WilayahService wilayahservice;
    
    @GetMapping(value = {"/","/list"})
    private String getAllKelurahan(ModelMap params){
        params.addAttribute("listKelurahan", wilayahservice.getAllKelurahan());
        return "/pages/kelurahan/list";
    }
    @GetMapping("/form")
    public String form(ModelMap modelMap, Kelurahan kel) {
        modelMap.addAttribute("listKecamatan", wilayahservice.getAllKecamatan());
        modelMap.addAttribute("kelurahan", kel);
        return "/pages/kelurahan/form";
    }
    @PostMapping("/submit")
    public String submitKelurahan(@ModelAttribute Kelurahan kel, ModelMap params, RedirectAttributes redirectAttributes) {
        kel.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        this.wilayahservice.saveKelurahan(kel);
        redirectAttributes.addFlashAttribute("alertSuccess", "Data berhasil di simpan!");
        return "redirect:/kelurahan/list";
    }
    @GetMapping("/hapus/{kodepos}")
    public String deleteKelurahan(@PathVariable("kodepos") String kode, RedirectAttributes redirectAttributes) {
        Kelurahan kel = wilayahservice.getKelurahanByKodepos(kode);
        wilayahservice.deleteKelurahan(kel);
        redirectAttributes.addFlashAttribute("alertSuccess", "Data berhasil dihapus!");
        return "redirect:/kelurahan/list";
    }
    @GetMapping("/form/{kodepos}")
    public String updateKelurahan(@PathVariable("kodepos") String kodeKel, ModelMap params, RedirectAttributes redirectAttrs) {
        Kelurahan kel = wilayahservice.getKelurahanByKodepos(kodeKel);
        if (kel != null) {
            params.addAttribute("kelurahan", kel);
            params.addAttribute("listKecamatan", wilayahservice.getAllKecamatan());
            return "/pages/kelurahan/form";
        } else {
            redirectAttrs.addFlashAttribute("notAvailabel", "Data Tidak ditemukan");
            return "redirect:/kelurahan/list";
        }
    }
}
