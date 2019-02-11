package com.cvworld.controllers;

import com.cvworld.dao.*;
import com.cvworld.model.BasicProfileInfo;
import com.cvworld.model.CvResources;
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
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ArticleRepository data;


    @Autowired
    private CvRepo repo;
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
    @GetMapping("/profile")
    public String getPersonal(HttpSession session,Model model){
        if(session.getAttribute("user")!=null) {
            User user = (User) session.getAttribute("user");
            List<CvResources> rp = (List<CvResources>) repo.findAll();
            List<CvResources> useronli = new ArrayList<>();
            for (CvResources r : rp) {
                if (r.getAddress().indexOf(user.getEmail()) != -1) {
                    useronli.add(r);


                }
                model.addAttribute("listpdf", useronli);
            }
        }
        return "profile";
    }
    @GetMapping("/about")
    public String getInfo(){

        return "about";
    }

//    @GetMapping("/cv")
//    public String cv(){
//        return "cv-builder";
//    }

}
