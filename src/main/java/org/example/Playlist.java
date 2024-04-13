package org.example;

public class Playlist {
    private Nodo cabeza; // Nodo inicial de la lista

    // Constructor de la clase Playlist
    public Playlist() {
        this.cabeza = null;
    }

    // Método para agregar una nueva canción a la playlist
    public void agregarCancion(String nombreCancion, String artista, String genero, int duracion) {
        Nodo nuevaCancion = new Nodo(nombreCancion, artista, genero, duracion);
        if (cabeza == null) {
            cabeza = nuevaCancion;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevaCancion;
        }
    }

    // Método para imprimir la playlist completa
    public void imprimirPlaylist() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.println("Canción: " + actual.nombreCancion +
                    ", Artista: " + actual.artista +
                    ", Género: " + actual.genero +
                    ", Duración: " + actual.duracion + " segundos");
            actual = actual.siguiente;
        }
    }

    // Método para eliminar una canción de la playlist por su nombre
    public void eliminarCancion(String nombreCancion) {
        if (cabeza != null) {
            if (cabeza.nombreCancion.equals(nombreCancion)) {
                cabeza = cabeza.siguiente;
                return;
            }
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                if (actual.siguiente.nombreCancion.equals(nombreCancion)) {
                    actual.siguiente = actual.siguiente.siguiente;
                    return;
                }
                actual = actual.siguiente;
            }
        }
    }

    // Método para insertar una nueva canción en una posición específica de la playlist
    public void insertarCancion(String nombreCancion, String artista, String genero, int duracion, int posicion) {
        Nodo nuevaCancion = new Nodo(nombreCancion, artista, genero, duracion);
        if (posicion == 0) {
            nuevaCancion.siguiente = cabeza;
            cabeza = nuevaCancion;
        } else {
            Nodo actual = cabeza;
            for (int i = 0; i < posicion - 1 && actual != null; i++) {
                actual = actual.siguiente;
            }
            if (actual != null) {
                nuevaCancion.siguiente = actual.siguiente;
                actual.siguiente = nuevaCancion;
            }
        }
    }

    // Método para buscar una canción por su nombre y devolver su información
    public Nodo buscarCancion(String nombreCancion) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.nombreCancion.equals(nombreCancion)) {
                return actual;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    // Método auxiliar para intercambiar nodos en la lista
    private void intercambiar(Nodo nodo1, Nodo nodo2) {
        String tempNombre = nodo1.nombreCancion;
        String tempArtista = nodo1.artista;
        String tempGenero = nodo1.genero;
        int tempDuracion = nodo1.duracion;

        nodo1.nombreCancion = nodo2.nombreCancion;
        nodo1.artista = nodo2.artista;
        nodo1.genero = nodo2.genero;
        nodo1.duracion = nodo2.duracion;

        nodo2.nombreCancion = tempNombre;
        nodo2.artista = tempArtista;
        nodo2.genero = tempGenero;
        nodo2.duracion = tempDuracion;
    }

    // Método para ordenar la playlist por nombre de canción
    public void ordenarPorNombre() {
        if (cabeza == null || cabeza.siguiente == null) {
            return;
        }
        boolean intercambio;
        Nodo actual;
        Nodo siguiente = null;
        do {
            intercambio = false;
            actual = cabeza;
            while (actual.siguiente != siguiente) {
                if (actual.nombreCancion.compareTo(actual.siguiente.nombreCancion) > 0) {
                    intercambiar(actual, actual.siguiente);
                    intercambio = true;
                }
                actual = actual.siguiente;
            }
            siguiente = actual;
        } while (intercambio);
    }

}
