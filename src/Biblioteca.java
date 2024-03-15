import java.util.ArrayList;
import java.util.List;


public class Biblioteca {


    private List<Libro> libros;


    public Biblioteca() {
        this.libros = new ArrayList<>();
    }


    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }


    public Libro buscarLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equals(titulo)) {
                return libro;
            }
        }
        return null;
    }


    public void eliminarLibro(String titulo) {
        Libro libroEncontrado = buscarLibro(titulo);
        if (libroEncontrado != null) {
            libros.remove(libroEncontrado);
        }
    }


    public List<Libro> getLibros() {
        return libros;
    }


    public void prestarLibro(Libro libro, Usuario usuario) {
        if (!libro.isPrestado()) {
            libro.prestar(usuario);
            System.out.println("Libro prestado exitosamente a " + usuario.getNombre() + " " + usuario.getApellido());
        } else {
            System.out.println("El libro " + libro.getTitulo() + " ya está prestado.");
        }
    }


    public void devolverLibro(Libro libro) {
        if (libro.isPrestado()) {
            libro.devolver();
            System.out.println("Libro " + libro.getTitulo() + " devuelto exitosamente.");
        } else {
            System.out.println("El libro " + libro.getTitulo() + " no está prestado.");
        }
    }


    public List<Libro> librosPrestados() {
        List<Libro> librosPrestados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.isPrestado()) {
                librosPrestados.add(libro);
            }
        }
        return librosPrestados;
    }
}
