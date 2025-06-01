/**
 * Link del repositorio: https://github.com/StevenPerez2304/Practica_Laboratorio.git
 * Integrantes:
 * Coello Anderson
 * Flores Emilio
 * Jumbo Steven
 * Perez Steven*/
package edu.unl.cc.view;

import edu.unl.cc.model.*;
import edu.unl.cc.service.MaintenanceFacade;
import edu.unl.cc.service.RegisterVehicle;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class VehicleManager {
    private static final RegisterVehicle register = new RegisterVehicle();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayWelcome();
        boolean exit = false;

        while (!exit) {
            displayMenu(); // mostrar menú
            try {
                int option = scanner.nextInt();
                scanner.nextLine();  // Limpiar buffer

                switch (option) {
                    case 1:
                        registerVehicle();
                        break;
                    case 2:
                        registerTrip();
                        break;
                    case 3:
                        updateMaintenance();
                        break;
                    case 4:
                        listVehicles();
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("Opcion invalida. Intente nuevamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un numero entero.");
                scanner.nextLine();  // Limpiar buffer inválido
            }
        }
        System.out.println("\n¡Sistema cerrado exitosamente! \uD83D\uDE0A");
        scanner.close();
    }

    private static void displayWelcome() {
        System.out.println("\n=== Gestion de Flota de Reparto ===");
        System.out.println("Autores: [Anderson Coello, Emilio Flores, Steven Jumbo, Steven Perez]");
        System.out.println("===================================");
    }

    private static void displayMenu() {
        System.out.println("\nMENU PRINCIPAL");
        System.out.println("1. Registrar vehiculo");
        System.out.println("2. Registrar viaje");
        System.out.println("3. Actualizar mantenimiento");
        System.out.println("4. Listar vehiculos");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opcion: \n");
    }

    private static void registerVehicle() {
        System.out.println("\nREGISTRO DE VEHICULO");
        System.out.println("Tipo de vehiculo (1: Moto, 2: Camioneta, 3: Camion): ");
        int type = getValidInt(1, 3);

        System.out.print("Placa: ");
        String licensePlate = scanner.nextLine().trim().toUpperCase();

        System.out.print("Capacidad (kg): ");
        double capacity = getValidDouble(0.1, 10000.0);

        System.out.print("Consumo (l/km): ");
        float consumption = getValidFloat(0.01f, 10.0f);

        System.out.print("Fecha ultimo mantenimiento (YYYY-MM-DD): ");
        LocalDate lastMaintenanceDate = getValidDate();

        try {
            switch (type) {
                case 1: // moto
                    registerMotorcycle(licensePlate, capacity, consumption, lastMaintenanceDate);
                    break;
                case 2: // camioneta
                    registerVan(licensePlate, capacity, consumption, lastMaintenanceDate);
                    break;
                case 3: // camión
                    registerTruck(licensePlate, capacity, consumption, lastMaintenanceDate);
                    break;
            }
            System.out.println("\nVehiculo " + licensePlate + " registrado exitosamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void registerMotorcycle(String plate, double capacity, float consumption, LocalDate date) {
        System.out.print("Cilindrada (cc): ");
        int displacement = getValidInt(50, 2000);
        MotorCycle motorcycle = new MotorCycle(displacement, plate, capacity, consumption, date);
        register.registerVehicle(motorcycle);
    }

    private static void registerVan(String plate, double capacity, float consumption, LocalDate date) {
        System.out.print("¿Tiene traccion 4x4? (s/n): ");
        boolean is4x4 = getYesNoResponse();
        Van van = new Van(plate, capacity, consumption, date, is4x4);
        register.registerVehicle(van);
    }

    private static void registerTruck(String plate, double capacity, float consumption, LocalDate date) {
        System.out.print("Numero de ejes: ");
        int axles = getValidInt(2, 10);
        Truck truck = new Truck(plate, capacity, consumption, axles, date);
        register.registerVehicle(truck);
    }

    private static void registerTrip() {
        System.out.println("\nREGISTRO DE VIAJE");
        System.out.print("Placa del vehiculo: ");
        String licensePlate = scanner.nextLine().trim().toUpperCase();

        try {
            Vehicle vehicle = register.searchVehicle(licensePlate);
            checkMaintenanceAlert(vehicle);

            System.out.print("Distancia recorrida (km): ");
            double distance = getValidDouble(0.1, 10000.0);

            System.out.print("Fecha del viaje (YYYY-MM-DD): ");
            LocalDate tripDate = getValidDate();

            System.out.print("Precio del combustible ($/litro): ");
            double fuelPrice = getValidDouble(0.1, 10.0);

            Travel travel = new Travel(tripDate, distance, vehicle);
            Travel.setFuelPrice(fuelPrice);

            System.out.print("¿Se realizo mantenimiento? (s/n): ");
            travel.setPerformMaintenance(getYesNoResponse());

            System.out.println("\n=== RESUMEN DEL VIAJE ===");
            System.out.println("Combustible: " + vehicle.getConsumptionFuel() + " litros/km");
            System.out.println("Mantenimiento: $" + (travel.isPerformMaintenance() ? vehicle.getCostMaintenance() : 0));
            System.out.println("Costo del viaje: $" + String.format("%.2f", travel.calculateCost()));

            register.registerTravel(travel);
        } catch (NoSuchElementException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void updateMaintenance() {
        System.out.println("\nACTUALIZACION DE MANTENIMIENTO");
        System.out.print("Placa del vehiculo: ");
        String licensePlate = scanner.nextLine().trim().toUpperCase();

        try {
            Vehicle vehicle = register.searchVehicle(licensePlate);
            vehicle.setLastFixDateMaintenance(LocalDate.now());
            System.out.println("Mantenimiento actualizado para " + licensePlate + ". Nueva fecha: " + LocalDate.now());
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void listVehicles() {
        System.out.println("\nLISTADO DE VEHICULOS REGISTRADOS");
        System.out.println(register.displayVehicle());
    }

    // ===== HELPER METHODS =====
    private static void checkMaintenanceAlert(Vehicle vehicle) {
        MaintenanceFacade maintenance = new MaintenanceFacade(vehicle.getLastFixDateMaintenance());
        if (maintenance.needsMaintenance()) {
            System.out.println("¡ALERTA! Mantenimiento pendiente desde " +
                    vehicle.getLastFixDateMaintenance());
        }
    }

    private static LocalDate getValidDate() {
        while (true) {
            try {
                return LocalDate.parse(scanner.nextLine().trim());
            } catch (DateTimeParseException e) {
                System.out.print("Formato invalido. Use YYYY-MM-DD: ");
            }
        }
    }

    private static boolean getYesNoResponse() {
        while (true) {
            String response = scanner.nextLine().trim().toLowerCase();
            if (response.equals("s")) return true;
            if (response.equals("n")) return false;
            System.out.print("Respuesta invalida. Ingrese 's' o 'n': ");
        }
    }

    // método para el switch de elegir el tipo de vehiculo, y validar que elija entre 1 a 3 como opciones
    private static int getValidInt(int min, int max) {
        while (true) {
            try {
                int value = scanner.nextInt();
                scanner.nextLine();  // Limpiar buffer
                if (value >= min && value <= max) // si no está dentro de 1 - 3, pues no funcionará
                    return value;
                System.out.print("Valor fuera de rango (" + min + "-" + max + "). Intente nuevamente: ");
            } catch (InputMismatchException e) {
                System.out.print("Debe ingresar un numero entero. Intente nuevamente: ");
                scanner.nextLine();  // Limpiar entrada inválida
            }
        }
    }

    private static double getValidDouble(double min, double max) {
        while (true) {
            try {
                double value = scanner.nextDouble();
                scanner.nextLine();  // Limpiar buffer
                if (value >= min && value <= max) return value;
                System.out.print("Valor fuera de rango (" + min + "-" + max + "). Intente nuevamente: ");
            } catch (InputMismatchException e) {
                System.out.print("Debe ingresar un numero valido. Intente nuevamente: ");
                scanner.nextLine();  // Limpiar entrada inválida
            }
        }
    }

    private static float getValidFloat(float min, float max) {
        while (true) {
            try {
                float value = scanner.nextFloat();
                scanner.nextLine();  // Limpiar buffer
                if (value >= min && value <= max) return value;
                System.out.print("Valor fuera de rango (" + min + "-" + max + "). Intente nuevamente: ");
            } catch (InputMismatchException e) {
                System.out.print("Debe ingresar un numero valido. Intente nuevamente: ");
                scanner.nextLine();  // Limpiar entrada inválida
            }
        }
    }
}