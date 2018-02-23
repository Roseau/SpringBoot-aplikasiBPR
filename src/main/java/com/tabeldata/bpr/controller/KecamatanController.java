/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.bpr.controller;

import com.tabeldata.bpr.entity.master.Kecamatan;
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
@RequestMapping("/kecamatan")
public class KecamatanController {
    @Autowired
    WilayahService wilayahservice;
    
    @GetMapping(value = {"/","/list"})
    public String getAllKecamatan(ModelMap kecamatan){
        kecamatan.addAttribute("listKec", wilayahservice.getAllKecamatan());
        return "pages/kecamatan/list";
    }
    @GetMapping(value = "/form")
    public String formKecamatan(ModelMap params, Kecamatan kec){
        params.addAttribute("kecamatan", kec);
        params.addAttribute("listKokab", wilayahservice.findAllKotaKabupaten());
        return "pages/kecamatan/form";
    }
    @PostMapping(value = "/submit")
    public String submitKecamatan(@ModelAttribute Kecamatan kec, RedirectAttributes redirect){
        kec.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        wilayahservice.saveKecamatan(kec);
        redirect.addFlashAttribute("alertInput","Kecamatan Berhasil dimasukkan");
        return "redirect:/kecamatan/list";
    }
    @GetMapping("/hapus/{id}")
    public String deleteKecamatan(@PathVariable("id") long kode, RedirectAttributes redirectAttributes) {
        this.wilayahservice.deleteKecamatan(kode);
        redirectAttributes.addFlashAttribute("alertDelete", "Data berhasil dihapus!");
        return "redirect:/kecamatan/list";
    }
    @GetMapping("/form/{id}")
    public String updateKecamatan(@PathVariable("id") long kode, ModelMap params, RedirectAttributes redirect){
        Kecamatan kec = wilayahservice.getKecamatanById(kode);
        if(kec!=null){
            params.addAttribute("kecamatan", kec);
            return "/pages/kecamatan/form";
        }else{
            redirect.addFlashAttribute("alertDelete","Data tidak ditemukan");
            return "redirect:/kecamatan/list";
        }
    }
}
