/**
 * Link del repositorio: https://github.com/StevenPerez2304/Practica_Laboratorio.git
 * Integrantes:
 * Coello Anderson
 * Flores Emilio
 * Jumbo Steven
 * Perez Steven*/
package edu.unl.cc.model;

import java.time.LocalDate;

public class MotorCycle extends Vehicle {

    private int displacement; //cilindrada 
    private static final double COST_MAINTENANCE = 100.0;

    public MotorCycle(int displacement, String carLicense,double tonnage, float consumptionFuel, LocalDate lastFixDateMaintenance) {
        super(carLicense, tonnage, consumptionFuel, lastFixDateMaintenance);
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
        sb.append("\nPlaca: ").append(getcarLicense());
        sb.append("\nTonelaje").append(getTonnage());
        sb.append("\nCombustible: ").append(getConsumptionFuel());
        sb.append("\nUltima fecha de mantenimiento: ").append(getLastFixDateMaintenance());
        return sb.toString();
    }
}
