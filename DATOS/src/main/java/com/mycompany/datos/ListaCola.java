package com.mycompany.datos;

public class ListaCola {
    private NodoCola cabeza;
    private NodoCola cola;

    public ListaCola() {
        cabeza = null;
        cola = null;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    // Encolar (agregar pedido)
    public void encolar(String cliente, int cantidad, String idProducto) {
        NodoCola nuevo = new NodoCola(cliente, cantidad, idProducto);
        if (estaVacia()) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            cola = nuevo;
        }
        System.out.println("✅ Pedido agregado a la cola.");
    }

    // Desencolar (quitar primer pedido)
    public void desencolar() {
        if (estaVacia()) {
            System.out.println("⚠️ No hay pedidos en la cola.");
        } else {
            System.out.println("🗑️ Pedido eliminado: " + cabeza);
            cabeza = cabeza.siguiente;
            if (cabeza == null) {
                cola = null;
            }
        }
    }

    // Mostrar pedidos en la cola
    public void mostrarPedidos() {
        if (estaVacia()) {
            System.out.println("No hay pedidos en la cola.");
        } else {
            System.out.println("Lista de pedidos en cola:");
            NodoCola actual = cabeza;
            while (actual != null) {
                System.out.println(" - " + actual);
                actual = actual.siguiente;
            }
        }
    }
}
