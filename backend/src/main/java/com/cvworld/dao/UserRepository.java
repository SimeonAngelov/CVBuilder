package com.cvworld.dao;

import com.cvworld.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,String> {
   // public User findByEmail(String username);
}
