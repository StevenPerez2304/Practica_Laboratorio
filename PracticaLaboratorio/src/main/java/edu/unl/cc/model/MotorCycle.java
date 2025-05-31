package edu.unl.cc.model;

import java.time.LocalDate;

public class MotorCycle extends Vehicle {

    private int displacement; //cilindrada 
    private static final double COST_MAINTENANCE = 100.0;
    private static final float CONSUMPTION_FUEL = 0.3f;
    
    public MotorCycle(int displacement, String credential, double tonnage, float consumptionFuel, LocalDate lastFixDateMaintenance) {
        super(credential, tonnage, CONSUMPTION_FUEL, lastFixDateMaintenance);
        this.displacement = displacement;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    @Override
    void loadFuel() {
        System.out.println("Cargando combustible: " + getConsumptionFuel() + " L/km");
    }

    @Override
    public double getCostMaintenance() {
        return COST_MAINTENANCE;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-Motocicleta- \n");
        sb.append("Cilindrada: ").append(displacement);
        sb.append("\nPlaca: ").append(getCredential());
        sb.append("\nTonelaje").append(getTonnage());
        sb.append("\nCombustible: ").append(getConsumptionFuel());
        sb.append("\nUltima fecha de mantenimietno: ").append(getLastFixDateMaintenance());
        return sb.toString();
    }
}
