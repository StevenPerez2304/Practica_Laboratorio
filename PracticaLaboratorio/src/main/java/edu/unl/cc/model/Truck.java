package edu.unl.cc.model;

import java.time.LocalDate;

public class Truck extends Vehicle {
    private int numberAxes; // número de ejes
    private static final double COST_MAINTENANCE = 400.0;
    private static final float CONSUMPTION_FUEL = 0.3f;

    public Truck(String credential, double tonnage, int numberAxes, LocalDate lastFixDateMaintenance) {
        super(credential, tonnage, CONSUMPTION_FUEL, lastFixDateMaintenance);
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
        sb.append("\nPlaca: ").append(getCredential());
        sb.append("\nTonelaje").append(getTonnage());
        sb.append("\nCombustible: ").append(getConsumptionFuel());
        sb.append("\nUltima fecha de mantenimiento: ").append(getLastFixDateMaintenance());
        return sb.toString();
    }
}
