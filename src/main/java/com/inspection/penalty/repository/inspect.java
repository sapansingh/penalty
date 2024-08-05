package com.inspection.penalty.repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import com.inspection.penalty.model.penaltymodel.Inspection;
import com.inspection.penalty.model.penaltymodel.monthly;
import com.inspection.penalty.model.penaltymodel.panelty;
import com.inspection.penalty.model.penaltymodel.parameter;
import com.inspection.penalty.model.penaltymodel.vehicles;
import com.inspection.penalty.model.penaltymodel.vehiclessingle;
import com.inspection.penalty.model.penaltymodel.year;

@Repository
public class inspect {
    @Autowired
    private JdbcTemplate jdbcTemplate;

 
    public static final class Innerpara implements RowMapper<parameter> {

        @Override
        @Nullable
        public parameter mapRow(@SuppressWarnings("null") ResultSet rs, int arg1) throws SQLException {
            // TODO Auto-generated method stub
        parameter patam=new parameter();
        patam.setId(rs.getInt("id"));
        patam.setInspection_param(rs.getString("inspection_param"));
        return patam;
        }
    }

    public static final class vehiclemapper implements RowMapper<vehicles> {

        @Override
        @Nullable
        public vehicles mapRow(@SuppressWarnings("null") ResultSet rs, int id) throws SQLException {
            // TODO Auto-generated method stub
            vehicles vehicle=new vehicles();
vehicle.setVehicleno(rs.getString("vehicle_no"));
vehicle.setIs_activel(rs.getString("is_active"));
vehicle.setVehicle_type(rs.getString("vehicle_type"));

            return vehicle;
        }   
    }




    public  final class Inspectiondataexpo implements RowMapper<Inspection> {

        @Override
        @Nullable
        public Inspection mapRow(@SuppressWarnings("null") ResultSet rs, int rowNum) throws SQLException {
            // TODO Auto-generated method stub

            Inspection inspectionst= new Inspection();
            inspectionst.setId(rs.getInt(1));
            inspectionst.setInspectionID(rs.getString(2));
            inspectionst.setVehicle_no(rs.getString(3));
            inspectionst.setVehicle_type_id(rs.getString(4));
            inspectionst.setInspectionDate(rs.getDate(5));
            inspectionst.setInspection_param_id(rs.getString(6));
            inspectionst.setInspectionParameter(rs.getString(7));
            inspectionst.setInspectionNote(rs.getString(8));
            inspectionst.setInspectionLocation(rs.getString(9));
            inspectionst.setDistrict(rs.getString(10));
            inspectionst.setInspectionOutcome(rs.getString(11));
            inspectionst.setIsCal(rs.getString(12));
            inspectionst.setPenCounter(rs.getString(13));
            inspectionst.setVehicleType(rs.getString(14));
            inspectionst.setPenAmount(rs.getString(15));

           return inspectionst;
        }
    
        
    }



    public static final class paneltydataraw implements RowMapper<panelty> {

        @Override
        @Nullable
        public panelty mapRow(@SuppressWarnings("null") ResultSet rs, int arg1) throws SQLException {
            // TODO Auto-generated method stub
           panelty penaPanelt=new panelty();

           penaPanelt.setId(rs.getInt("id"));
           penaPanelt.setInspectionId(rs.getInt("inspectionId"));
           penaPanelt.setInspectionDate(rs.getDate("inspectionDate"));
           penaPanelt.setVehicleNo(rs.getString("vehicle_no"));
           penaPanelt.setInspectionParamId(rs.getInt("Inspection_param_id"));
           penaPanelt.setIsCal(rs.getString("is_cal"));
           penaPanelt.setInspectionOutcome(rs.getString("inspectionOutcome"));
           penaPanelt.setPenCounter(rs.getInt("pen_counter"));
            return penaPanelt;
        }    
    }
public static final class vehiclemap implements RowMapper<vehiclessingle> {

    @Override
    @Nullable
    public vehiclessingle mapRow(ResultSet rs, int arg1) throws SQLException {
        // TODO Auto-generated method stub
        
      vehiclessingle vsrt=new vehiclessingle();
vsrt.setId(rs.getInt("id"));
vsrt.setVehicle_no(rs.getString("vehicle_no"));
      return vsrt;
    }

    
}

public static final class monthlymaper implements RowMapper<monthly> {

    @Override
    @Nullable
    public monthly mapRow(ResultSet rs, int rowNum) throws SQLException {
        // TODO Auto-generated method stub
      monthly mont=new monthly();

      mont.setMonth(rs.getString("Month_name"));
      mont.setYear(rs.getString("year_name"));
      mont.setTotal_amount(rs.getString("Amount_total"));

      return mont;
    }

    
}
public static class Yearly implements RowMapper<year> {

    @Override
    @Nullable
    public year mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        year yearr=new year();
        yearr.setTotal_amount(rs.getString("amount"));
        yearr.setYear(rs.getString("Year_name"));
       return yearr;
    }

    
}

public  List<parameter> als(){

    String allpara="SELECT * FROM `inspection_param` WHERE als=1";

    return jdbcTemplate.query(allpara, new Innerpara());
}

public  List<parameter> bls(){

    String allpara="SELECT * FROM `inspection_param` WHERE bls=1";

    return jdbcTemplate.query(allpara, new Innerpara());
}

public  List<parameter> bike(){

    String allpara="SELECT * FROM `inspection_param` WHERE bike=1";

    return jdbcTemplate.query(allpara, new Innerpara());
}

public  List<vehicles>  vehicles(){
    String allpara="SELECT * FROM `vehicles` WHERE is_active=1 AND is_cal IS NULL OR is_cal=''";
    return jdbcTemplate.query(allpara, new vehiclemapper());
}
public  List<panelty>  pendata(String vehicle,int pid){

    String allpara="SELECT * FROM `penalty_cal` WHERE vehicle_no='"+vehicle+"' AND Inspection_param_id='"+pid+"' AND (is_cal IS  NULL OR is_cal='0') ORDER BY InspectionDate ASC";

    return jdbcTemplate.query(allpara, new paneltydataraw());

}
public  List<panelty>  iscalchecker(String vehicle,int pid){

    String allpara="SELECT * FROM `penalty_cal` WHERE vehicle_no='"+vehicle+"' AND Inspection_param_id='"+pid+"'  AND (is_cal IS  NULL OR is_cal='0') ORDER BY InspectionDate DESC LIMIT 1";

    return jdbcTemplate.query(allpara, new paneltydataraw());

}
public int iscal(int pid,int coutner,int penamount){

    String allpara="UPDATE `penalty_cal` SET is_cal='1',pen_counter='"+coutner+"',pen_amount='"+penamount+"' WHERE id='"+pid+"'";

    return jdbcTemplate.update(allpara);

}
public int iscal_pen(int pid){

    String allpara="UPDATE `penalty_cal` SET is_cal='1',pen_counter='0',pen_amount='0' WHERE id='"+pid+"';";

    return jdbcTemplate.update(allpara);

}


public int iscal_vehicle(String vehicle_no){String allpara="UPDATE `vehicles` SET is_cal='1' WHERE vehicle_no='"+vehicle_no+"';";
    return jdbcTemplate.update(allpara);}
public List<vehiclessingle> getblsalspara(){
    String allpara="SELECT pc.id,vs.vehicle_no FROM `penalty_cal` pc  JOIN `vehicles` vs ON vs.vehicle_no=pc.vehicle_no WHERE pc.Inspection_param_id='15' AND vs.vehicle_type='BLS' and ( pc.is_cal IS NULL OR pc.is_cal='' OR pc.is_cal='0') GROUP BY pc.vehicle_no";

    return jdbcTemplate.query(allpara, new vehiclemap());}
public int updateals(int pid,String vehicle){

    String allpara="UPDATE `penalty_cal` SET is_cal='1',pen_counter='0',pen_amount='0' WHERE Inspection_param_id="+pid+" and vehicle_no='"+vehicle+"';";


return jdbcTemplate.update(allpara);
}


public int monthlyupdate(){
String second="TRUNCATE monthly_penalty;";
String thirst="TRUNCATE `yearly_penalty`;";

jdbcTemplate.update(thirst);
jdbcTemplate.update(second);
String sql="INSERT INTO `yearly_penalty`(Year_name,amount) SELECT YEAR(InspectionDate) AS `year`,SUM(pen_amount) AS total_amount  FROM `penalty_cal` WHERE InspectionDate BETWEEN '2023-01-01' AND NOW() GROUP BY YEAR(InspectionDate) ORDER BY InspectionDate ASC;";


    String query="INSERT INTO `monthly_penalty` (Year_name,Month_name,Amount_total) SELECT YEAR(InspectionDate) AS `year`,MONTHNAME(InspectionDate) AS `Month`,SUM(pen_amount) AS total_amount  FROM `penalty_cal` WHERE InspectionDate BETWEEN '2023-01-01' AND NOW() GROUP BY MONTH(InspectionDate),YEAR(InspectionDate) ORDER BY InspectionDate ASC;";
    jdbcTemplate.update(sql);
    return jdbcTemplate.update(query);
}
public List<monthly> getmonthdata(){

List<monthly> listofmonth;
    String query="SELECT Amount_total,Month_name,Year_name FROM `monthly_penalty`";


    listofmonth= jdbcTemplate.query(query, new monthlymaper());


    return listofmonth;

}


public List<year> getyear(){
List<year> getyear;
    String query="SELECT * FROM `yearly_penalty` ORDER BY Year_name ASC;";

    getyear=jdbcTemplate.query(query, new Yearly());

    return getyear;
}


public List<Inspection> inspectinexpo(){
    List<Inspection> inpecti;
        String query="SELECT * FROM `penalty_cal`;";
    
        inpecti=jdbcTemplate.query(query,new Inspectiondataexpo());
        return inpecti;
    }}
