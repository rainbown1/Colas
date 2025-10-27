package com.mycompany.datos;

import java.util.Scanner;
public class DATOS {

    public static void main(String[] args) {
        int opcion;
        Scanner sc = new Scanner(System.in);
        ListaCola colaPedidos = new ListaCola();
        String[] producto = new String[3];
        int[] cantidad = new int[3];
         producto[0] = "Chica";
        cantidad[0] = 12;

        producto[1] = "Mediana";
        cantidad[1] = 20;
        
        producto[2] = "Grande";
        cantidad[2] = 10;

        
        do{
            System.out.println("\n=== MENU DE PEDIDOS GORRAS===");
            System.out.println("1. Ver producto");
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
                   
        for (int i = 0; i < producto.length; i++) {
            System.out.println("Producto: " + producto[i] + ", Cantidad: " + cantidad[i]);
        }
                    break;

                case 2:
               System.out.print("Nombre del cliente: ");
                    String cliente = sc.nextLine();

                    String[] productosPedido = new String[3];
                    int[] cantidadesPedido = new int[3];
                    int contador = 0;

                    String continuar;
                    do {
                        if (contador >= 3) {
                            System.out.println("No puedes agregar más de 3 productos por pedido.");
                            break;
                        }

                        System.out.println("Elige el producto:");
                        for (int i = 0; i < producto.length; i++) {
                            System.out.println((i + 1) + ". " + producto[i] + " (Stock: " + cantidad[i] + ")");
                        }

                        int prod = sc.nextInt();
                        System.out.print("Cantidad: ");
                        int cant = sc.nextInt();
                        sc.nextLine();

                        if (prod < 1 || prod > 3) {
                            System.out.println("Opción no válida.");
                        } else if (cantidad[prod - 1] < cant) {
                            System.out.println("Stock insuficiente. Solo hay " + cantidad[prod - 1] + " disponibles.");
                        } else {
                            cantidad[prod - 1] -= cant;
                            productosPedido[contador] = producto[prod - 1];
                            cantidadesPedido[contador] = cant;
                            contador++;
                            System.out.println("Producto agregado al pedido.");
                        }

                        System.out.print("Agregar otro producto al mismo pedido? (s/n): ");
                        continuar = sc.nextLine();

                    } while (continuar.equalsIgnoreCase("s"));

                    colaPedidos.encolar(cliente, productosPedido, cantidadesPedido, contador);
                    break;

                case 3:
                    colaPedidos.desencolar();
                    break;

                case 4:
                    colaPedidos.mostrarPedidos();
                    break;

                case 5:
                    colaPedidos.levantarPedido();
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