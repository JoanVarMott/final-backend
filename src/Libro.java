public class Libro {


    private String titulo;
    private String autor;
    private String genero;
    private boolean prestado;
    private Usuario usuarioPrestado;


    public Libro(String titulo, String autor, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.prestado = false;
        this.usuarioPrestado = null;
    }


    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getAutor() {
        return autor;
    }


    public void setAutor(String autor) {
        this.autor = autor;
    }


    public String getGenero() {
        return genero;
    }


    public void setGenero(String genero) {
        this.genero = genero;
    }


    public boolean isPrestado() {
        return prestado;
    }


    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }


    public Usuario getUsuarioPrestado() {
        return usuarioPrestado;
    }


    public void setUsuarioPrestado(Usuario usuarioPrestado) {
        this.usuarioPrestado = usuarioPrestado;
    }


    public void prestar(Usuario usuario) {
        this.prestado = true;
        this.usuarioPrestado = usuario;
    }


    public void devolver() {
        this.prestado = false;
        this.usuarioPrestado = null;
    }


    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                ", prestado=" + prestado +
                ", usuarioPrestado=" + usuarioPrestado +
                '}';
    }
}
