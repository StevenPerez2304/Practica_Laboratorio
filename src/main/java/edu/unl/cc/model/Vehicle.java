/**
 * Link del repositorio: https://github.com/StevenPerez2304/Practica_Laboratorio.git
 * Integrantes:
 * Coello Anderson
 * Flores Emilio
 * Jumbo Steven
 * Perez Steven*/
package edu.unl.cc.model;
import java.io.Serializable;
import java.time.LocalDate;

public abstract class Vehicle implements Serializable{
    private String carLicense; //placa
    private double tonnage;
    private float consumptionFuel; 
    private LocalDate lastFixDateMaintenance;
    abstract void loadFuel();
    public abstract double getCostMaintenance();
    //constructor de vehicle basic
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
        sb.append("Vehiculo");
        sb.append("\nPlaca: ").append(carLicense);
        sb.append("\nTonelaje: ").append(tonnage);
        sb.append("\nCombustible: ").append(consumptionFuel);
        sb.append("\nUltima fecha de mantenimiento: ").append(lastFixDateMaintenance);
        return sb.toString();
    }
}
