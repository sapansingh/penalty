package com.inspection.penalty.model.penaltymodel;

public class parameter {
    

    int id;
    private String inspection_param;


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInspection_param() {
        return this.inspection_param;
    }

    public void setInspection_param(String inspection_param) {
        this.inspection_param = inspection_param;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", inspection_param='" + getInspection_param() + "'" +
            "}";
    }


}
