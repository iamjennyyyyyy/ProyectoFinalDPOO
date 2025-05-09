

import java.util.ArrayList;

public class Libro extends Publicacion {

	private ArrayList<String> autores;
	private String editorial;

	public ArrayList<String> getAutores() {
		return autores;
	}
	public void setAutores(ArrayList<String> autores) {

		if (autores == null) {
	        throw new IllegalArgumentException("La lista de autores no puede ser null");
	    }

	    ArrayList<String> autoresValidados = new ArrayList<String>(); // Lista temporal

	    for (String a : autores) {
	        String errores = Validacion.validarCadena(a, "nombre");
	        if (!errores.isEmpty()) {
	            throw new IllegalArgumentException(errores);
	        }
	        autoresValidados.add(a);
	    }

	    this.autores = autoresValidados;
	}
	
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {

		String errores = Validacion.validarCadena(editorial, "editorial");

		if(errores.isEmpty())
			this.editorial = editorial;
		else throw new IllegalArgumentException(errores);
	}

	public Libro(int id, String titulo, String materia, int numPaginas, int cantEjemplares, boolean estaPrestado, ArrayList<String> autores, String editorial){
		super(id,titulo,materia,numPaginas,cantEjemplares,estaPrestado);

		setAutores(autores);
		setEditorial(editorial);
	}

	@Override
	public int tiempoMaximoPrestamo(){
		return (numPaginas/50) + 2*cantEjemplares;
	}

}
