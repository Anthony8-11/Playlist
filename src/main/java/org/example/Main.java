package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Playlist playlist = new Playlist();
        // Agregar canciones a la playlist
        playlist.agregarCancion("Pancita", "Manolo", "Salsa", 200);
        playlist.agregarCancion("Manita", "El chiquito", "Bachata", 180);
        playlist.agregarCancion("Pie", "Bad Horse", "Jazz", 220);
        playlist.agregarCancion("Brazo", "Tito", "Pop", 240);
        playlist.agregarCancion("El bote", "El capo", "Pop", 260);
        playlist.agregarCancion("El mar", "Manfredo", "Salsa", 280);
        playlist.agregarCancion("El carro", "Doble A", "Cumbia", 300);
        playlist.agregarCancion("La otra", "Triple O", "Corrido", 320);
        playlist.agregarCancion("El hombre", "El H", "Banda", 340);
        playlist.agregarCancion("La mujer", "Don Arturo", "Merengue", 360);
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n--- Menú de Playlist ---");
            System.out.println("1. Agregar Canción");
            System.out.println("2. Mostrar Playlist");
            System.out.println("3. Eliminar Canción");
            System.out.println("4. Insertar Canción");
            System.out.println("5. Buscar Canción");
            System.out.println("6. Ordenar Playlist por Nombre");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            // Procesar la opción seleccionada por el usuario
            switch (opcion) {
                case 1:
                    System.out.print("Nombre de la canción: ");
                    String nombreCancion = scanner.nextLine();
                    System.out.print("Artista: ");
                    String artista = scanner.nextLine();
                    System.out.print("Género: ");
                    String genero = scanner.nextLine();
                    System.out.print("Duración (en segundos): ");
                    int duracion = scanner.nextInt();
                    playlist.agregarCancion(nombreCancion, artista, genero, duracion);
                    break;
                case 2:
                    System.out.println("Playlist completa:");
                    playlist.imprimirPlaylist();
                    break;
                case 3:
                    System.out.print("Ingrese el nombre de la canción a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    playlist.eliminarCancion(nombreEliminar);
                    break;
                case 4:
                    System.out.print("Nombre de la canción a insertar: ");
                    String nombreInsertar = scanner.nextLine();
                    System.out.print("Artista: ");
                    String artistaInsertar = scanner.nextLine();
                    System.out.print("Género: ");
                    String generoInsertar = scanner.nextLine();
                    System.out.print("Duración (en segundos): ");
                    int duracionInsertar = scanner.nextInt();
                    System.out.print("Posición de inserción: ");
                    int posicionInsertar = scanner.nextInt();
                    playlist.insertarCancion(nombreInsertar, artistaInsertar, generoInsertar, duracionInsertar, posicionInsertar);
                    break;
                case 5:
                    System.out.print("Nombre de la canción a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    Nodo cancionBuscada = playlist.buscarCancion(nombreBuscar);
                    if (cancionBuscada != null) {
                        System.out.println("Información de la canción:");
                        System.out.println("Artista: " + cancionBuscada.artista +
                                ", Género: " + cancionBuscada.genero +
                                ", Duración: " + cancionBuscada.duracion + " segundos");
                    } else {
                        System.out.println("La canción no se encontró en la playlist.");
                    }
                    break;
                case 6:
                    playlist.ordenarPorNombre();
                    System.out.println("Playlist ordenada por nombre de canción:");
                    playlist.imprimirPlaylist();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 0);

        scanner.close(); // Cerrar el scanner al finalizar
    }
    }
