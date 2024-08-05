package com.inspection.penalty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inspection.penalty.model.usersmodel;
import com.inspection.penalty.repository.Userauthrepo;

@Service
public class userauthservice {
    


   @Autowired
   
    private Userauthrepo userrepo;


    public int  registerUser(String username, String password) {
        // Encrypt the password
    
        // Save the user with the encrypted password
        // userRepository.save(new User(username, encryptedPassword));
       return userrepo.Register(password, password);

    }

    public List<usersmodel>  Login(usersmodel usermodels) {
        // Verify the password
        return userrepo.Login(usermodels);
    }

}
