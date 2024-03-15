import java.util.List;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();


        // Opciones del menú
        int opcion;
        do {
            System.out.println("----- Sistema de gestión de biblioteca -----");
            System.out.println("1. Agregar libro");
            System.out.println("2. Buscar libro");
            System.out.println("3. Eliminar libro");
            System.out.println("4. Listar libros");
            System.out.println("5. Prestar libro");
            System.out.println("6. Devolver libro");
            System.out.println("7. Libros prestados");
            System.out.println("8. Salir");
            System.out.println("---------------------------------------");


            opcion = scanner.nextInt();


            switch (opcion) {
                case 1:
                    System.out.println("Introduzca el título del libro: ");
                    String titulo = scanner.next();
                    System.out.println("Introduzca el autor del libro: ");
                    String autor = scanner.next();
                    System.out.println("Introduzca el género del libro: ");
                    String genero = scanner.next();


                    biblioteca.agregarLibro(new Libro(titulo, autor, genero));
                    System.out.println("Libro agregado exitosamente!");
                    break;
                case 2:
                    System.out.println("Introduzca el título del libro a buscar: ");
                    String tituloABuscar = scanner.next();


                    Libro libroEncontrado = biblioteca.buscarLibro(tituloABuscar);
                    if (libroEncontrado != null) {
                        System.out.println("Libro encontrado:");
                        System.out.println(libroEncontrado);
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                    break;
                case 3:
                    System.out.println("Introduzca el título del libro a eliminar: ");
                    String tituloAEliminar = scanner.next();


                    biblioteca.eliminarLibro(tituloAEliminar);
                    System.out.println("Libro eliminado exitosamente!");
                    break;
                case 4:
                    System.out.println("----- Listado de libros -----");
                    for (Libro libro : biblioteca.getLibros()) {
                        System.out.println(libro);
                    }
                    break;
                case 5:
                    System.out.println("----- Prestar libro -----");
                    System.out.println("Introduzca el título del libro a prestar: ");
                    String tituloPrestar = scanner.next();
                    Libro libroAPrestar = biblioteca.buscarLibro(tituloPrestar);
                    if (libroAPrestar != null) {
                        System.out.println("Introduzca el nombre del usuario: ");
                        String nombreUsuario = scanner.next();
                        System.out.println("Introduzca el apellido del usuario: ");
                        String apellidoUsuario = scanner.next();
                        biblioteca.prestarLibro(libroAPrestar, new Usuario(nombreUsuario, apellidoUsuario));
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                    break;
                case 6:
                    System.out.println("----- Devolver libro -----");
                    System.out.println("Introduzca el título del libro a devolver: ");
                    String tituloDevolver = scanner.next();
                    Libro libroDevolver = biblioteca.buscarLibro(tituloDevolver);
                    if (libroDevolver != null) {
                        biblioteca.devolverLibro(libroDevolver);
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                    break;
                case 7:
                    System.out.println("----- Libros prestados -----");
                    List<Libro> librosPrestados = biblioteca.librosPrestados();
                    if (librosPrestados.isEmpty()) {
                        System.out.println("No hay libros prestados actualmente.");
                    } else {
                        for (Libro libro : librosPrestados) {
                            System.out.println(libro);
                        }
                    }
                    break;
                case 8:
                    System.out.println("¡Hasta la próxima!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 8);
    }
}
