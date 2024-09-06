package com.mbinfotechworld.SCM_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.mbinfotechworld.SCM_2.entitiy.User;
import com.mbinfotechworld.SCM_2.form.UserForm;
import com.mbinfotechworld.SCM_2.helpers.Message;
import com.mbinfotechworld.SCM_2.helpers.MessageType;
import com.mbinfotechworld.SCM_2.serviceImpl.UserServiceImpl;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class PageController {


    UserServiceImpl userServiceImpl;

    public PageController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl  = userServiceImpl;
    }

    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("name", "MB Infotech World");
        model.addAttribute("youtube", "Java Learning");
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
    public String signup(Model model) {
    UserForm userForm = new UserForm();
    model.addAttribute("userForm", userForm);
         return "signup";
    }

    // processing register
    @RequestMapping(value = "/do_register", method = RequestMethod.POST)
    public String requestMethodName(@Valid @ModelAttribute UserForm userForm, BindingResult rBindingResult, HttpSession httpSession) {
        // validate data 
        if (rBindingResult.hasErrors()) {
            return "signup";
        }
        
        User user = new User();
        user.setUserName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setPhoneNo(userForm.getPhoneNumber());
        user.setAbout(userForm.getAbout());
        user.setProfilePic("https://mbinfotechworld.com/wp-content/uploads/2024/04/economy-3213967_1280.jpg");
        userServiceImpl.saveUser(user);
        Message message = Message.builder().content("Registration Successful").type(MessageType.green).build();
        httpSession.setAttribute("message", message);
        System.out.println("user data save successfully....");
        return "redirect:/signup";
    }

}
