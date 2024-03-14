import java.util.ArrayList;
import java.util.HashMap;

public class Biblioteca {

    private HashMap<String, Libro> libros;
    private ArrayList<Prestamo> prestamos;

    public Biblioteca() {
        this.libros = new HashMap<>();
        this.prestamos = new ArrayList<>();
    }

    public void agregarLibro(String titulo, String autor, String genero) {
        Libro libro = new Libro(titulo, autor, genero);
        libros.put(titulo, libro);
    }

    public Libro buscarLibro(String titulo) {
        return libros.get(titulo);
    }

    public void eliminarLibro(String titulo) {
        libros.remove(titulo);
    }

    public void listarLibros() {
        for (Libro libro : libros.values()) {
            System.out.println(libro);
        }
    }

    public void prestarLibro(String titulo, String usuario) {
        Libro libro = buscarLibro(titulo);
        if (libro != null) {
            if (!libro.isPrestado()) {
                libro.setPrestado(true);
                prestamos.add(new Prestamo(libro, usuario));
                System.out.println("Libro prestado correctamente a " + usuario);
            } else {
                System.out.println("El libro ya está prestado");
            }
        } else {
            System.out.println("Libro no encontrado");
        }
    }

    public void devolverLibro(String titulo) {
        Libro libro = buscarLibro(titulo);
        if (libro != null) {
            if (libro.isPrestado()) {
                libro.setPrestado(false);
                for (Prestamo prestamo : prestamos) {
                    if (prestamo.getLibro().equals(libro)) {
                        prestamos.remove(prestamo);
                        System.out.println("Libro devuelto correctamente");
                        break;
                    }
                }
            } else {
                System.out.println("El libro no está prestado");
            }
        } else {
            System.out.println("Libro no encontrado");
        }
    }
}

