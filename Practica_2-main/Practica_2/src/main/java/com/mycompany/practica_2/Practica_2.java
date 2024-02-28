/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.practica_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Ignacio
 */
public class Practica_2 {
    private static final String usuarios = "usuarios.txt";
    private static final String reservas = "reservas.txt";
    private static final int bloque = 5;
    
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Menu de inicio
        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Agregar usuario");
            System.out.println("2. Agregar reserva");
            System.out.println("3. Salir");
            System.out.print("Ingrese una opción: ");
            int opcion = 0;
            try {
                opcion = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            switch (opcion) {
                case 1:
                    agregarUsuario(reader);
                    break;
                case 2:
                    agregarReserva(reader);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        }
    }

    // Agrega un usuario al txt
    private static void agregarUsuario(BufferedReader reader) {
        try {
        while (true) {
            System.out.print("Ingrese cédula del usuario: ");
            String cedula = reader.readLine();
            
            if (existeUsuario(cedula)) {
                System.err.println("El usuario ya existe.");
                continue;
            }

            System.out.print("Ingrese nombre del usuario: ");
            String nombre = reader.readLine();
            System.out.print("Ingrese número telefónico del usuario: ");
            String telefono = reader.readLine();

            Usuario usuario = new Usuario(cedula, nombre, telefono);
            guardarUsuario(usuario);

            System.out.print("¿Desea ingresar otro usuario? (s/n): ");
            String respuesta = reader.readLine();
            if (!respuesta.equalsIgnoreCase("s")) {
                break;
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    private static void agregarReserva(BufferedReader reader) {
        try {
            int reservaCount = 0;
            while (true) {
                System.out.print("Ingrese cédula del usuario: ");
                String cedula = reader.readLine();

                // Verificar si el número de cédula existe
                if (!existeUsuario(cedula)) {
                    System.out.println("El usuario no existe.");
                    return;
                }

                // Solicita detalles de la reserva
                System.out.println("Ingrese los detalles de la reserva:");
                System.out.print("Fecha de comida (DD/MM/YYYY): ");
                String fechaComida = reader.readLine();
                System.out.print("Tipo de comida (Desayuno/Almuerzo/Cena): ");
                String tipoComida = reader.readLine();
                System.out.print("Guarnicion 1 (Arroz/Frijoles/Pancakes/Frutas): ");
                String guarnicion1 = reader.readLine();
                System.out.print("Guarnicion 2 (Arroz/Frijoles/Pancakes/Frutas): ");
                String guarnicion2 = reader.readLine();
                System.out.print("Proteína (Carne/Pescado/Pollo/Huevos): ");
                String proteina = reader.readLine();
                System.out.print("Ensalada (Verde/Rusa): ");
                String ensalada = reader.readLine();

                // Guarda la reserva
                Reserva reserva = new Reserva(cedula, fechaComida, tipoComida, guarnicion1, guarnicion2, proteina, ensalada);
                guardarReserva(reserva);

                reservaCount++;
                if (reservaCount % bloque == 0) {
                    System.out.print("¿Desea ingresar más reservas? (s/n): ");
                    String respuesta = reader.readLine();
                    if (!respuesta.equalsIgnoreCase("s")) {
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Verifica la cedula del usuario para saber que no exista una igual
    private static boolean existeUsuario(String cedula) {
    try (BufferedReader reader = new BufferedReader(new FileReader(usuarios))) {
        String line;
        System.out.println("Cédula buscada: " + cedula);
        while ((line = reader.readLine()) != null) {
            System.out.println("Línea del archivo: " + line);
            String[] userData = line.split(" ");
            if (userData.length >= 1 && userData[0].equals(cedula)) {
                return true;
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return false;
}
    // Guarda el usuario en el txt
    private static void guardarUsuario(Usuario usuario) {
        synchronized (Practica_2.class) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(usuarios, true))) {
                writer.write(usuario.toString() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Guarda la reserva en el txt
    private static void guardarReserva(Reserva reserva) {
        synchronized (Practica_2.class) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(reservas, true))) {
                writer.write(reserva.getCedula() + "\n" + reserva.toString() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}