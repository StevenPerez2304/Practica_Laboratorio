package edu.unl.cc.view;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputValidator {

    public static int getValidInt(Scanner scanner, int min, int max) {
        //metodo para validar numeros enteros y que este dentro del rango permitido
        while (true) {
            try {
                int value = scanner.nextInt();
                scanner.nextLine();
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.print("Valor fuera de rango (" + min + "-" + max + "). Intente nuevamente: ");
            } catch (InputMismatchException e) {
                System.out.print("Debe ingresar un numero entero. Intente nuevamente: ");
                scanner.nextLine();
            }
        }
    }

    public static double getValidDouble(Scanner scanner, double min, double max) {
        //metodo para validar numeros doubles y que este dentro del rango
        while (true) {
            try {
                double value = scanner.nextDouble();
                scanner.nextLine();
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.print("Valor fuera de rango (" + min + "-" + max + "). Intente nuevamente: ");
            } catch (InputMismatchException e) {
                System.out.print("Debe ingresar un numero valido. Intente nuevamente: ");
                scanner.nextLine();
            }
        }
    }

    public static float getValidFloat(Scanner scanner, float min, float max)  {
        //metodo para validar numeros flotantes y que esten dentro del rango
        while (true) {
            try {
                float value = scanner.nextFloat();
                scanner.nextLine();
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.print("Valor fuera de rango (" + min + "-" + max + "). Intente nuevamente: ");
            } catch (InputMismatchException e) {
                System.out.print("Debe ingresar un numero valido. Intente nuevamente: ");
                scanner.nextLine();
            }
        }
    }

    public static LocalDate getValidDate(Scanner scanner) {
        //metodo para validar el formato de la fecha ingresada por el conductor
        while (true) {
            try {
                return LocalDate.parse(scanner.nextLine().trim());
            } catch (DateTimeParseException e) {
                System.out.print("Formato invalido. Use YYYY-MM-DD: ");
            }
        }
    }

    public static boolean getYesNoResponse(Scanner scanner) {
        //metodo para validar correctamente si o no
        while (true) {
            String response = scanner.nextLine().trim().toLowerCase();
            if ("s".equals(response)) {
                return true;
            }
            if ("n".equals(response)) {
                return false;
            }
            System.out.print("Respuesta invalida. Ingrese 's' o 'n': ");
        }
    }
}