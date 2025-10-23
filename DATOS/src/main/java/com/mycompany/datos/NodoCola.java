package com.mycompany.datos;

public class NodoCola {
    int id;
    String cliente;
    String[] productos;
    int[] cantidades;
    int totalProductos;
    NodoCola siguiente;

    public NodoCola(int id, String cliente, String[] productos, int[] cantidades, int totalProductos) {
        this.id = id;
        this.cliente = cliente;
        this.productos = productos;
        this.cantidades = cantidades;
        this.totalProductos = totalProductos;
        this.siguiente = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id)
          .append(" | Cliente: ").append(cliente)
          .append(" | Productos: ");
        for (int i = 0; i < totalProductos; i++) {
            if (productos[i] != null) {
                sb.append(productos[i]).append(" x").append(cantidades[i]);
                if (i < totalProductos - 1) sb.append(", ");
            }
        }
        return sb.toString();
    }
}
