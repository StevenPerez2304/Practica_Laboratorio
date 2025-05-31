package edu.unl.cc.model;

import java.time.LocalDate;

public class Van extends Vehicle {

    private boolean dobleTraccion; //simple (4*2) o doble (4*4)
    private static double costMaintenance;

    @Override
    void loadFuel() {
        System.out.println("Cargando " + getConsumptionFuel());
    }

    @Override
    double getCostMaintenance() {
        return 0;
    }

    public Van(String credential, double tonnage, float fuel, LocalDate lastFixDateMaintenance) {
        super(credential, tonnage, fuel, lastFixDateMaintenance);
    }
}
