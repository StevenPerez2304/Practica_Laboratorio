/**
 * Link del repositorio: https://github.com/StevenPerez2304/Practica_Laboratorio.git
 * Integrantes:
 * Coello Anderson
 * Flores Emilio
 * Jumbo Steven
 * Perez Steven*/
package edu.unl.cc.model;

import java.time.LocalDate;

public class Truck extends Vehicle {
    private int numberAxes; // número de ejes
    private static final double COST_MAINTENANCE = 400.0;

    public Truck(String carLicense, double tonnage, float consumptionFuel, int numberAxes, LocalDate lastFixDateMaintenance) {
        super(carLicense, tonnage, consumptionFuel, lastFixDateMaintenance);
        this.numberAxes = numberAxes;
    }

    public int getNumberAxes() {
        return numberAxes;
    }

    public void setNumberAxes(int numberAxes) {
        this.numberAxes = numberAxes;
    }

    @Override
    public void loadFuel() {
        System.out.println("Cargando combustible: " + getConsumptionFuel() + " L/km");
    }

    @Override
    public double getCostMaintenance() {
        return COST_MAINTENANCE;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-Camión- \n");
        sb.append("Nro de ejes: ").append(numberAxes);
        sb.append("\nPlaca: ").append(getcarLicense());
        sb.append("\nTonelaje").append(getTonnage());
        sb.append("\nCombustible: ").append(getConsumptionFuel());
        sb.append("\nUltima fecha de mantenimiento: ").append(getLastFixDateMaintenance());
        return sb.toString();
    }
}
