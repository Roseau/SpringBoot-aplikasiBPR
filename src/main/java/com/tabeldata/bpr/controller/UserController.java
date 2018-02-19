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
        return "pages/users/list";
    }
    @GetMapping("/form")
    public String formUser(UserSecurity user, ModelMap params){
        params.addAttribute("user", user);
        return "pages/users/form";
    }
   @PostMapping("/submit")
   public String submitUser(@Valid @ModelAttribute UserSecurity user, BindingResult bindingresult ,RedirectAttributes redirect) {
        user.setCreateDate(Timestamp.valueOf(LocalDateTime.now()));
        user.setCreatedBy("admin");
        userservice.Save(user);
        redirect.addFlashAttribute("submitBerhasil", "Data Berhasil Dimasukkan!");
        return "redirect:/users/list";
   }
   @GetMapping("/hapus/{id}")
   public String deleteAgama(@PathVariable("id") String KodeUser, RedirectAttributes redirect){
       userservice.Delete(KodeUser);
       redirect.addFlashAttribute("HapusBerhasil","data berhasil dihapus!");
       return "redirect:/users/list";
   }
}
