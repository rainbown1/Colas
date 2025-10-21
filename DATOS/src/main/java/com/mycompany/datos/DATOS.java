package com.mycompany.datos;

import java.util.Scanner;
public class DATOS {

    public static void main(String[] args) {
        int opcion;
        Scanner sc = new Scanner(System.in);
        ListaCola colaPedidos = new ListaCola();
        String producto = "ola";
        
        do{
            System.out.println("\n=== MENU DE PEDIDOS ===");
            System.out.println("1. Ver producto" +producto);
            System.out.println("2. Agregar producto al pedido");
            System.out.println("3. Quitar producto en pedido");
            System.out.println("4. Ver listado del pedido");
            System.out.println("5. Levantar el pedido");
            System.out.println("6. Salir");
            System.out.print("Elige una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();
            
            switch (opcion) {
                case 1:
                    System.out.println("Producto disponibles: ");
                    break;

                case 2:
                    System.out.print("Nombre del cliente: ");
                    String cliente = sc.nextLine();
                    System.out.print("Cantidad: ");
                    int cantidad = sc.nextInt();
                    sc.nextLine();
                    System.out.print("ID del producto: ");
                    String id = sc.nextLine();
                    colaPedidos.encolar(cliente, cantidad, id);
                    break;

                case 3:
                    colaPedidos.desencolar();
                    break;

                case 4:
                    colaPedidos.mostrarPedidos();
                    break;

                case 5:
                    System.out.println("Pedido levantado y enviado a producción.");
                    colaPedidos = new ListaCola();
                    break;

                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 6);

        sc.close();                    
            }
        }