package com.cvworld.dao;

import com.cvworld.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DataServices {
@Autowired
    UserRepository userrepo;
public User isHere(String username){
    User usr=null;
  List<User> users= (List<User>) userrepo.findAll();
  for(User u: users){
      System.out.println(u.getFirstName());
      if(u.getEmail().equals(username)){
          usr=u;
      }
  }

   if(usr==null){
       return null;
   }
   else {
       return usr;
   }


}
}

