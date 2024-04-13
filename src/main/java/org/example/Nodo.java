package org.example;

public class Nodo {
    String nombreCancion;
    String artista;
    String genero;
    int duracion; // en segundos
    Nodo siguiente;

    // Constructor de la clase Nodo
    public Nodo(String nombreCancion, String artista, String genero, int duracion) {
        this.nombreCancion = nombreCancion;
        this.artista = artista;
        this.genero = genero;
        this.duracion = duracion;
        this.siguiente = null;
    }
}
