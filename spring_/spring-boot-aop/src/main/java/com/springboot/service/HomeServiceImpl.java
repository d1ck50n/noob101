package com.springboot.service;

import com.springboot.annotation.Auditable;
import org.springframework.stereotype.Service;

/**
 *
 * @author dicksonk
 */
@Service
public class HomeServiceImpl implements HomeService {

    @Auditable(value = "Simple Test Value")
    @Override
    public String getHomeInfo() {
        return "Getting Home Info...";
    }
}
