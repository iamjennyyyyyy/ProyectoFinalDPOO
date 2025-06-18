package Logica;


import java.util.ArrayList;

public class Libro extends Publicacion {

	private ArrayList<String> autores = new ArrayList<String>();
	private String editorial;

	public ArrayList<String> getAutores() {
		return autores;
	}
	public void setAutores(String nombre) {

		if (!(nombre.replaceAll(" ", "").equalsIgnoreCase("")) && !nombre.matches(".*\\d.*")) 
		{
			autores.add(nombre);
		}
		else throw new IllegalArgumentException("El nombre no es válido.");
	}
	
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		if (!(editorial.replaceAll(" ", "").equalsIgnoreCase("")) && !editorial.matches(".*\\d.*")) 
		{
			this.editorial = editorial;
		}
		else throw new IllegalArgumentException("El nombre no es válido.");
	}

	public Libro(String id, String titulo, String materia, int numPaginas, int cantEjemplares, boolean estaPrestado, String autor, String editorial){
		super(id,titulo,materia,numPaginas,cantEjemplares,estaPrestado);

		setAutores(autor);
		setEditorial(editorial);
	}

	@Override
	public int tiempoMaximoPrestamo(){
		return (numPaginas/50) + 2*cantEjemplares;
	}

}
