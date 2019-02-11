package com.cvworld.controllers;

import com.cvworld.dao.DataServices;
import com.cvworld.dao.UserRepository;
import com.cvworld.model.User;
import com.mysql.cj.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginandRegistrationController {
    @Autowired
    UserRepository repo;

    @Autowired
    DataServices ser;
    @RequestMapping("/login")
    public String getLoginPage(Model model,HttpSession session){

       User user= new User();



        model.addAttribute("user",user);
        //   model.addAttribute("loged",is_logged);
        return "no-sidebar";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model){
        User user=new User();
        user.setRole("Guest");
        model.addAttribute("user", user);

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
        userForm.setRole("USER");
        repo.save(userForm);

        //.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/";
    }
    @PostMapping("/dologin")
    public String userLogin(HttpSession session, @ModelAttribute("user") User
            user, Model model) {
        user.setRole("GUEST");


        User usr=null;
        if(ser.isHere(user.getEmail())!=null){
            usr=ser.isHere(user.getEmail());

        //usr=ser.isHere(user.getEmail());if(usr!=null && usr.getPassword().equals(user.getPassword())){
            user.setRole("USER");
            session.setAttribute("user", usr);
        }else if(usr!=null && usr.getPassword().equals(user.getPassword()) && usr.getEmail().equals("admin") && user.getPassword().equals("1")) {

            usr.setRole("ADMIN");

         //   user1.setRole("USER");
            session.setAttribute("user", usr);

        } else {
            model.addAttribute("message", "Login failed. Try again.");
            return "no-sidebar";
        }

        return "redirect:/";
    }


    @GetMapping("/logout")
    public String logout(HttpSession session ) {
     //User user=(User)   session.getAttribute("user");

        session.invalidate();
        return "redirect:/login";
    }
@GetMapping("/admindelete")
    public String deleteUser(Model model){

        model.addAttribute("users",repo.findAll());
        return "admin";
}

    @GetMapping("/delete/")
    public String delete(@RequestParam ( value="email",required = false)Integer id){
            List<User> usrs =new ArrayList<>();
            usrs= (List<User>) repo.findAll();
            for(User usr:usrs){
                if(usr.getId()==id){
                    repo.delete(usr);
                    break;
                }
            }

            return "redirect:/admindelete";


    }
}
