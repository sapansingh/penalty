package com.inspection.penalty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inspection.penalty.model.assets.Assetsmodel;
import com.inspection.penalty.repository.assetsrepo;

@Service
public class assetsservice {
    
    @Autowired
    private assetsrepo assetsrep;

  int status;
    public int addassetsnew(Assetsmodel formdata){
       status= assetsrep.addassets(formdata);

        return status;

    }

public List<Assetsmodel> getassets(){

 
  return  assetsrep.assetsdata();
}


}
