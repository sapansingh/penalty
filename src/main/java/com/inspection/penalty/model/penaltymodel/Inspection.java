package com.inspection.penalty.model.penaltymodel;

import java.util.Date;

public class Inspection {
    

    private int id;

    private String inspectionID;
    private String vehicle_no;
    private String vehicle_type_id;
    private Date inspectionDate;
    private String inspection_param_id;
    private String inspectionParameter;
    private String inspectionNote;
    private String inspectionLocation;
    private String district;
    private String inspectionOutcome;
    private String isCal;
    private String penCounter;
    private String vehicleType;
    private String penAmount;

    



  
  


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInspectionID() {
        return this.inspectionID;
    }

    public void setInspectionID(String inspectionID) {
        this.inspectionID = inspectionID;
    }

    public String getVehicle_no() {
        return this.vehicle_no;
    }

    public void setVehicle_no(String vehicle_no) {
        this.vehicle_no = vehicle_no;
    }

    public String getVehicle_type_id() {
        return this.vehicle_type_id;
    }

    public void setVehicle_type_id(String vehicle_type_id) {
        this.vehicle_type_id = vehicle_type_id;
    }

    public Date getInspectionDate() {
        return this.inspectionDate;
    }

    public void setInspectionDate(Date inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public String getInspection_param_id() {
        return this.inspection_param_id;
    }

    public void setInspection_param_id(String inspection_param_id) {
        this.inspection_param_id = inspection_param_id;
    }

    public String getInspectionParameter() {
        return this.inspectionParameter;
    }

    public void setInspectionParameter(String inspectionParameter) {
        this.inspectionParameter = inspectionParameter;
    }

    public String getInspectionNote() {
        return this.inspectionNote;
    }

    public void setInspectionNote(String inspectionNote) {
        this.inspectionNote = inspectionNote;
    }

    public String getInspectionLocation() {
        return this.inspectionLocation;
    }

    public void setInspectionLocation(String inspectionLocation) {
        this.inspectionLocation = inspectionLocation;
    }

    public String getDistrict() {
        return this.district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getInspectionOutcome() {
        return this.inspectionOutcome;
    }

    public void setInspectionOutcome(String inspectionOutcome) {
        this.inspectionOutcome = inspectionOutcome;
    }

    public String getIsCal() {
        return this.isCal;
    }

    public void setIsCal(String isCal) {
        this.isCal = isCal;
    }

    public String getPenCounter() {
        return this.penCounter;
    }

    public void setPenCounter(String penCounter) {
        this.penCounter = penCounter;
    }

    public String getVehicleType() {
        return this.vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getPenAmount() {
        return this.penAmount;
    }

    public void setPenAmount(String penAmount) {
        this.penAmount = penAmount;
    }



}