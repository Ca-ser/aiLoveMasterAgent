package com.waiit.ailovemasteragent.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HealthController {



    @GetMapping
    public String HelloCheck(){return "ok"; }

}
