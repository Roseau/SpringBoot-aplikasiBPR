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
    @GetMapping("/form/{id}")
    public String updateAgama(@PathVariable("id") String id, ModelMap params, RedirectAttributes redirect){
        Agama agama = agamaservice.findById(id);
        if(agama!=null){
            params.addAttribute("agama", agama);
            return "/pages/agama/form";
        }else{
            redirect.addFlashAttribute("tidakAda","data tidak ditemukan!");
            return "redirect:/agama/list";
        }
    } 
   @PostMapping("/submit")
   public String submitAgama(@Valid @ModelAttribute Agama agama, BindingResult bindingresult ,RedirectAttributes redirect) {
        agama.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        agama.setCreatedBy("admin");
        if(bindingresult.hasErrors()){
            return "/pages/agama/form";
        }
        agamaservice.save(agama);
        redirect.addFlashAttribute("submitBerhasil", "Data Berhasil Dimasukkan!");
        return "redirect:/agama/list";
    }
   @GetMapping("/hapus/{id}")
   public String deleteAgama(@PathVariable("id") String KodeAgama, RedirectAttributes redirect){
       agamaservice.delete(KodeAgama);
       redirect.addFlashAttribute("HapusBerhasil","data berhasil dihapus!");
       return "redirect:/agama/list";
   }
    
}