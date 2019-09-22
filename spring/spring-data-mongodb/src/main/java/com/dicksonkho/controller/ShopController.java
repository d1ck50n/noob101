package com.dicksonkho.controller;

import com.dicksonkho.domain.Shop;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Dickson Kho May 9, 2015
 */
@Controller
@RequestMapping("/shop")
public class ShopController {

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Shop showUserForm(@PathVariable("id") Shop shop) {
        return shop;
    }
}
