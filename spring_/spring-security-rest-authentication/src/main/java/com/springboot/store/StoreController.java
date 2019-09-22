package com.springboot.store;

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
public class StoreController {

    private final Logger log = LoggerFactory.getLogger(StoreController.class);
    
    @Autowired
    StoreService storeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String getStore() {
        Object store = storeService.getStore();
        return store.toString();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public boolean updateStore() {
        return storeService.addStore(null);
    }
}
