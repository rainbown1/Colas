package com.mycompany.datos;

public class NodoCola {
    String cliente;
    int cantidad;
    String tipo;
    NodoCola siguiente;

    public NodoCola(String cliente, int cantidad, String tipo) {
        this.cliente = cliente;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.siguiente = null;
    }

    @Override
    public String toString() {
        return "Cliente: " + cliente + " | Cantidad: " + cantidad + " | Tipo de Producto: " + tipo;
    }
}