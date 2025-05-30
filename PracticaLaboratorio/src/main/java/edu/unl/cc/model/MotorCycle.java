package edu.unl.cc.model;

import java.time.LocalDate;

public class MotorCycle extends Vehicle{
    private int displacement; //cilindrada 
    private static final double costMaintenance = 30.0;

    public MotorCycle(String credential, double tonnage, float fuel, LocalDate lastFixDateMaintenance) {
        super(credential, tonnage, fuel, lastFixDateMaintenance);
    }

    @Override
    void loadFuel() {
        System.out.println("Cargando " + getConsumptionFuel () + " L/km");
    }

    double getCostMaintenance() {
        return costMaintenance;
    }

}
