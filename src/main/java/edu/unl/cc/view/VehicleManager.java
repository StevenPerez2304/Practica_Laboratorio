package edu.unl.cc.view;

import edu.unl.cc.model.*;
import edu.unl.cc.service.MaintenanceFacade;
import edu.unl.cc.service.RegisterVehicle;
import java.time.LocalDate;
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
            displayMenu();
            try {
                int option = scanner.nextInt();
                scanner.nextLine();

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
                scanner.nextLine();
            }
        }
        System.out.println("\n¡Sistema cerrado exitosamente! \uD83D\uDE0A");
        scanner.close();
    }

    private static void displayWelcome() {
        //metodo para la bienvenida
        System.out.println("\n===== Gestion de Flota de Reparto =====");
        System.out.println("Autores: [Anderson Coello, Emilio Flores, Steven Jumbo, Steven Perez]");
        System.out.println("==========================================");
    }

    private static void displayMenu() {
        //metodo para mostrar el menu
        System.out.println("\nMENU PRINCIPAL");
        System.out.println("1. Registrar vehiculo");
        System.out.println("2. Registrar viaje");
        System.out.println("3. Actualizar mantenimiento");
        System.out.println("4. Listar vehiculos");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opcion: \n");
    }

    private static void registerVehicle() {
        //metodo para registrar el vehiculo
        System.out.println("\nREGISTRO DE VEHICULO");
        System.out.println("Tipo de vehiculo (1: Moto, 2: Camioneta, 3: Camion): ");
        int type = InputValidator.getValidInt(scanner, 1, 3);

        System.out.print("Placa: ");
        String licensePlate = scanner.nextLine().trim().toUpperCase();

        System.out.print("Capacidad (kg): ");
        double capacity = InputValidator.getValidDouble(scanner, 0.1, 10000.0);

        System.out.print("Consumo (l/km): ");
        float consumption = InputValidator.getValidFloat(scanner, 0.01f, 10.0f);

        System.out.print("Fecha ultimo mantenimiento (YYYY-MM-DD): ");
        LocalDate lastMaintenanceDate = InputValidator.getValidDate(scanner);

        try {
            switch (type) {
                case 1:
                    registerMotorcycle(licensePlate, capacity, consumption, lastMaintenanceDate);
                    break;
                case 2:
                    registerVan(licensePlate, capacity, consumption, lastMaintenanceDate);
                    break;
                case 3:
                    registerTruck(licensePlate, capacity, consumption, lastMaintenanceDate);
                    break;
            }
            System.out.println("\nVehiculo con placa " + licensePlate + " registrado exitosamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void registerMotorcycle(String plate, double capacity, float consumption, LocalDate date) {
        //metodo para registrar moto
        System.out.print("Cilindrada (cc): ");
        int displacement = InputValidator.getValidInt(scanner, 50, 2000);
        register.registerVehicle(new MotorCycle(displacement, plate, capacity, consumption, date));
    }

    private static void registerVan(String plate, double capacity, float consumption, LocalDate date) {
        //metodo para registrar camioneta
        System.out.print("¿Tiene traccion 4x4? (s/n): ");
        boolean is4x4 = InputValidator.getYesNoResponse(scanner);
        register.registerVehicle(new Van(plate, capacity, consumption, date, is4x4));
    }

    private static void registerTruck(String plate, double capacity, float consumption, LocalDate date) {
        //metodo para registrar camion
        System.out.print("Numero de ejes: ");
        int axles = InputValidator.getValidInt(scanner, 2, 10);
        register.registerVehicle(new Truck(plate, capacity, consumption, axles, date));
    }

    private static void registerTrip() {
        //metodo para registrar los viajes
        System.out.println("\nREGISTRO DE VIAJE");
        System.out.print("Placa del vehiculo: ");
        String licensePlate = scanner.nextLine().trim().toUpperCase();

        try {
            Vehicle vehicle = register.searchVehicle(licensePlate);
            checkMaintenanceAlert(vehicle);

            System.out.print("Distancia recorrida (km): ");
            double distance = InputValidator.getValidDouble(scanner, 0.1, 10000.0);

            System.out.print("Fecha del viaje (YYYY-MM-DD): ");
            LocalDate tripDate = InputValidator.getValidDate(scanner);

            System.out.print("Precio del combustible ($/litro): ");
            double fuelPrice = InputValidator.getValidDouble(scanner, 0.1, 10.0);

            Travel travel = new Travel(tripDate, distance, vehicle);
            Travel.setFuelPrice(fuelPrice);

            System.out.print("¿Se realizo mantenimiento? (s/n): ");
            travel.setPerformMaintenance(InputValidator.getYesNoResponse(scanner));

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
        //metodo para actualizar el mantenimiento
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
        //metodo para mostrar la lista de vehiculos registrados
        System.out.println("\nLISTADO DE VEHICULOS REGISTRADOS");
        System.out.println(register.displayVehicle());
    }

    private static void checkMaintenanceAlert(Vehicle vehicle) {
        //metodo para mostrar el mensaje de alerta por si no se ha hecho el mantenimiento en 6 meses
        MaintenanceFacade maintenance = new MaintenanceFacade(vehicle.getLastFixDateMaintenance());
        if (maintenance.needsMaintenance()) {
            System.out.println("¡ALERTA! Mantenimiento pendiente desde " + vehicle.getLastFixDateMaintenance());
        }
    }
}