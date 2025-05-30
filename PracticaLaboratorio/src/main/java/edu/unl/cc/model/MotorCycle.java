package edu.unl.cc.model;

import java.time.LocalDate;

public class MotorCycle extends Vehicle {

    private int displacement; //cilindrada 
    private static final double costMaintenance = 30.0;

    public MotorCycle(String credential, double tonnage, float consumptionFuel, LocalDate lastFixDateMaintenance) {
        super(credential, tonnage, consumptionFuel, lastFixDateMaintenance);
    }

    @Override
    void loadFuel() {
        System.out.println("Cargando " + getConsumptionFuel() + " L/km");
    }

    double getCostMaintenance() {
        return costMaintenance;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-Motocicleta- ");
        sb.append("Cilindrada: ").append(displacement);
        sb.append("Placa: ").append(getCredential());
        sb.append("Tonelaje").append(getTonnage());
        sb.append("Combustible: ").append(getConsumptionFuel());
        sb.append("ultima fecha de mantenimietno: ").append(getLastFixDateMaintenance());
        return sb.toString();
    }
}
