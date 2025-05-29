package edu.unl.cc.model;

import java.io.Serializable;

public abstract class Vehicle implements Serializable{
    private String credential;
    private double tonnage;
    private float fuel;
    private String lastFixDateMaintenance;
    
    abstract void loadFuel();

    public Vehicle(String credential, double tonnage, float fuel, String lastFixDateMaintenance) {
        this.credential = credential;
        this.tonnage = tonnage;
        this.fuel = fuel;
        this.lastFixDateMaintenance = lastFixDateMaintenance;
    }   
 
    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
    }

    public double getTonnage() {
        return tonnage;
    }

    public void setTonnage(double tonnage) {
        this.tonnage = tonnage;
    }

    public float getFuel() {
        return fuel;
    }

    public void setFuel(float fuel) {
        this.fuel = fuel;
    }

    public String getLastFixDateMaintenance() {
        return lastFixDateMaintenance;
    }

    public void setLastFixDateMaintenance(String lastFixDateMaintenance) {
        this.lastFixDateMaintenance = lastFixDateMaintenance;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vehicle{");
        sb.append("credential=").append(credential);
        sb.append(", tonnage=").append(tonnage);
        sb.append(", fuel=").append(fuel);
        sb.append(", lastFixDateMaintenance=").append(lastFixDateMaintenance);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
