package edu.unl.cc.model;

import java.time.LocalDate;

public class Travel {
    private double distanceTravelled;
    private LocalDate travelDate;
    private static double fuelPrice;

    private Vehicle vehicle;

    public Travel(LocalDate travelDate, double distanceTravelled, Vehicle vehicle) {
        if (distanceTravelled < 0) {
            throw new IllegalArgumentException("La distancia no puede ser negativa.");
        }
        this.travelDate = travelDate;
        this.distanceTravelled = distanceTravelled;
        this.vehicle = vehicle;
    }

    // getter estático para obtener el precio del combustible
    public static double getFuelPrice() {
        return fuelPrice;
    }


    public static void setFuelPrice(double fuelPrice) {
        if (fuelPrice < 0) {
            throw new IllegalArgumentException("El precio del combustible no puede ser negativo.");
        }
        Travel.fuelPrice = fuelPrice; // pasar el valor a la variable estática
    }

    public double calculateCost() {
        double fuelConsumption = vehicle.getConsumptionFuel(); // obtener el consumo en base al vehículo seleccionado
        double maintenanceCost = vehicle.getCostMaintenance(); // obtener el costo de mantenimiento en base al vehículo seleccionado

        // calcular el costo base sin tener en cuenta todavía el mantenimiento
        double baseCost = distanceTravelled * fuelConsumption * fuelPrice;

        // costo extra en caso de que la camioneta sea 4x4
        double extraFactor = 1.0; // establecemos en 1, porque así al multiplicar no hace nigún cambio
        if (vehicle instanceof Van) { // solo si estámos en la camioneta debe hacer esto
            Van van = (Van) vehicle; // con esto podemos usar los métodos de Van, con vehicle
            if (van.isFourByFour()) {
                extraFactor = 1.2; // si es True, lo transforma a 1.20 para el 20%
            }
        }

        return (baseCost + maintenanceCost) * extraFactor;
    }

    public double getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(double distanceTravelled) {
        if (distanceTravelled < 0) {
            throw new IllegalArgumentException("La distancia no puede ser negativa.");
        }
        this.distanceTravelled = distanceTravelled;
    }

    public LocalDate getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(LocalDate travelDate) {
        this.travelDate = travelDate;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
