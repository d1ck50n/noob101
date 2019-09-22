package com.dicksonkho.controller;

import com.dicksonkho.jpa.entity.DataFeed;
import com.dicksonkho.jpa.repository.DataFeedRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SQLController {

    @Autowired
    DataFeedRepository dataFeedRepository;

    @RequestMapping(value = "/jpa", method = RequestMethod.GET, produces = "application/json")
    public List<DataFeed> sampleJpa() {
        List a = dataFeedRepository.findAll();
        return dataFeedRepository.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public String home() {
        return "Hello spring data jpa";
    }
}
