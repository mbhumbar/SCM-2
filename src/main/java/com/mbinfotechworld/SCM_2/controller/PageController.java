package com.mbinfotechworld.SCM_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

;

@Controller
public class PageController {


    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("name","MB Infotech World");
        model.addAttribute("youtube","Java Learning");
        System.out.println("Home page Handller");
        return "home";
    }

    @RequestMapping("/about")
    public String about() {
        System.out.println("about page");
        return "about";
    }

    @RequestMapping("/services")
    public String serviecs() {
        System.out.println("services  page");
        return "services";
    }

    @RequestMapping("/contact")
    public String contact() {
        System.out.println("contact page");
        return "contact";
    }

    @RequestMapping("/login")
    public String login() {
        System.out.println("login page");
        return "login";
    }

    @RequestMapping("/signup")
    public String signup() {
        System.out.println("signup page");
        return "signup";
    }




}
