package com.inspection.penalty.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class Tokenreposr {
    
    @Autowired
    JdbcTemplate jdbcTemplate;




    public int gettoken(int accessTokenExpiryTime,String jwtokken,String message,int refreshTokenExpiryTime,boolean t_status,String refreshToken){
        String query="UPDATE `scrb` SET accessTokenExpiryTime='"+accessTokenExpiryTime+"',jwtToken='"+jwtokken+"',message='"+message+"',refreshTokenExpiryTime='"+refreshTokenExpiryTime+"',t_status="+t_status+",refreshToken='"+refreshToken+"'  WHERE client_id='EMRI_USER';";


        System.out.println(query);
        return  jdbcTemplate.update(query);

       
    }


}
