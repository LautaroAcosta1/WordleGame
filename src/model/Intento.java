package model;

import java.util.List;

public class Intento {

    private String palabra;
    private List<ResultadoLetra> resultado;

    public Intento(String palabra, List<ResultadoLetra> resultado) {
        this.palabra = palabra;
        this.resultado = resultado;
    }

    public String getPalabra() {
        return palabra;
    }

    public List<ResultadoLetra> getResultado() {
        return resultado;
    }
}