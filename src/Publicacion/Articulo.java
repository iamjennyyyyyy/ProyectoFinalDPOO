package Publicacion;

import java.util.ArrayList;

public class Articulo extends Publicacion {

	private ArrayList<String> autores;
	private ArrayList<String> arbitros;
	
	public ArrayList<String> getAutores() {
		return autores;
	}
	public void setAutores(String autor) {

		String errores = Validacion.validarCadena(autor, "nombre");

		if(errores.isEmpty())
			autores.add(autor);
		else throw new IllegalArgumentException(errores);
		
	}
	
	public ArrayList<String> getArbitros() {
		return arbitros;
	}
	public void setArbitros(String arbitro) {

		String errores = Validacion.validarCadena(arbitro, "nombre");

		if(errores.isEmpty())
			arbitros.add(arbitro);
		else throw new IllegalArgumentException(errores);
		
	}
}
