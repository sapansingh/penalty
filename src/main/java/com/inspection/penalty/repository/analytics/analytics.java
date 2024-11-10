package com.inspection.penalty.repository.analytics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import java.time.format.DateTimeFormatter;

import com.inspection.penalty.model.analytics.assignment;

@Repository
public class analytics {
 
    private JdbcTemplate jdbcTemplate ;

    public analytics(@Qualifier("secondaryJdbcTemplate") JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
   
public class eassignment implements RowMapper<assignment>  {

    @Override
    @Nullable
    public assignment mapRow(@SuppressWarnings("null") ResultSet rs, int rowNum) throws SQLException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        assignment assign=new assignment();
        Timestamp agenttime = rs.getTimestamp("agent_connected_time");
        Timestamp Call_timed = rs.getTimestamp("Call_time");
        Timestamp Popup_close_time = rs.getTimestamp("Popup_close_time");
        Timestamp Call_end_time = rs.getTimestamp("Call_end_time");
        Timestamp Assignmentsr = rs.getTimestamp("assigned_time");
        assign.setCall_type_name(rs.getString(1));
        assign.setCallid(rs.getString(2));
        assign.setCall_time(Call_timed.toLocalDateTime().format(formatter));
        assign.setPhone_number(rs.getString(4));
        assign.setAgent_connected_time(agenttime.toLocalDateTime().format(formatter));
        assign.setPopup_close_time(Popup_close_time.toLocalDateTime().format(formatter));
        assign.setCall_end_time(Call_end_time.toLocalDateTime().format(formatter));
        assign.setCaller_name(rs.getString(8));
        assign.setDistrict_name(rs.getString(9));
        assign.setMandal_name(rs.getString(10));
        assign.setCity_name(rs.getString(11));
        assign.setCall_remarks(rs.getString(12));
        assign.setAgent_id(rs.getString(13));
        assign.setAssigned_time(Assignmentsr.toLocalDateTime().format(formatter));
        assign.setVehicle_no(rs.getString(15));
        assign.setContact_number(rs.getString(16));
        assign.setAssigned_by(rs.getString(17));
        // TODO Auto-generated method stub
        return assign;
    }

    
}

    public List<assignment> Assignment(String startdate,String endDate){

String query="SELECT ct.call_type_name, ci.`callid`,ci.`call_time`,ci.`phone_number`,ci.`agent_connected_time`,cid.`popup_close_time`,ci.`call_end_time`,cid.`caller_name`,cid.`district_name`,cid.`mandal_name`,cid.`city_name`, cid.`call_remarks`, ci.agent_id,va.`assigned_time`,TRIM(va.`vehicle_no`) vehicle_no, va.`contact_number`,va.`assigned_by` FROM `call_incident_info` ci JOIN `call_incident_info_details` cid ON cid.callid=ci.callid JOIN m_call_type ct ON ct.call_type_id=cid.call_type_id JOIN `vehicle_assignment`  va ON va.callid=ci.callid WHERE call_time BETWEEN '"+startdate+" 00:00:00' AND '"+endDate+" 23:59:59'";




        return jdbcTemplate.query(query, new eassignment());
    }

}
