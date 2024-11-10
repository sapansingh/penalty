    package com.inspection.penalty.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inspection.penalty.model.penaltymodel.Inspection;
import com.inspection.penalty.model.penaltymodel.monthly;
import com.inspection.penalty.model.penaltymodel.panelty;
import com.inspection.penalty.model.penaltymodel.parameter;
import com.inspection.penalty.model.penaltymodel.vehicles;
import com.inspection.penalty.model.penaltymodel.vehiclessingle;
import com.inspection.penalty.model.penaltymodel.year;
import com.inspection.penalty.repository.inspect;

@Service
public class paraservice {
  

    @Autowired
    private inspect insteiopnt;

String vehicle_type,vehicle_no;
int parameter_id;
int pencounter;
int vehiclestat,penamount;
    public List<parameter> penaltycal(){

   List<parameter> param=insteiopnt.als();
@SuppressWarnings("unused")
List<String> prt=new ArrayList<>();
@SuppressWarnings("unused")
int idd;
        for(parameter para:param)
        {
            idd=para.getId();   
           
    

        }


        return insteiopnt.als();

    }

public List<vehicles> vehiclelist(){

    return insteiopnt.vehicles();

}
public List<panelty> penaltymeter(){
    List<vehiclessingle> vehicleblsals=new ArrayList<>();

    vehicleblsals=insteiopnt.getblsalspara();
    @SuppressWarnings("unused")
    int id;String vehicleds;
    for(vehiclessingle vehiclsl:vehicleblsals){
     id=vehiclsl.getId();
     vehicleds=vehiclsl.getVehicle_no();
    
       int statust= insteiopnt.updateals(15,vehicleds);
    
        System.out.println(statust);
    
    
    }


List<vehicles> vehiclelist=new ArrayList<>();
List<parameter> paramet=new ArrayList<>();
List<panelty> pant=new ArrayList<>();
List<panelty> iscaler=new ArrayList<>();
 int panterid;
 vehiclelist=insteiopnt.vehicles();

 for(vehicles vehiclet:vehiclelist){
    vehicle_type=vehiclet.getVehicle_type();
    vehicle_no=vehiclet.getVehicleno();
 
    System.out.println(vehiclestat);
        if(vehicle_type.equals("ALS")){
           
        paramet=insteiopnt.als();
        for(parameter param:paramet){

             parameter_id=param.getId();
             pant=insteiopnt.pendata(vehicle_no,parameter_id);
             iscaler= insteiopnt.iscalchecker(vehicle_no,parameter_id);
             if(pant==null || pant.isEmpty()){

                System.out.println("vehicle no"+vehicle_no +" = data not found "+"paramenter id ="+parameter_id);
                break;
             }else{
                if(iscaler.isEmpty()){
                    pencounter=0;
                }else{
                    for(panelty penat:iscaler){
                     pencounter=penat.getPenCounter();

                     System.out.println("this is pencounter data from data base: "+pencounter);
                    }
                }
                for(panelty panrt:pant){
                    if(panrt.getInspectionOutcome().equals("0")){
                        pencounter=pencounter+1;
                          if(pencounter < 2){
                            panterid=  insteiopnt.iscal(panrt.getId(),pencounter,500);
                            System.out.println("vehicle no:="+panrt.getVehicleNo()+",date:-"+panrt.getInspectionDate()+",penalty counter:-"+panterid+"Amount:-"+penamount);
                          }else if(pencounter>=2){
                            int amounte=500;
                            for(int i=2;i<=pencounter;i++){
                                
                              
                                amounte =amounte * 2;

                                penamount= amounte;
                            }
                            panterid=  insteiopnt.iscal(panrt.getId(),pencounter,penamount);
                            System.out.println("vehicle no:="+panrt.getVehicleNo()+",date:-"+panrt.getInspectionDate()+",penalty counter:-"+panterid+"Amount:-"+penamount);

                          }


                    }else if(panrt.getInspectionOutcome().equals("1") || panrt.getInspectionOutcome().equals("2")){
                        pencounter=0;
                        panterid=  insteiopnt.iscal_pen(panrt.getId());
                      
                        System.out.println("this is inspection date"+panrt.getInspectionDate());
                    }
    
    
    
                }
             }
            
             insteiopnt.iscal_vehicle(vehicle_no);
        }

    }else if(vehicle_type.equals("BLS")){

       
        paramet=insteiopnt.bls();
        for(parameter param:paramet){
             parameter_id=param.getId();
             pant=insteiopnt.pendata(vehicle_no,parameter_id);
             iscaler= insteiopnt.iscalchecker(vehicle_no,parameter_id);
             if(pant==null || pant.isEmpty()){

                System.out.println("vehicle no"+vehicle_no +" = data not found"+"paramenter id ="+parameter_id);
                break;
             }else{
                if(iscaler.isEmpty()){
                    pencounter=0;
                }else{
                    for(panelty penat:iscaler){
                     pencounter=penat.getPenCounter();

                     System.out.println("this is pencounter data from data base: "+pencounter);
                    }
                }
                for(panelty panrt:pant){
                    if(panrt.getInspectionOutcome().equals("0")){
                        pencounter=pencounter+1;
                          if(pencounter < 2){
                            panterid=  insteiopnt.iscal(panrt.getId(),pencounter,500);
                            System.out.println("vehicle no:="+panrt.getVehicleNo()+",date:-"+panrt.getInspectionDate()+",penalty counter:-"+panterid+"Amount:-"+penamount);
                          }else if(pencounter>=2){
                            int amounte=500;
                            for(int i=2;i<=pencounter;i++){
                                
                              
                                amounte =amounte * 2;

                                penamount= amounte;
                            }
                            panterid=  insteiopnt.iscal(panrt.getId(),pencounter,penamount);
                            System.out.println("vehicle no:="+panrt.getVehicleNo()+",date:-"+panrt.getInspectionDate()+",penalty counter:-"+panterid+"Amount:-"+penamount);

                          }


                    }else if(panrt.getInspectionOutcome().equals("1") || panrt.getInspectionOutcome().equals("2")){
                        pencounter=0;
                        panterid=  insteiopnt.iscal_pen(panrt.getId());
                     
                        System.out.println(panrt.getInspectionDate());
                    }
    
    
    
                }
             }
            
           
        }

        insteiopnt.iscal_vehicle(vehicle_no);
      //  System.out.println(vehicle_type); 
    }else if(vehicle_type.equals("Bike")){
        
        paramet=insteiopnt.bike();
        for(parameter param:paramet){
             parameter_id=param.getId();
             pant=insteiopnt.pendata(vehicle_no,parameter_id);
             iscaler= insteiopnt.iscalchecker(vehicle_no,parameter_id);
             if(pant==null || pant.isEmpty()){

                System.out.println("vehicle no"+vehicle_no +" = data not found"+"paramenter id ="+parameter_id);
                break;
             }else{
                if(iscaler.isEmpty()){
                    pencounter=0;
                }else{
                    for(panelty penat:iscaler){
                     pencounter=penat.getPenCounter();

                     System.out.println("this is pencounter data from data base: "+pencounter);
                    }
                }
                for(panelty panrt:pant){
                    if(panrt.getInspectionOutcome().equals("0")){
                        pencounter=pencounter+1;
                          if(pencounter < 2){
                            panterid=  insteiopnt.iscal(panrt.getId(),pencounter,500);
                            System.out.println("vehicle no:="+panrt.getVehicleNo()+",date:-"+panrt.getInspectionDate()+",penalty counter:-"+panterid+"Amount:-"+penamount);
                          }else if(pencounter>=2){
                            int amounte=500;
                            for(int i=2;i<=pencounter;i++){
                                
                                amounte =amounte * 2;

                                penamount= amounte;
                            }
                            panterid=  insteiopnt.iscal(panrt.getId(),pencounter,penamount);
                            System.out.println("vehicle no:="+panrt.getVehicleNo()+",date:-"+panrt.getInspectionDate()+",penalty counter:-"+panterid+"Amount:-"+penamount);

                          }


                    }else if(panrt.getInspectionOutcome().equals("1") || panrt.getInspectionOutcome().equals("2")){
                        pencounter=0;
                        panterid=  insteiopnt.iscal_pen(panrt.getId());
                        System.out.println(panrt.getInspectionDate());
                    }
    
    
    
                }
             }
            
           
        }

       // System.out.println(vehicle_type); 
    }
    insteiopnt.iscal_vehicle(vehicle_no);
 }


 return insteiopnt.pendata(vehicle_no,parameter_id);
}

public int monthlyupdate(){
    

    return insteiopnt.monthlyupdate();
}


public List<monthly> getmonthlydata(){


    return insteiopnt.getmonthdata();
}

public List<year> getyear(){
    return insteiopnt.getyear();
}

public List<Inspection> excelexpr(){
    return insteiopnt.inspectinexpo();
} 
}
