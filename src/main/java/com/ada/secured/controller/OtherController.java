package com.ada.secured.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OtherController {

    @GetMapping("/other")
    public String other() {
        return "default with no security";
    }
}
