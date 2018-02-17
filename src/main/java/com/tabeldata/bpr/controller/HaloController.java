/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.bpr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author St0rm
 */
@Controller
public class HaloController {
    @GetMapping(value = "/index")
    public String heloController(){
        return "/pages/index";
    }
}
