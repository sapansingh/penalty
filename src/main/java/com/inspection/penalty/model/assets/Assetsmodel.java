package com.inspection.penalty.model.assets;

import java.sql.Date;

public class Assetsmodel {
    private String device;
    private String HSN;
    private String assetTag;
    private Date assetsReceived;
    private String billInvoice;
    private String imei1;
    private String imei2;
    private String isActive;
    private String make;
    private String model;
    private String ports;
    private String processor;
    private String ram;
    private String serial;
    private String storage;
    private String vendor;
    private Date warrantyExp;

    public String getdevice() {
        return this.device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getHSN() {
        return this.HSN;
    }

    public void setHSN(String HSN) {
        this.HSN = HSN;
    }

    public String getAssetTag() {
        return this.assetTag;
    }

    public void setAssetTag(String assetTag) {
        this.assetTag = assetTag;
    }

    public Date getAssetsReceived() {
        return this.assetsReceived;
    }

    public void setAssetsReceived(Date assetsReceived) {
        this.assetsReceived = assetsReceived;
    }

    public String getBillInvoice() {
        return this.billInvoice;
    }

    public void setBillInvoice(String billInvoice) {
        this.billInvoice = billInvoice;
    }

    public String getImei1() {
        return this.imei1;
    }

    public void setImei1(String imei1) {
        this.imei1 = imei1;
    }

    public String getImei2() {
        return this.imei2;
    }

    public void setImei2(String imei2) {
        this.imei2 = imei2;
    }

    public String isIsActive() {
        return this.isActive;
    }

    public String getIsActive() {
        return this.isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPorts() {
        return this.ports;
    }

    public void setPorts(String ports) {
        this.ports = ports;
    }

    public String getProcessor() {
        return this.processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getRam() {
        return this.ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getSerial() {
        return this.serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getStorage() {
        return this.storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getVendor() {
        return this.vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Date getWarrantyExp() {
        return this.warrantyExp;
    }

    public void setWarrantyExp(Date warrantyExp) {
        this.warrantyExp = warrantyExp;
    }

    public Assetsmodel() {
    }

    @Override
    public String toString() {
        return "{" +
            " Device='" + getdevice() + "'" +
            ", HSN='" + getHSN() + "'" +
            ", assetTag='" + getAssetTag() + "'" +
            ", assetsReceived='" + getAssetsReceived() + "'" +
            ", billInvoice='" + getBillInvoice() + "'" +
            ", imei1='" + getImei1() + "'" +
            ", imei2='" + getImei2() + "'" +
            ", isActive='" + isIsActive() + "'" +
            ", make='" + getMake() + "'" +
            ", model='" + getModel() + "'" +
            ", ports='" + getPorts() + "'" +
            ", processor='" + getProcessor() + "'" +
            ", ram='" + getRam() + "'" +
            ", serial='" + getSerial() + "'" +
            ", storage='" + getStorage() + "'" +
            ", vendor='" + getVendor() + "'" +
            ", warrantyExp='" + getWarrantyExp() + "'" +
            "}";
    }

 
}
