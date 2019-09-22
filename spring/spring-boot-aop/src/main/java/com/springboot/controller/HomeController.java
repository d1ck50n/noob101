/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.controller;

import com.springboot.service.HomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author dicksonk
 */
@Controller
public class HomeController {

    private final Logger log = LoggerFactory.getLogger(HomeController.class);
    @Autowired
    HomeService homeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String goHome() {
        System.out.println("Entering Home Controller .....");
        System.out.println(homeService.getHomeInfo());
        return "Welcome to spring aop world !!";
    }

}
