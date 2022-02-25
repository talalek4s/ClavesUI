package com.example.clavesui;

public class Contrasena {
    String contrasena;
    int longitud;

    public Contrasena(String contrasena, int longitud) {
        this.contrasena = contrasena;
        this.longitud = longitud;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
