/**
 * Link del repositorio: https://github.com/StevenPerez2304/Practica_Laboratorio.git
 * Integrantes:
 * Coello Anderson
 * Flores Emilio
 * Jumbo Steven
 * Perez Steven */
package edu.unl.cc.model;

import java.time.LocalDate;

public class Van extends Vehicle {

    private boolean doubleTraction; //simple (4*2) o doble (4*4)
    private static final double COST_MAINTENANCE = 300.0;

    public Van(String carLicense, double tonnage, float consumptionFuel, LocalDate lastFixDateMaintenance, boolean doubleTraction) {
        super(carLicense, tonnage, consumptionFuel, lastFixDateMaintenance);
        this.doubleTraction = doubleTraction;
    }

    @Override
    void loadFuel() {
        System.out.println("Cargando " + getConsumptionFuel());
    }

    @Override
    public double getCostMaintenance() {
        return COST_MAINTENANCE;
    }

    public boolean isDoubleTraction() {
        return doubleTraction;
    }

    public void setDoubleTraction(boolean doubleTraction) {
        this.doubleTraction = doubleTraction;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-Camioneta- \n");
        if (doubleTraction == true) {
            sb.append("Doble traccion: ").append("SI");
        } else {
            sb.append("Doble traccion: ").append("NO");
        }
        sb.append("\nPlaca: ").append(getcarLicense());
        sb.append("\nTonelaje").append(getTonnage());
        sb.append("\nCombustible: ").append(getConsumptionFuel());
        sb.append("\nUltima fecha de mantenimiento: ").append(getLastFixDateMaintenance());
        return sb.toString();
    }
}
