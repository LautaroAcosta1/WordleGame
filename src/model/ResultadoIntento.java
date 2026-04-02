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

    @Override
    public String toString( ) {
    	StringBuilder sb = new StringBuilder();
    	
    	for (ResultadoLetra res : resultado) {
    		switch (res) {
    			case CORRECTA:	
    				sb.append("(VERDE)");		// VERDE
    				break;
    			case PRESENTE:
    				sb.append("(AMARILLO)");		// AMARILLO
    				break;
    			case AUSENTE:
    				sb.append("(GRIS)");		// GRIS
    				break;
    		}
    	}
    	
    	return sb.toString();
    }
    // AGREGAR TO STRING PARA REPRESENTAR EL RESULTADO DE
    // LAS PALABRAS INGRESADAS (AMARILLO, GRIS, VERDE)
}