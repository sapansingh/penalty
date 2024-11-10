package com.inspection.penalty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inspection.penalty.model.usersmodel;
import com.inspection.penalty.model.admin.Permissionmodel;
import com.inspection.penalty.model.admin.Userlistmodel;
import com.inspection.penalty.repository.Userauthrepo;

@Service
public class userauthservice {
    


   @Autowired
   
    private Userauthrepo userrepo;


    public int  registerUser(String firstname,String lastname,String rollid,String isactive,String username, String password,String josn) {
        // Encrypt the password
    
        // Save the user with the encrypted password
        // userRepository.save(new User(username, encryptedPassword));
       return userrepo.Register(firstname,lastname,rollid,isactive,username, password,josn);

    }
    public int  registerUserupdate(String firstname,String lastname,String rollid,String isactive,String username, String password,String josn) {
        // Encrypt the password
    
        // Save the user with the encrypted password
        // userRepository.save(new User(username, encryptedPassword));
       return userrepo.RegisterUpdate(firstname,lastname,rollid,isactive,username, password,josn);
    }

    public List<usersmodel>  Login(usersmodel usermodels) {
        // Verify the password
        return userrepo.Login(usermodels);
    }

    public List<Permissionmodel> getpermisioin(){

        return userrepo.permission();

    }


    public List<Userlistmodel> getuserdata(){

        return userrepo.geruserdata();
    }

    public List<Userlistmodel> getuserdatawithparam(String userid){

        return userrepo.getuserdatawithparam(userid);
    }

    
}
