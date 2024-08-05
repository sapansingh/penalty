package com.inspection.penalty.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import com.inspection.penalty.model.usersmodel;

@Repository
public class Userauthrepo {
    
@Autowired
JdbcTemplate jdbcTemplate;


public class userdata implements RowMapper<usersmodel>{

    @Override
    @Nullable
    public usersmodel mapRow(@SuppressWarnings("null") ResultSet rs, int rowNum) throws SQLException {
        // TODO Auto-generated method stub
        usersmodel userdatas=new usersmodel();
        userdatas.setName(rs.getString(2));
        userdatas.setLast_name(rs.getString(3));
        userdatas.setUserid(rs.getString(4));
        userdatas.setPassword(rs.getString(5));
        userdatas.setRoll_id(rs.getString(6));
        userdatas.setApplication_permission(rs.getString(7));
        userdatas.setIs_active(rs.getString(8));
        return userdatas;
    }
    
}



public List<usersmodel> Login(usersmodel usersmodels){
    String username=usersmodels.getUserid();
    String password=usersmodels.getPassword();
   String query="select * from user_master where user_id='"+username+"' and `password`='"+password+"' and is_active='1'";


   // System.out.println(query);
    return jdbcTemplate.query(query, new userdata());
}
public int Register(String user_id,String password){
    String query="Insert into user_master (user_id,`password`) values('"+user_id+"','"+password+"')";
    
     return jdbcTemplate.update(query);
 }


}
