package cl.cachoza.web001.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwaggerRedirectController {

    @GetMapping("/swagger-ui")
    public String redirectToSwagger() {
        return "redirect:/swagger-ui.html";
    }
}