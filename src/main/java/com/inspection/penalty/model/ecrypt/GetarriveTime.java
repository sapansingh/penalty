package com.inspection.penalty.model.ecrypt;

import java.time.LocalDateTime;

public class GetarriveTime {

    private String agencyEventId;
    private String dispatchGroup;
    private String unitId;
    private String agencyId;
    private LocalDateTime dispatchTime;
    private LocalDateTime enrouteTime;
    private LocalDateTime arrivalTime;
    private LocalDateTime closedTime;
    private String remark;
    private String key;
    private String client_id;
    private String jwtToken;


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

    public LocalDateTime getDispatchTime() {
        return this.dispatchTime;
    }

    public void setDispatchTime(LocalDateTime dispatchTime) {
        this.dispatchTime = dispatchTime;
    }

    public LocalDateTime getEnrouteTime() {
        return this.enrouteTime;
    }

    public void setEnrouteTime(LocalDateTime enrouteTime) {
        this.enrouteTime = enrouteTime;
    }

    public LocalDateTime getArrivalTime() {
        return this.arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalDateTime getClosedTime() {
        return this.closedTime;
    }

    public void setClosedTime(LocalDateTime closedTime) {
        this.closedTime = closedTime;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }



    public GetarriveTime(String agencyEventId, String dispatchGroup, String unitId, String agencyId, LocalDateTime dispatchTime, LocalDateTime enrouteTime, LocalDateTime arrivalTime, LocalDateTime closedTime, String remark, String key, String client_id, String jwtToken) {
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
