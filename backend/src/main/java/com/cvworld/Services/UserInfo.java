package com.cvworld.Services;

import com.cvworld.model.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component
public class UserInfo {
    public User getCurrentUserInfo(HttpSession session){
        User user = (User)session.getAttribute("user");
        if(user !=null){

        }
        return user;
    }
}
