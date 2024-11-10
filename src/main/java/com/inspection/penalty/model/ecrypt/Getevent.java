package com.inspection.penalty.model.ecrypt;

public class Getevent {

    private String eventid;
    private String vehicle_no;
    private String mobile_no;
    private String dispg;
    private String key;
    private String client_id;
    private String jwtToken;


    public String getMobile_no() {
        return this.mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }


    public String getEventid() {
        return this.eventid;
    }

    public void setEventid(String eventid) {
        this.eventid = eventid;
    }

    public String getVehicle_no() {
        return this.vehicle_no;
    }

    public void setVehicle_no(String vehicle_no) {
        this.vehicle_no = vehicle_no;
    }

    public String getDispg() {
        return this.dispg;
    }

    public void setDispg(String dispg) {
        this.dispg = dispg;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getClient_id() {
        return this.client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getJwtToken() {
        return this.jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
   

    @Override
    public String toString() {
        return "{" +
            " eventid='" + getEventid() + "'" +
            ", vehicle_no='" + getVehicle_no() + "'" +
            ", dispg='" + getDispg() + "'" +
            ", key='" + getKey() + "'" +
            ", client_id='" + getClient_id() + "'" +
            ", jwtToken='" + getJwtToken() + "'" +
            "}";
    }

 


}
