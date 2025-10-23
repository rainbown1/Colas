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
            System.out.println("\n=== MENU DE PEDIDOS ===");
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
                    String tipo= "";
                    System.out.println("Nombre del cliente: ");
                    String cliente = sc.nextLine();
                    System.out.println("Cantidad: ");
                    int cant = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Producto: ");
                    System.out.println("1-Chico");
                    System.out.println("2-Mediano");
                     System.out.println("3-Grande");
                    int prod  = sc.nextInt();

                    if (prod < 1 || prod > 3) {
    System.out.println("Opción no válida.");
} else if (cantidad[prod - 1] == 0) {
    System.out.println("No hay stock del producto " + producto[prod - 1]);
} else if (cantidad[prod - 1] < cant) {
    System.out.println("Solo hay " + cantidad[prod - 1] + " unidades disponibles de " + producto[prod - 1]);
} else {
                    switch (prod) {
                        case 1:
                            System.out.println("Seleccionaste el producto chico");
                           tipo = "Chico";
                            cantidad[prod - 1] -= cant;
                            break;
                    
                            case 2:
                             System.out.println("Seleccionaste el producto mediano");
                           tipo = "Mediano";
                           cantidad[prod - 1] -= cant;
                            break;
                              case 3:
                             System.out.println("Seleccionaste el producto Grande");
                           tipo = "Grande";
                           cantidad[prod - 1] -= cant;
                            break;
                        default:
                            break;
                    }
                    colaPedidos.encolar(cliente, cant,tipo);
                }
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