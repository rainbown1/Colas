package com.mycompany.datos;

import java.util.Scanner;

public class ListaCola {
    private NodoCola cabeza;
    private NodoCola cola;
    private int contadorPedidos;

    public ListaCola() {
        cabeza = null;
        cola = null;
        contadorPedidos = 0;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

   
    public void encolar(String cliente, String[] productos, int[] cantidades, int totalProductos) {
        contadorPedidos++;
        NodoCola nuevo = new NodoCola(contadorPedidos, cliente, productos, cantidades, totalProductos);
        if (estaVacia()) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            cola = nuevo;
        }
        System.out.println(" Pedido agregado con ID: " + nuevo.id);
    }

    public void desencolar() {
    if (estaVacia()) {
        System.out.println(" No hay pedidos en la cola.");
        return;
    }

    Scanner sc = new Scanner(System.in);
    System.out.print("Ingresa el ID del pedido: ");
    int id = sc.nextInt();

    NodoCola actual = cabeza;
    boolean encontrado = false;

    while (actual != null) {
        if (actual.id == id) {
            encontrado = true;
           
            System.out.println("Productos en el pedido:");
            for (int i = 0; i < actual.totalProductos; i++) {
                if (actual.productos[i] != null) {
                    System.out.println((i + 1) + ". " + actual.productos[i] + " x" + actual.cantidades[i]);
                }
            }

            System.out.print("Ingresa el número del producto a eliminar: ");
            int prodEliminar = sc.nextInt() - 1;

            if (prodEliminar < 0 || prodEliminar >= actual.totalProductos || actual.productos[prodEliminar] == null) {
                System.out.println("Producto no válido.");
            } else {
                System.out.println("Producto eliminado: " + actual.productos[prodEliminar] + " x" + actual.cantidades[prodEliminar]);
                for (int j = prodEliminar; j < actual.totalProductos - 1; j++) {
                    actual.productos[j] = actual.productos[j + 1];
                    actual.cantidades[j] = actual.cantidades[j + 1];
                }
                actual.productos[actual.totalProductos - 1] = null;
                actual.cantidades[actual.totalProductos - 1] = 0;
                actual.totalProductos--;
            }
            break;
        }
        actual = actual.siguiente;
    }

    if (!encontrado) {
        System.out.println("No existe un pedido con ese ID.");
    }
}


  
    public void mostrarPedidos() {
        if (estaVacia()) {
            System.out.println("No hay pedidos en la cola.");
        } else {
            System.out.println("\n--- LISTADO DE PEDIDOS ---");
            NodoCola actual = cabeza;
            while (actual != null) {
                System.out.println(" - " + actual);
                actual = actual.siguiente;
            }
        }
    }


    private void reordenarIDs() {
        NodoCola actual = cabeza;
        int nuevoID = 1;
        while (actual != null) {
            actual.id = nuevoID;
            nuevoID++;
            actual = actual.siguiente;
        }
        contadorPedidos = nuevoID - 1;
    }

    public void levantarPedido() {
    if (estaVacia()) {
        System.out.println("No hay pedidos para levantar.");
        return;
    }

    Scanner sc = new Scanner(System.in);
    mostrarPedidos();

    System.out.print("\nIngresa el ID del pedido que deseas levantar: ");
    int idEliminar = sc.nextInt();

    NodoCola actual = cabeza;
    NodoCola anterior = null;
    boolean encontrado = false;

    while (actual != null) {
        if (actual.id == idEliminar) {
            encontrado = true;

            System.out.println("\nPedido del cliente '" + actual.cliente + "' levantado y enviado a producción.");

            
            if (anterior == null) {
                cabeza = actual.siguiente;
                if (cabeza == null) {
                    cola = null; 
                }
            } 
         
            else {
                anterior.siguiente = actual.siguiente;
                if (actual == cola) {
                    cola = anterior;
                }
            }

            reordenarIDs();
            break;
        }
        anterior = actual;
        actual = actual.siguiente;
    }

    if (!encontrado) {
        System.out.println("No existe un pedido con ese ID.");
    }
}


    
}
