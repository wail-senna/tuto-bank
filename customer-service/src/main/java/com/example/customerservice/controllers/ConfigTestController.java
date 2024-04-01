package com.example.customerservice.controllers;


import com.example.customerservice.config.GlobalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigTestController {

    @Autowired
    private GlobalConfig globalConfig;

    @GetMapping("/globalConfig")
    public GlobalConfig globalConfig(){
        return globalConfig;
    }
}
