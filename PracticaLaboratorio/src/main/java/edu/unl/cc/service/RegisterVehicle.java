package edu.unl.cc.service;

import java.io.Serializable;

import edu.unl.cc.model.Vehicle;
import edu.unl.cc.model.Travel;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class RegisterVehicle implements Serializable {

    private final Map<String, Vehicle> vehicleMap = new HashMap<>();
    private final List<Travel> travelList = new ArrayList<>();

    public void registerVehicle(Vehicle vehicle) throws IllegalArgumentException {
        String credential = vehicle.getCredential();
        if (credential == null || credential.trim().isEmpty()) {
            throw new IllegalArgumentException("La credencial no puede ser nula o estar vacía");
        }
        credential = credential.trim().toUpperCase();
        if (vehicleMap.containsKey(credential)) {
            throw new IllegalArgumentException("Vehículo con credencial " + credential + " ya existe");
        }
        vehicleMap.put(credential, vehicle);
    }

    public void registerTravel(Travel travel) throws IllegalArgumentException {
        if (travel == null) {
            throw new IllegalArgumentException("El viaje no puede ser nulo");
        }
        travelList.add(travel);
    }

    public Vehicle searchVehicle(String credential) throws NoSuchElementException {
        Vehicle vehicle = vehicleMap.get(credential);
        if (vehicle == null) {
            throw new NoSuchElementException("Vehículo con credencial " + credential + " no encontrado");
        }
        return vehicle;
    }

    public String displayVehicle() {
        if (vehicleMap.isEmpty() ) {
            return "No hay vehículos registrados";
        }
        StringBuilder stringBuilder = new StringBuilder("Vehículos registrados:\n");
        for (Vehicle vehicle : vehicleMap.values()) {
            stringBuilder.append("- ").append(vehicle.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}