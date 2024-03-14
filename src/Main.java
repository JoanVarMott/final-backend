import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Biblioteca biblioteca = new Biblioteca();

        // Menú principal
        while (true) {
            int opcion = mostrarMenu();
            switch (opcion) {
                case 1:
                    // Agregar libro
                    System.out.println("Ingrese el título del libro: ");
                    String titulo = scanner.nextLine();
                    System.out.println("Ingrese el autor del libro: ");
                    String autor = scanner.nextLine();
                    System.out.println("Ingrese el género del libro: ");
                    String genero = scanner.nextLine();
                    biblioteca.agregarLibro(titulo, autor, genero);
                    System.out.println("Libro agregado correctamente");
                    break;
                case 2:
                    // Buscar libro
                    System.out.println("Ingrese el título del libro a buscar: ");
                    String tituloBuscar = scanner.nextLine();
                    Libro libroEncontrado = biblioteca.buscarLibro(tituloBuscar);
                    if (libroEncontrado != null) {
                        System.out.println("Libro encontrado:");
                        System.out.println(libroEncontrado);
                    } else {
                        System.out.println("Libro no encontrado");
                    }
                    break;
                case 3:
                    // Eliminar libro
                    System.out.println("Ingrese el título del libro a eliminar: ");
                    String tituloEliminar = scanner.nextLine();
                    biblioteca.eliminarLibro(tituloEliminar);
                    System.out.println("Libro eliminado correctamente");
                    break;
                case 4:
                    // Listar libros
                    biblioteca.listarLibros();
                    break;
                case 5:
                    // Prestar libro
                    System.out.println("Ingrese el título del libro a prestar: ");
                    String tituloPrestar = scanner.nextLine();
                    System.out.println("Ingrese el nombre del usuario: ");
                    String usuarioPrestar = scanner.nextLine();
                    biblioteca.prestarLibro(tituloPrestar, usuarioPrestar);
                    break;
                case 6:
                    // Devolver libro
                    System.out.println("Ingrese el título del libro a devolver: ");
                    String tituloDevolver = scanner.nextLine();
                    biblioteca.devolverLibro(tituloDevolver);
                    break;
                case 0:
                    // Salir del programa
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Ingrese una opción del 1 al 6 o 0 para salir.");
            }
        }
    }

    private static int mostrarMenu() {
        System.out.println("\n**Sistema de gestión de biblioteca**");
        System.out.println("---------------------------------");
        System.out.println("1. Agregar libro");
        System.out.println("2. Buscar libro");
        System.out.println("3. Eliminar libro");
        System.out.println("4. Listar libros");
        System.out.println("5. Prestar libro");
        System.out.println("6. Devolver libro");
        System.out.println("0. Salir");
        System.out.println("---------------------------------");
        System.out.print("Ingrese una opción: ");

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
