package caretaker;
import java.util.Stack;
import memento.Memento;

public class Historial {

    private final Stack<Memento> estados = new Stack<>();

    public void guardarEstado(Memento memento) {
        estados.push(memento);
    }

    public Memento obtenerUltimoEstado() {
        return estados.isEmpty() ? null : estados.pop();
    }

    public boolean hayEstados() {
        return !estados.isEmpty();
    }

    public int cantidadEstados() {
        return estados.size();
    }
}
