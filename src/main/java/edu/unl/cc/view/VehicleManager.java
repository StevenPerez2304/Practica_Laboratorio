/**
 * Link del repositorio: https://github.com/StevenPerez2304/Practica_Laboratorio.git
 * Integrantes:
 * Coello Anderson
 * Flores Emilio
 * Jumbo Steven
 * Perez Steven*/
package edu.unl.cc.view;

import java.util.Scanner;

public class VehicleManager {
    public static void menuVehicle() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("=== Gestión de Flota de Reparto ===");
            System.out.println("Autores: Raul Perez, Emilio Flores, Anderson Coello, Steven Jumbo");
            System.out.println("-------------------------");
            System.out.println("1. Registrar vehiculo");
            System.out.println("2. Registrar el viaje");
            System.out.println("3. Actualizar matenimiento");
            System.out.println("4. listar vehiculos");
            System.out.println("5. Salir");
            opcion = scanner.nextInt();
            switch (opcion) {

                case 1:
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    //opcion de salida
                    break;
            }

        }while (opcion != 5);{
            System.out.println("Gracias por usar ");
        }
    }

    public static void main(String[] args) {


    }
}
