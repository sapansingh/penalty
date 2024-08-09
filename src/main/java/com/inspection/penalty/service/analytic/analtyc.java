package com.inspection.penalty.service.analytic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inspection.penalty.model.analytics.assignment;
import com.inspection.penalty.repository.analytics.analytics;

@Service
public class analtyc {
    @Autowired
    private analytics analytics;



    public List<assignment> getassignment(String startDate,String endDate){

        
        return analytics.Assignment(startDate,endDate);
    }
    
}
