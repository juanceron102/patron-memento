package memento;


public final class Memento {

    private final String contenido;

    public Memento(String contenido) {
        this.contenido = contenido;
    }

    public String getContenido() {
        return contenido;
    }
}
