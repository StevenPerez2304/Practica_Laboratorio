/**
 * Link del repositorio: https://github.com/StevenPerez2304/Practica_Laboratorio.git
 * Integrantes:
 * Coello Anderson
 * Flores Emilio
 * Jumbo Steven
 * Perez Steven*/
package edu.unl.cc.model;

import java.time.LocalDate;

public class Travel {
    private double distanceTravelled;
    private LocalDate travelDate;
    private static double fuelPrice;
    private Vehicle vehicle;
    private boolean performMaintenance = false; // para sumar o no el costo del mantenimiento

    public Travel(LocalDate travelDate, double distanceTravelled, Vehicle vehicle) {
        if (travelDate == null) {
            throw new IllegalArgumentException("Llenar el campo requerido: Fecha del viaje");
        }
        if (distanceTravelled <= 0) {
            throw new IllegalArgumentException("La distancia del viaje debe ser mayor a 0");
        }
        if (vehicle == null) {
            throw new IllegalArgumentException("Llenar el campo requerido: Vehículo");
        }
        this.travelDate = travelDate;
        this.distanceTravelled = distanceTravelled;
        this.vehicle = vehicle;
    }

    public boolean isEmpty() {
        return travelDate == null || distanceTravelled <= 0 || vehicle == null;
    }

    // getter estático para obtener el precio del combustible
    public static double getFuelPrice() {
        return fuelPrice;
    }


    public static void setFuelPrice(double fuelPrice) {
        if (fuelPrice <= 0) {
            throw new IllegalArgumentException("El precio del combustible debe ser mayor a 0");
        }
        Travel.fuelPrice = fuelPrice; // pasar el valor a la variable estática
    }



    public double calculateCost() {
        double fuelConsumption = vehicle.getConsumptionFuel(); // obtener el consumo en base al vehículo seleccionado

        // Si el usuario dice que si, se retorna un True con el método obteniendo el costo de mantenimiento
        double maintenanceCost = performMaintenance ? vehicle.getCostMaintenance() : 0.0;

        // calcular el costo base sin tener en cuenta todavía el mantenimiento
        double baseCost = distanceTravelled * fuelConsumption * fuelPrice;

        // costo extra en caso de que la camioneta sea 4x4
        double extraFactor = 1.0; // establecemos en 1, porque así al multiplicar no hace nigún cambio
        if (vehicle instanceof Van) { // solo si estámos en la camioneta debe hacer esto
           Van van = (Van) vehicle; // con esto podemos usar los métodos de Van, con vehicle
            if (van.isDoubleTraction()) {
                extraFactor = 1.2; // si es True, lo transforma a 1.20 para el 20%
            }
        }

        return (baseCost + maintenanceCost) * extraFactor;
    }

    public double getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(double distanceTravelled) {
        if (distanceTravelled <= 0) {
            throw new IllegalArgumentException("La distancia no puede ser negativa.");
        }
        this.distanceTravelled = distanceTravelled;
    }

    public LocalDate getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(LocalDate travelDate) {
        if (travelDate == null) {
            throw new IllegalArgumentException("Llenar el campo requerido: Fecha del viaje");
        }
        this.travelDate = travelDate;
    }


    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("El vehículo no puede ser nulo");
        }
        this.vehicle = vehicle;
    }

    public boolean isPerformMaintenance() {
        return performMaintenance;
    }

    public void setPerformMaintenance(boolean performMaintenance) {
        this.performMaintenance = performMaintenance;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Viaje realizado en fecha: ").append(travelDate)
                .append(" | Distancia: ").append(distanceTravelled).append(" km")
                .append(" | Vehículo: ").append(vehicle.getcarLicense())
                .append(" | Costo total: $").append(String.format("%.2f", calculateCost()));
        return sb.toString();
    }
}
