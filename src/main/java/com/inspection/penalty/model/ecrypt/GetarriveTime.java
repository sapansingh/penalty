package com.inspection.penalty.model.ecrypt;


public class GetarriveTime {

    private String agencyEventId;
    private String dispatchGroup;
    private String unitId;
    private String agencyId;

    private String dispatchTime;


    private String enrouteTime;


    private String arrivalTime;


    private String closedTime;

    private String remark;
    private String key;
    private String client_id;
    private String jwtToken;

    public String getAgencyEventId() {
        return this.agencyEventId;
    }

    public void setAgencyEventId(String agencyEventId) {
        this.agencyEventId = agencyEventId;
    }

    public String getDispatchGroup() {
        return this.dispatchGroup;
    }

    public void setDispatchGroup(String dispatchGroup) {
        this.dispatchGroup = dispatchGroup;
    }

    public String getUnitId() {
        return this.unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getAgencyId() {
        return this.agencyId;
    }

    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }

    public String getDispatchTime() {
        return this.dispatchTime;
    }

    public void setDispatchTime(String dispatchTime) {
        this.dispatchTime = dispatchTime;
    }

    public String getEnrouteTime() {
        return this.enrouteTime;
    }

    public void setEnrouteTime(String enrouteTime) {
        this.enrouteTime = enrouteTime;
    }

    public String getArrivalTime() {
        return this.arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getClosedTime() {
        return this.closedTime;
    }

    public void setClosedTime(String closedTime) {
        this.closedTime = closedTime;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public GetarriveTime() {
    }

    public GetarriveTime(String agencyEventId, String dispatchGroup, String unitId, String agencyId, String dispatchTime, String enrouteTime, String arrivalTime, String closedTime, String remark, String key, String client_id, String jwtToken) {
        this.agencyEventId = agencyEventId;
        this.dispatchGroup = dispatchGroup;
        this.unitId = unitId;
        this.agencyId = agencyId;
        this.dispatchTime = dispatchTime;
        this.enrouteTime = enrouteTime;
        this.arrivalTime = arrivalTime;
        this.closedTime = closedTime;
        this.remark = remark;
        this.key = key;
        this.client_id = client_id;
        this.jwtToken = jwtToken;
    }
    

    @Override
    public String toString() {
        return "{" +
            " agencyEventId='" + getAgencyEventId() + "'" +
            ", dispatchGroup='" + getDispatchGroup() + "'" +
            ", unitId='" + getUnitId() + "'" +
            ", agencyId='" + getAgencyId() + "'" +
            ", dispatchTime='" + getDispatchTime() + "'" +
            ", enrouteTime='" + getEnrouteTime() + "'" +
            ", arrivalTime='" + getArrivalTime() + "'" +
            ", closedTime='" + getClosedTime() + "'" +
            ", remark='" + getRemark() + "'" +
            ", key='" + getKey() + "'" +
            ", client_id='" + getClient_id() + "'" +
            ", jwtToken='" + getJwtToken() + "'" +
            "}";
    }
    
}
