package com.cvworld.Services;

import com.cvworld.dao.UserRepository;
import com.cvworld.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class UserDetailServiceImp implements UserDetailService {
    @Autowired
   private  UserRepository users;
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public User LoadUserbyEmail(String email) {
        User user=new User();
        short ENABLED=1;
        List<?> list=entityManager.createQuery("select * from user  where email=?  ").setParameter(1,email)
                .getResultList();

        if(!list.isEmpty()){
          user=(User)list.get(0);

        }
        return  user;

    }
}
