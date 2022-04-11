package com.mailbox.email.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;

@RestController
public class EmailController {

    @GetMapping(value = "/")
    public String helloVaishu()
    {
        return "templates/index.html";
    }

    @Controller
    public class WebController {
        @RequestMapping(value = "/index")
        public String index() {
            return "index";
        }
    }

}
