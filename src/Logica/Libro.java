package Logica;


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
	    this.autores = autores;
	}
	
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
			this.editorial = editorial;
	}

	public Libro(String id, String titulo, String materia, int numPaginas, int cantEjemplares, boolean estaPrestado, ArrayList<String> autores, String editorial){
		super(id,titulo,materia,numPaginas,cantEjemplares,estaPrestado);

		setAutores(autores);
		setEditorial(editorial);
	}

	@Override
	public int tiempoMaximoPrestamo(){
		return (numPaginas/50) + 2*cantEjemplares;
	}

}
