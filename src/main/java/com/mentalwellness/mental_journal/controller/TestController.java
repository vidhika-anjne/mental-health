package com.mentalwellness.mental_journal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String home() {
        return "🎉 Mental Wellness Journal API is running!";
    }
}

