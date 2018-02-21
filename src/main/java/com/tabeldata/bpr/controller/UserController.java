/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.bpr.controller;

import com.tabeldata.bpr.entity.master.UserSecurity;
import com.tabeldata.bpr.service.AgamaService;
import com.tabeldata.bpr.service.UserService;
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
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userservice;
    
    @GetMapping(value = {"/","/list"})
    public String listUsers(ModelMap user){
        user.addAttribute("listUsers", userservice.getAllUser());
        user.addAttribute("listRole", userservice.getAllRoles());
        return "pages/users/list";
    }
    @GetMapping("/form")
    public String formUser(UserSecurity user, ModelMap params){
        params.addAttribute("user", user);
        params.addAttribute("listRole", userservice.getAllRoles());
        return "pages/users/form";
    }
   @PostMapping("/submit")
   public String submitUser(@Valid @ModelAttribute UserSecurity userSecurity, BindingResult bindingresult ,RedirectAttributes redirect, ModelMap params) {
        userSecurity.setCreateDate(Timestamp.valueOf(LocalDateTime.now()));
        userSecurity.setCreatedBy("admin");
        if(bindingresult.hasErrors()){
            params.addAttribute("listRole", userservice.getAllRoles());
            return "/pages/users/form";
        }
        userservice.Save(userSecurity);
        redirect.addFlashAttribute("submitBerhasil", "Data Berhasil Dimasukkan!");
        return "redirect:/users/list";
   }
   @GetMapping("/hapus/{id}")
   public String deleteUser(@PathVariable("id") String KodeUser, RedirectAttributes redirect){
       userservice.Delete(KodeUser);
       redirect.addFlashAttribute("HapusBerhasil","data berhasil dihapus!");
       return "redirect:/users/list";
   }
   @GetMapping("/form/{id}")
    public String updateUser(@PathVariable("id") String id, ModelMap params, RedirectAttributes redirect){
        UserSecurity user = userservice.finduserById(id);
        if(user!=null){
            params.addAttribute("user", user);
            params.addAttribute("listRole", userservice.getAllRoles());
            return "/pages/users/form";
        }else{
            redirect.addFlashAttribute("tidakAda","data tidak ditemukan!");
            return "redirect:/users/list";
        }
    }
}
