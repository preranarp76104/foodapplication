package com.foodapplication.controller;

import java.util.ArrayList;


import com.foodapplication.model.User;

public interface USERdao {
	
    int addUser(User u);
    ArrayList<User> getAllUsers();
    User fetchSpecific(String email);
    int updateUser(User u);
    int deleteUser(String email);
	boolean registerUser(User user);
    
    


}
