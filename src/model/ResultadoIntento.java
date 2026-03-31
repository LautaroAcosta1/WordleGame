package model;

import java.util.List;

public class ResultadoIntento {

    private List<ResultadoLetra> resultado;

    public ResultadoIntento(List<ResultadoLetra> resultado) {
        this.resultado = resultado;
    }

    public List<ResultadoLetra> getResultado() {
        return resultado;
    }

    // AGREGAR TO STRING PARA REPRESENTAR EL RESULTADO DE
    // LAS PALABRAS INGRESADAS (AMARILLO, GRIS, VERDE)
}