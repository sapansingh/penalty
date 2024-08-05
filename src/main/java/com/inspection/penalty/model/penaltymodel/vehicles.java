package com.inspection.penalty.model.penaltymodel;
import java.util.Objects;

public class vehicles {

    private String vehicleno;
    private String is_activel;
    private String vehicle_type;
    private int is_cal;

    public vehicles(int is_cal) {
        this.is_cal = is_cal;
    }

    public int getIs_cal() {
        return is_cal;
    }

    public void setIs_cal(int is_cal) {
        this.is_cal = is_cal;
    }

    public vehicles() {
    }

    public vehicles(String vehicleno, String is_activel, String vehicle_type) {
        this.vehicleno = vehicleno;
        this.is_activel = is_activel;
        this.vehicle_type = vehicle_type;
    }

    public String getVehicleno() {
        return this.vehicleno;
    }

    public void setVehicleno(String vehicleno) {
        this.vehicleno = vehicleno;
    }

    public String getIs_activel() {
        return this.is_activel;
    }

    public void setIs_activel(String is_activel) {
        this.is_activel = is_activel;
    }

    public String getVehicle_type() {
        return this.vehicle_type;
    }

    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    public vehicles vehicleno(String vehicleno) {
        setVehicleno(vehicleno);
        return this;
    }

    public vehicles is_activel(String is_activel) {
        setIs_activel(is_activel);
        return this;
    }

    public vehicles vehicle_type(String vehicle_type) {
        setVehicle_type(vehicle_type);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof vehicles)) {
            return false;
        }
        vehicles vehicles = (vehicles) o;
        return Objects.equals(vehicleno, vehicles.vehicleno) && Objects.equals(is_activel, vehicles.is_activel) && Objects.equals(vehicle_type, vehicles.vehicle_type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleno, is_activel, vehicle_type);
    }

    @Override
    public String toString() {
        return "{" +
            " vehicleno='" + getVehicleno() + "'" +
            ", is_activel='" + getIs_activel() + "'" +
            ", vehicle_type='" + getVehicle_type() + "'" +
            "}";
    }
}
