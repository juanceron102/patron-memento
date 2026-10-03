package originator;

import memento.Memento;


public class Editor {

    private String contenido = "";

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getContenido() {
        return contenido;
    }

    public Memento guardar() {
        return new Memento(contenido);
    }

    public void restaurar(Memento memento) {
        if (memento == null) {
            throw new IllegalArgumentException("No hay un estado válido para restaurar.");
        }
        this.contenido = memento.getContenido();
    }
}
