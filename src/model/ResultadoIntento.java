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
    	
    	// resultado = lista de 5 elems
    	for (ResultadoLetra res : resultado) {
    		switch (res) {
    			case CORRECTA:	
    				sb.append("(VERDE) ");		// VERDE
    				break;
    			case PRESENTE:
    				sb.append("(AMARILLO) ");		// AMARILLO
    				break;
    			case AUSENTE:
    				sb.append("(GRIS) ");		// GRIS
    				break;
    		}
    	}
    	
    	return sb.toString();	// se convierte sb a String
    }

}