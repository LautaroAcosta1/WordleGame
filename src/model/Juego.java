package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Juego {

    private String palabraSecreta;
    private int intentosRestantes;
    private List<Intento> intentos;
    private final int MAX_INTENTOS = 6;

    private List<String> diccionario;
    private boolean juegoTerminado;

    public Juego(List<String> diccionario) {
        this.diccionario = diccionario;
        this.palabraSecreta = elegirPalabraAleatoria();
        this.intentosRestantes = MAX_INTENTOS;
        this.intentos = new ArrayList<>();
        this.juegoTerminado = false;
    }

    private String elegirPalabraAleatoria() {
        Random rand = new Random();
        // COMPLETAR
    }

    public ResultadoIntento ingresar(String palabra) {
        //validarEstadoJuego();
        //validarPalabra(palabra);

        List<ResultadoLetra> resultado = evaluarPalabra(palabra);

        Intento intento = new Intento(palabra, resultado);
        intentos.add(intento);
        intentosRestantes--;

        if (palabra.equals(palabraSecreta) || intentosRestantes == 0) {
            juegoTerminado = true;
        }

        return new ResultadoIntento(resultado);
    }

    private void validarEstadoJuego() {

    	// COMPLETAR (necesario para ResultadoIntento)
    	
    }

    private void validarPalabra(String palabra) {
    	
    	// COMPLETAR (necesario para ResultadoIntento)
    	
    }

    // maneja letras repetidas
    private List<ResultadoLetra> evaluarPalabra(String palabra) {

        List<ResultadoLetra> resultado = new ArrayList<>();
        for (int i = 0; i < palabra.length(); i++) {
            resultado.add(null); // inicializa
        }

        char[] secreta = palabraSecreta.toCharArray();
        char[] intento = palabra.toCharArray();

        boolean[] usados = new boolean[5];

        // primera pasada: letras correctas
        for (int i = 0; i < 5; i++) {
            if (intento[i] == secreta[i]) {
                resultado.set(i, ResultadoLetra.CORRECTA);
                usados[i] = true;
            }
        }

        // Segunda pasada: letras presentes/ausenctes
        for (int i = 0; i < 5; i++) {

            if (resultado.get(i) == null) {

                boolean encontrada = false;

                for (int j = 0; j < 5; j++) {
                    if (!usados[j] && intento[i] == secreta[j]) {
                        encontrada = true;
                        usados[j] = true;
                        break;
                    }
                }

                if (encontrada) {
                    resultado.set(i, ResultadoLetra.PRESENTE);
                } else {
                    resultado.set(i, ResultadoLetra.AUSENTE);
                }
            }
        }

        return resultado;
    }

    public boolean gano() {
        if (intentos.isEmpty()) return false;

        Intento ultimo = intentos.get(intentos.size() - 1);
        return ultimo.getPalabra().equals(palabraSecreta);
    }

    public boolean perdio() {
        return juegoTerminado && !gano();
    }

    public int getIntentosRestantes() {
        return intentosRestantes;
    }

    public List<Intento> getIntentos() {
        return new ArrayList<>(intentos);
    }

    public String getPalabraSecreta() {
        if (!juegoTerminado) {
            throw new IllegalStateException("El juego tofavia no termino");
        }
        return palabraSecreta;
    }
}