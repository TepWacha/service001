package com.myproject.serviceservice1.controller;

import com.myproject.serviceservice1.entity.Output;
import com.myproject.serviceservice1.entity.Records;
import com.myproject.serviceservice1.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    private MyService myService;
    @PostMapping("/service1")
    public Output postRecord(@RequestBody Records records){
        return myService.report(records);
    }
}