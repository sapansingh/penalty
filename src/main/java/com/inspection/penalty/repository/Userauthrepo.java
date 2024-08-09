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
import com.inspection.penalty.model.admin.Permissionmodel;
import com.inspection.penalty.model.admin.Userlistmodel;

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


public class permisiondata implements RowMapper<Permissionmodel> {

    @Override
    @Nullable
    public Permissionmodel mapRow(ResultSet rs, int rowNum) throws SQLException {
        // TODO Auto-generated method stub

        Permissionmodel permisiont=new Permissionmodel();
        permisiont.setId(rs.getString(1));
        permisiont.setName(rs.getString(2));
        permisiont.setTo(rs.getString(3));
        return permisiont;
    }

    
}


// public class  updateact implements RowMapper<Userlistmodel> {

    
// }



public List<usersmodel> Login(usersmodel usersmodels){
    String username=usersmodels.getUserid();
    String password=usersmodels.getPassword();
   String query="select * from user_master where user_id='"+username+"' and `password`='"+password+"' and is_active='1'";


   // System.out.println(query);
    return jdbcTemplate.query(query, new userdata());
}
public int Register(String firstname,String lastname,String rollid,String isactive,String user_id,String password,String josn){
    String query="Insert into user_master (`name`,last_name,roll_id,is_active,user_id,`password`,application_access) values('"+firstname+"','"+lastname+"','"+rollid+"','"+isactive+"','"+user_id+"','"+password+"','"+josn+"')";
        
    return jdbcTemplate.update(query);
 }

 public List<Permissionmodel> permission(){
    String queryString="SELECT * FROM `navigation` WHERE is_active ='1'";


    return jdbcTemplate.query(queryString, new permisiondata());
 }





}
