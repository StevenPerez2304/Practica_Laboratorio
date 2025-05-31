package edu.unl.cc.model;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Vehicle implements Serializable{
    private String carLicense;
    private double tonnage;
    private float consumptionFuel;
    private LocalDate lastFixDateMaintenance;
    abstract void loadFuel();
    abstract double getCostMaintenance();

    public Vehicle(String carLicense, double tonnage, float consumptionFuel, LocalDate lastFixDateMaintenance) {
        this.carLicense = carLicense;
        this.tonnage = tonnage;
        this.consumptionFuel = consumptionFuel;
        this.lastFixDateMaintenance = lastFixDateMaintenance;
    }

    public String getcarLicense() {
        return carLicense;
    }

    public void setcarLicense(String carLicense) {
        this.carLicense = carLicense;
    }

    public double getTonnage() {
        return tonnage;
    }

    public void setTonnage(double tonnage) {
        this.tonnage = tonnage;
    }

    public float getConsumptionFuel() {
        return consumptionFuel;
    }

    public void setConsumptionFuel(float fuel) {
        this.consumptionFuel = fuel;
    }

    public LocalDate getLastFixDateMaintenance() {
        return lastFixDateMaintenance;
    }

    public void setLastFixDateMaintenance(LocalDate lastFixDateMaintenance) {
        this.lastFixDateMaintenance = lastFixDateMaintenance;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vehicle{");
        sb.append("carLicense=").append(carLicense);
        sb.append(", tonnage=").append(tonnage);
        sb.append(", fuel=").append(consumptionFuel);
        sb.append(", lastFixDateMaintenance=").append(lastFixDateMaintenance);
        sb.append('}');
        return sb.toString();
    }



}
