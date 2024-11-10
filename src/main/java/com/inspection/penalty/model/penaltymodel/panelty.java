package com.inspection.penalty.model.penaltymodel;

import java.sql.Date;
import java.util.Objects;

public class panelty {

    private int id;
    private int inspectionId;
    private String vehicleNo;
    private int vehicleTypeId;
    private Date inspectionDate;
    private int inspectionParamId;
    private String inspectionParameter;
    private String inspectionNote;
    private String inspectionLocation;
    private String district;
    private String inspectionOutcome;
    private String isCal;
    private int penCounter;
    private int pen_amount;
    public int getPen_amount() {
        return pen_amount;
    }

    public void setPen_amount(int pen_amount) {
        this.pen_amount = pen_amount;
    }

    public panelty() {
    }

    public panelty(int id, int inspectionId, String vehicleNo, int vehicleTypeId, Date inspectionDate, int inspectionParamId, String inspectionParameter, String inspectionNote, String inspectionLocation, String district, String inspectionOutcome, String isCal, int penCounter) {
        this.id = id;
        this.inspectionId = inspectionId;
        this.vehicleNo = vehicleNo;
        this.vehicleTypeId = vehicleTypeId;
        this.inspectionDate = inspectionDate;
        this.inspectionParamId = inspectionParamId;
        this.inspectionParameter = inspectionParameter;
        this.inspectionNote = inspectionNote;
        this.inspectionLocation = inspectionLocation;
        this.district = district;
        this.inspectionOutcome = inspectionOutcome;
        this.isCal = isCal;
        this.penCounter = penCounter;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int l) {
        this.id = l;
    }

    public int getInspectionId() {
        return this.inspectionId;
    }

    public void setInspectionId(int inspectionId) {
        this.inspectionId = inspectionId;
    }

    public String getVehicleNo() {
        return this.vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public int getVehicleTypeId() {
        return this.vehicleTypeId;
    }

    public void setVehicleTypeId(int vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    public Date getInspectionDate() {
        return this.inspectionDate;
    }

    public void setInspectionDate(Date date) {
        this.inspectionDate = date;
    }

    public int getInspectionParamId() {
        return this.inspectionParamId;
    }

    public void setInspectionParamId(int inspectionParamId) {
        this.inspectionParamId = inspectionParamId;
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

    public String isIsCal() {
        return this.isCal;
    }

    public String getIsCal() {
        return this.isCal;
    }

    public void setIsCal(String isCal) {
        this.isCal = isCal;
    }

    public int getPenCounter() {
        return this.penCounter;
    }

    public void setPenCounter(int penCounter) {
        this.penCounter = penCounter;
    }

    public panelty id(int id) {
        setId(id);
        return this;
    }

    public panelty inspectionId(int inspectionId) {
        setInspectionId(inspectionId);
        return this;
    }

    public panelty vehicleNo(String vehicleNo) {
        setVehicleNo(vehicleNo);
        return this;
    }

    public panelty vehicleTypeId(int vehicleTypeId) {
        setVehicleTypeId(vehicleTypeId);
        return this;
    }

    public panelty inspectionDate(Date inspectionDate) {
        setInspectionDate(inspectionDate);
        return this;
    }

    public panelty inspectionParamId(int inspectionParamId) {
        setInspectionParamId(inspectionParamId);
        return this;
    }

    public panelty inspectionParameter(String inspectionParameter) {
        setInspectionParameter(inspectionParameter);
        return this;
    }

    public panelty inspectionNote(String inspectionNote) {
        setInspectionNote(inspectionNote);
        return this;
    }

    public panelty inspectionLocation(String inspectionLocation) {
        setInspectionLocation(inspectionLocation);
        return this;
    }

    public panelty district(String district) {
        setDistrict(district);
        return this;
    }

    public panelty inspectionOutcome(String inspectionOutcome) {
        setInspectionOutcome(inspectionOutcome);
        return this;
    }

    public panelty isCal(String isCal) {
        setIsCal(isCal);
        return this;
    }

    public panelty penCounter(int penCounter) {
        setPenCounter(penCounter);
        return this;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, inspectionId, vehicleNo, vehicleTypeId, inspectionDate, inspectionParamId, inspectionParameter, inspectionNote, inspectionLocation, district, inspectionOutcome, isCal, penCounter);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", inspectionId='" + getInspectionId() + "'" +
            ", vehicleNo='" + getVehicleNo() + "'" +
            ", vehicleTypeId='" + getVehicleTypeId() + "'" +
            ", inspectionDate='" + getInspectionDate() + "'" +
            ", inspectionParamId='" + getInspectionParamId() + "'" +
            ", inspectionParameter='" + getInspectionParameter() + "'" +
            ", inspectionNote='" + getInspectionNote() + "'" +
            ", inspectionLocation='" + getInspectionLocation() + "'" +
            ", district='" + getDistrict() + "'" +
            ", inspectionOutcome='" + getInspectionOutcome() + "'" +
            ", isCal='" + isIsCal() + "'" +
            ", penCounter='" + getPenCounter() + "'" +
            "}";
    }




}
