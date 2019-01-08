package com.cvworld.controllers;

import com.cvworld.dao.DataServices;
import com.cvworld.dao.UserRepository;
import com.cvworld.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginandRegistrationController {
    @Autowired
    UserRepository repo;

    @Autowired
    DataServices ser;
    @RequestMapping("/login")
    public String getLoginPage(Model model){



        model.addAttribute("user",new User());
        //   model.addAttribute("loged",is_logged);
        return "no-sidebar";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("user", new User());

        return "registration";
    }

    //
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("user")@Valid User userForm, BindingResult bindingResult, Model model) {
        // UserValidator userValidator= new UserValidator();
        //userValidator.validate(userForm,bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        repo.save(userForm);

        //.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/";
    }
    @PostMapping("/dologin")
    public String userLogin(HttpSession session, @ModelAttribute("user") User
            user, Model model) {


        User usr=null;
        if(ser.isHere(user.getEmail())!=null){
            usr=ser.isHere(user.getEmail());
        }
        //usr=ser.isHere(user.getEmail());
        if (usr!=null && usr.getPassword().equals(user.getPassword())) {

            session.setAttribute("user", user);

        } else {
            model.addAttribute("message", "Login failed. Try again.");
            return "no-sidebar";
        }

        return "redirect:/";
    }


    @GetMapping("/logout")
    public String logout(HttpSession session ) {
        session.invalidate();
        return "redirect:/login";
    }

}
