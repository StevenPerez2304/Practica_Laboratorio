/**
 * Link del repositorio: https://github.com/StevenPerez2304/Practica_Laboratorio.git
 * Integrantes:
 * Coello Anderson
 * Flores Emilio
 * Jumbo Steven
 * Perez Steven*/
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

    private final Map<String, Vehicle> vehicleMap = new HashMap<>(); // hashmap para usar en formato vehiculo carLicense
    private final List<Travel> travelList = new ArrayList<>(); //lista para guardar los viajes

    /**
     *
     * @param vehicle
     * @throws IllegalArgumentException
     */
    public void registerVehicle(Vehicle vehicle) throws IllegalArgumentException {
        //metodo para registar vehiculos
        String credential = vehicle.getcarLicense();
        if (credential == null || credential.trim().isEmpty()) { //verificamos si la credencial no esta vacia
            throw new IllegalArgumentException("La credencial no puede ser nula o estar vacía");
        }
        credential = credential.trim().toUpperCase();
        if (vehicleMap.containsKey(credential)) {
            throw new IllegalArgumentException("Vehículo con credencial " + credential + " ya existe");
        }
        vehicleMap.put(credential, vehicle);
    }

    /**
     *
     * @param travel
     * @throws IllegalArgumentException
     */
    public void registerTravel(Travel travel) throws IllegalArgumentException {
        //metodo para registrar los viajes, ya sea de moto, camioneta y camion
        if (travel == null) {
            throw new IllegalArgumentException("El viaje no puede ser nulo");
        }
        travelList.add(travel);
    }

    /**
     *
     * @param credential
     * @return
     * @throws NoSuchElementException
     */

    public Vehicle searchVehicle(String credential) throws NoSuchElementException {
        //metodo para buscar el vehiculo
        Vehicle vehicle = vehicleMap.get(credential);
        if (vehicle == null) {
            throw new NoSuchElementException("Vehículo con credencial " + credential + " no encontrado");
        }
        return vehicle;
    }

    public String displayVehicle() {
        //metodo para presentar los vehiculos registrados
        if (vehicleMap.isEmpty() ) { //verificamos si no esta vacio el mapa
            return "No hay vehículos registrados";
        }
        StringBuilder stringBuilder = new StringBuilder("Vehículos registrados:\n");
        for (Vehicle vehicle : vehicleMap.values()) {
            stringBuilder.append("- ").append(vehicle.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}