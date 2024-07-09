package org.edu.oracle;

import com.google.gson.*;
import org.edu.oracle.model.Conversor;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conversor conversor = new Conversor();
        String input;

        String menu = "*************************************************************\n" +
                "Bienvenido al Conversor de Moneda :]\n" +
                "\n" +
                "1) Dólar =>> Peso argentino\n" +
                "2) Peso argentino =>> Dólar\n" +
                "3) Dólar =>> Real brasileño\n" +
                "4) Real brasileño =>> Dólar\n" +
                "5) Dólar =>> Peso colombiano\n" +
                "6) Peso colombiano =>> Dólar\n" +
                "7) Salir\n" +
                "Elija una opción válida:\n" +
                "*************************************************************";

        do {
            System.out.println(menu);
            input = scanner.nextLine();

            if (!input.equals("7")) {
                System.out.println("Ingrese la cantidad a convertir:");
                double amount = scanner.nextDouble();
                scanner.nextLine(); // Consumir la nueva línea después de nextDouble

                switch (input) {
                    case "1":
                        System.out.printf("Resultado: %.2f ARS%n", conversor.USDToARS(amount));
                        break;
                    case "2":
                        System.out.printf("Resultado: %.2f USD%n", conversor.ARSToUSD(amount));
                        break;
                    case "3":
                        System.out.printf("Resultado: %.2f BRL%n", conversor.USDToBRL(amount));
                        break;
                    case "4":
                        System.out.printf("Resultado: %.2f USD%n", conversor.BRLToUSD(amount));
                        break;
                    case "5":
                        System.out.printf("Resultado: %.2f COP%n", conversor.USDToCOP(amount));
                        break;
                    case "6":
                        System.out.printf("Resultado: %.2f USD%n", conversor.COPToUSD(amount));
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, elija una opción válida.");
                }
            } else {
                System.out.println("Saliendo del programa...");
            }
        } while (!input.equals("7"));

        scanner.close();
    }
}