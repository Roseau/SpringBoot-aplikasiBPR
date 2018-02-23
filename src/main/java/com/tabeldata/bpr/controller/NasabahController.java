/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.bpr.controller;

import com.tabeldata.bpr.entity.master.NasabahBadanUsaha;
import com.tabeldata.bpr.entity.master.NasabahPerorangan;
import com.tabeldata.bpr.service.NasabahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author St0rm
 */
@Controller
@RequestMapping("/nasabah")
public class NasabahController {
    @Autowired
    NasabahService nasabahservice;
    
    @GetMapping(value = {"/","/list"})
    public String form(ModelMap params){
        params.addAttribute("listBadanusaha", nasabahservice.findAllBadanUsaha());
        params.addAttribute("listPerorangan", nasabahservice.findAllPerorangan());
        return "/pages/nasabah/list";
    }
    @GetMapping("/badanusaha/form")
    public String formBadanusaha(ModelMap params, NasabahBadanUsaha nb){
        params.addAttribute("nasabahUsaha", nb);
        return "/pages/nasabah/badanusaha/form";
    }
    @PostMapping("/badanusaha/submit")
    public String insertNasabahBU(@ModelAttribute NasabahBadanUsaha nb){
        nasabahservice.save(nb);
        return "redirect:/nasabah/list";
    }
    @GetMapping("/badanusaha/hapus/{id}")
    public String deleteNasabahBU(@PathVariable("id") String kode){
        NasabahBadanUsaha temp = nasabahservice.findBadanUsahaById(kode);
        nasabahservice.delete(temp);
        return "redirect:/nasabah/list";
    }
    @GetMapping("/badanusaha/form/{id}")
    public String updateNasabahBU(@PathVariable("id") String kode, ModelMap params){
        NasabahBadanUsaha temp = nasabahservice.findBadanUsahaById(kode);
        if(temp!=null){
            params.addAttribute("nasabahUsaha", temp);
            return "/pages/nasabah/badanusaha/form";
        }else{
            return "redirect:/nasabah/list";
        }
    }
    @GetMapping("/perorangan/form")
    public String formPerorangan(ModelMap params, NasabahPerorangan np){
        params.addAttribute("nasabahOrang", np);
        return "/pages/nasabah/perorangan/form";
    }
    @PostMapping("/perorangan/submit")
    public String insertNasabahOR(@ModelAttribute NasabahPerorangan np){
        nasabahservice.save(np);
        return "redirect:/nasabah/list";
    }
    @GetMapping("/perorangan/hapus/{id}")
    public String deleteNasabahOR(@PathVariable("id") String kode){
        NasabahPerorangan temp = nasabahservice.findPeroranganById(kode);
        nasabahservice.delete(temp);
        return "redirect:/nasabah/list";
    }
    @GetMapping("/perorangan/form/{id}")
    public String updateNasabahOR(@PathVariable("id") String kode, ModelMap params){
        NasabahPerorangan temp = nasabahservice.findPeroranganById(kode);
        if(temp!=null){
            params.addAttribute("nasabahOrang", temp);
            return "/pages/nasabah/perorangan/form";
        }else{
            return "redirect:/nasabah/list";
        }
    }
}
