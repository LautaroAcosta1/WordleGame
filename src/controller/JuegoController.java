package controller;

import model.Juego;
import model.ResultadoIntento;
import view.JuegoView;

public class JuegoController {

    private Juego juego;
    private JuegoView view;

    public JuegoController(Juego juego, JuegoView view) {
        this.juego = juego;
        this.view = view;
        view.setController(this);
    }

    public void iniciar() {
        view.mostrar();
    }

    public void ingresar(String palabra) {
        try {
        	
        	// COMPLETAR CON CONDICIONAL QUE MUESTRE MENSAJES SI GANO O PERDIO

        } catch (Exception e) {
            view.mostrarMensaje(e.getMessage());
        }
    }
}