package com.cvworld.controllers;

import com.cvworld.dao.ArticleRepository;
import com.cvworld.dao.BasicProfileInfoRepo;
import com.cvworld.dao.DataServices;
import com.cvworld.dao.UserRepository;
import com.cvworld.model.BasicProfileInfo;
import com.cvworld.model.User;
import com.cvworld.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.Registration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ArticleRepository data;



    @Autowired
    BasicProfileInfoRepo rep;


    @RequestMapping("/")
    public ModelAndView  getHome(){
       ModelAndView mv=new ModelAndView("index");
        if (data != null){
            mv.addObject("aa", data.findAll());

        }
       else {
            System.out.println("NN");
        }


        return mv;

    }


    @GetMapping("/info")
    public String userInfo(HttpSession session) {
        return "user";
    }

}
