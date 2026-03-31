package app;

import model.Juego;
import view.JuegoView;
import controller.JuegoController;

import java.util.List;

public class App {

    public static void main(String[] args) {

    	// diccionario provisorio para pruebas
        List<String> diccionario = List.of(
            "perro", "gatos", "nubes", "raton", "cielo"
        );

        Juego juego = new Juego(diccionario);
        JuegoView view = new JuegoView();
        JuegoController controller = new JuegoController(juego, view);

        controller.iniciar();
    }
}