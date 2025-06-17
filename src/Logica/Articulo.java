package Logica;
import java.util.ArrayList;

public class Articulo extends Publicacion {

	private ArrayList<String> autores = new ArrayList<String>();
	private ArrayList<String> arbitros = new ArrayList<String>();

	public ArrayList<String> getAutores() {
		return autores;
	}
	public void agregarAutor(String nombre){
		if (!(nombre.replaceAll(" ", "").equalsIgnoreCase("")) && !nombre.matches(".*\\d.*")) 
		{
			autores.add(nombre);
		}
		else throw new IllegalArgumentException("El nombre no es válido.");
	}

	public ArrayList<String> getArbitros() {
		return arbitros;
	}
	public void agregarArbitro(String nombre){
		if (!(nombre.replaceAll(" ", "").equalsIgnoreCase("")) && !nombre.matches(".*\\d.*")) 
		{
			arbitros.add(nombre);
		}
		else throw new IllegalArgumentException("El nombre no es válido.");
	}

	public Articulo(String id, String titulo, String materia, int numPaginas, int cantEjemplares, boolean estaPrestado, String autor, String arbitro) {
		super(id, titulo, materia, numPaginas, cantEjemplares, estaPrestado);

		agregarAutor(autor);
		agregarArbitro(arbitro);
	}

	@Override
	public int tiempoMaximoPrestamo(){
		return (numPaginas/30)+cantEjemplares;
	}
}
