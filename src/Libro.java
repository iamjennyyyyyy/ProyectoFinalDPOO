

import java.util.ArrayList;

public class Libro extends Publicacion {

	private ArrayList<String> autores;
	private String editorial;

	public ArrayList<String> getAutores() {
		return autores;
	}
	public void setAutores(String autor) {

		String errores = Validacion.validarCadena(autor, "nombre");

		if(errores.isEmpty())
			autores.add(autor);
		else throw new IllegalArgumentException(errores);
		
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
	
	public Libro(int id, String titulo, String materia, int numPaginas, int cantEjemplares, boolean estaPrestado, String autor, String editorial){
		super(id,titulo,materia,numPaginas,cantEjemplares,estaPrestado);
		
		setAutores(autor);
		setEditorial(editorial);
	}
	
	@Override
	public int tiempoMaximoPrestamo(){
		return (numPaginas/50) + 2*cantEjemplares;
	}

}
