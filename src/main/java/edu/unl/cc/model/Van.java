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
    void loadFuel() {System.out.println("Cargando " + getConsumptionFuel());}

    @Override
    double getCostMaintenance() {
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
        sb.append("-Van- ");
        sb.append("doubleTraction=").append(doubleTraction);
        sb.append("Placa: ").append(getcarLicense());
        sb.append("Tonelaje").append(getTonnage());
        sb.append("Combustible: ").append(getConsumptionFuel());
        sb.append("ultima fecha de mantenimietno: ").append(getLastFixDateMaintenance());
        return sb.toString();
    }
}
