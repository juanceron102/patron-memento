package main;

import caretaker.Historial;
import originator.Editor;

public class Main {

    public static void main(String[] args) {
        Editor editor = new Editor();
        Historial historial = new Historial();

        System.out.println("=== Editor de texto con historial (Patrón Memento) ===\n");

        // Estado 1
        editor.setContenido("Hola");
        mostrar("Estado 1", editor);

        guardar(editor, historial);

        // Estado 2
        editor.setContenido("Hola, mundo");
        mostrar("Estado 2", editor);

        guardar(editor, historial);

        // Estado 3 (cambio que no se desea conservar)
        editor.setContenido("Hola, mundo. Este texto fue modificado.");
        mostrar("Estado 3", editor);

        restaurar(editor, historial);
        mostrar("Después de restaurar", editor);

        // Nueva modificación después de restaurar
        editor.setContenido("Hola, mundo. Nueva versión del documento.");
        mostrar("Nueva modificación", editor);

        restaurar(editor, historial);
        mostrar("Después de restaurar", editor);

        // El historial ya está vacío: no se intenta restaurar
        restaurar(editor, historial);
        mostrar("Contenido final", editor);
    }

    private static void guardar(Editor editor, Historial historial) {
        historial.guardarEstado(editor.guardar());
        System.out.println("  -> Se guarda el estado. (estados guardados: "
                + historial.cantidadEstados() + ")\n");
    }

    private static void restaurar(Editor editor, Historial historial) {
        if (!historial.hayEstados()) {
            System.out.println("  -> No hay estados guardados para restaurar.\n");
            return;
        }
        editor.restaurar(historial.obtenerUltimoEstado());
        System.out.println("  -> Se restaura el último estado guardado. (estados restantes: "
                + historial.cantidadEstados() + ")\n");
    }

    private static void mostrar(String etiqueta, Editor editor) {
        System.out.println(etiqueta + " - Contenido actual:");
        System.out.println("  \"" + editor.getContenido() + "\"\n");
    }
}
