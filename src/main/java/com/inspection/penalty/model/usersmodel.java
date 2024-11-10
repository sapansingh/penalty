package com.inspection.penalty.model;

public class usersmodel {
    private String name;
    private String last_name;
    private String userid;
    private String password;
    private String application_permission;
    private String is_active;
    private String roll_id;

    public String getRoll_id() {
        return this.roll_id;
    }

    public void setRoll_id(String roll_id) {
        this.roll_id = roll_id;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUserid() {
        return this.userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApplication_permission() {
        return this.application_permission;
    }

    public void setApplication_permission(String application_permission) {
        this.application_permission = application_permission;
    }

    public String getIs_active() {
        return this.is_active;
    }

    public void setIs_active(String is_active) {
        this.is_active = is_active;
    }


}
