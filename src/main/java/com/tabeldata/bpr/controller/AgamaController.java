/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.bpr.controller;

import com.tabeldata.bpr.entity.master.Agama;
import com.tabeldata.bpr.service.AgamaService;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author St0rm
 */
@Controller
@RequestMapping("/agama")
public class AgamaController {
    @Autowired
    private AgamaService agamaservice;
    
    @GetMapping(value = {"/","/list"})
    public String listAgama(ModelMap agama){
        agama.addAttribute("listAgama", agamaservice.findAll());
        return "pages/agama/list";
    }
    @GetMapping("/form")
    public String formAgama(Agama agama, ModelMap params){
        params.addAttribute("agama", agama);
        return "pages/agama/form";
    }
    @PostMapping("/submit")
   public String submitAgama(@ModelAttribute Agama agama) {
        agama.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        agama.setCreatedBy("admin");
        agamaservice.save(agama);
        return "redirect:/agama/list";
    }
    
}