/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.bpr.controller;

import com.tabeldata.bpr.entity.master.Provinsi;
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
@RequestMapping("/provinsi")
public class ProvinsiController {
    @Autowired
    private WilayahService wilayahservice;
    
    @GetMapping(value = {"/","/list"})
    public String getProvinsiList(ModelMap provinsi){
        provinsi.addAttribute("listProvinsi", wilayahservice.findAllProvinsi());
        return "pages/provinsi/list";
    }
    @GetMapping(value = "/form")
    public String form(ModelMap params, Provinsi provinsi){
        params.addAttribute("provinsi", provinsi);
        return "pages/provinsi/form";
    }
    @PostMapping(value = "/submit")
    public String submitProvinsi(@ModelAttribute Provinsi prov, RedirectAttributes redirect){
        prov.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        prov.setCreatedBy("Admin");
        wilayahservice.saveProvinsi(prov);
        redirect.addFlashAttribute("alertSuccess","Provinsi Berhasil dimasukkan");
        return "redirect:/provinsi/list";
    }
    @GetMapping(value = "/hapus/{id}")
    public String deleteProvinsi(@PathVariable("id") String idProv, RedirectAttributes redirect){
        wilayahservice.deleteProvinsi(idProv);
        redirect.addFlashAttribute("alertDelete","Provinsi Berhasil Dihapus");
        return "redirect:/provinsi/list";
    }
    @GetMapping(value = "/form/{id}")
    public String updateProvinsi(@PathVariable("id") String idProv, ModelMap params, RedirectAttributes redirect){
        Provinsi prov = wilayahservice.findProvById(idProv);
        if(prov!=null){
            params.addAttribute("provinsi",prov);
            return "/pages/provinsi/form";
        }else{
            redirect.addFlashAttribute("alertUpdate", "Data Tidak Ditemukan!");
            return "redirect:/provinsi/list";
        }
    }
    
}
