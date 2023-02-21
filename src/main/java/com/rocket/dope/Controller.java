package com.rocket.dope;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping("/what")
    public String what() {
        return "Got it";
    }

}
