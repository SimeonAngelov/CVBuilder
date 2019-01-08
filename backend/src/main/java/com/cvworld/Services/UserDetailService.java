package com.cvworld.Services;

import com.cvworld.model.User;

public interface UserDetailService {
    public User LoadUserbyEmail(String email);
}
