package com.mycompany.datos;

public class NodoCola {
    String cliente;
    int cantidad;
    String idProducto;
    NodoCola siguiente;

    public NodoCola(String cliente, int cantidad, String idProducto) {
        this.cliente = cliente;
        this.cantidad = cantidad;
        this.idProducto = idProducto;
        this.siguiente = null;
    }

    @Override
    public String toString() {
        return "Cliente: " + cliente + " | Cantidad: " + cantidad + " | ID Producto: " + idProducto;
    }
}