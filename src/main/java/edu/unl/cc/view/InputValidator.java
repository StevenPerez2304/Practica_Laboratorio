/**
 * Link del repositorio: https://github.com/StevenPerez2304/Practica_Laboratorio.git
 * Integrantes:
 * Coello Anderson
 * Flores Emilio
 * Jumbo Steven
 * Perez Steven*/
package edu.unl.cc.view;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputValidator {

    public static int getValidInt(Scanner scanner, int min, int max) throws InputMismatchException{
        //metodo para validar si el numero ingresado es un numero entero y esta dentro del rango
        while (true) {
            try {
                int value = scanner.nextInt();
                scanner.nextLine();
                if (value >= min && value <= max) return value;
                System.out.print("Valor fuera de rango (" + min + "-" + max + "). Intente nuevamente: ");
            } catch (InputMismatchException e) {
                System.out.print("Debe ingresar un numero entero. Intente nuevamente: ");
                scanner.nextLine();
            }
        }
    }

    public static double getValidDouble(Scanner scanner, double min, double max) throws InputMismatchException{
        //metodo para validar si el numero ingresado es double y esta dentro del rango
        while (true) {
            try {
                double value = scanner.nextDouble();
                scanner.nextLine();
                if (value >= min && value <= max) return value;
                System.out.print("Valor fuera de rango (" + min + "-" + max + "). Intente nuevamente: ");
            } catch (InputMismatchException e) {
                System.out.print("Debe ingresar un numero valido. Intente nuevamente: ");
                scanner.nextLine();
            }
        }
    }

    public static float getValidFloat(Scanner scanner, float min, float max) throws InputMismatchException{
        //metodo para validar si el numero ingresado es un float y esta dentro del rango

        while (true) {
            try {
                float value = scanner.nextFloat();
                scanner.nextLine();
                if (value >= min && value <= max) return value;
                System.out.print("Valor fuera de rango (" + min + "-" + max + "). Intente nuevamente: ");
            } catch (InputMismatchException e) {
                System.out.print("Debe ingresar un numero valido. Intente nuevamente: ");
                scanner.nextLine();
            }
        }
    }

    public static LocalDate getValidDate(Scanner scanner) {
        //metodo para validar el LocalDate
        while (true) {
            try {
                return LocalDate.parse(scanner.nextLine().trim());
            } catch (DateTimeParseException e) {
                System.out.print("Formato invalido. Use YYYY-MM-DD: ");
            }
        }
    }

    public static boolean getYesNoResponse(Scanner scanner) {
        //a este metodo se lo usara en el isDoubleTraccion, para retornar en un true o false
        while (true) {
            String response = scanner.nextLine().trim().toLowerCase();
            if (response.equals("s")) return true;
            if (response.equals("n")) return false;
            System.out.print("Respuesta invalida. Ingrese 's' o 'n': ");
        }
    }
}