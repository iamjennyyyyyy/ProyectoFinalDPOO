package Logica;
import java.util.ArrayList;

public class Articulo extends Publicacion {

	private ArrayList<String> autores;
	private ArrayList<String> arbitros;
	
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
	
	public ArrayList<String> getArbitros() {
		return arbitros;
	}
	public void setArbitros(ArrayList<String> arbitros) {

		if (arbitros == null) {
	        throw new IllegalArgumentException("La lista de arbitros no puede ser null");
	    }

	    ArrayList<String> arbitrosValidados = new ArrayList<String>(); // Lista temporal

	    for (String a : arbitros) {
	        String errores = Validacion.validarCadena(a, "nombre del arbitro");
	        if (!errores.isEmpty()) {
	            throw new IllegalArgumentException(errores);
	        }
	        arbitrosValidados.add(a);
	    }

	    this.arbitros = arbitrosValidados;
	}
	
	public Articulo(int id, String titulo, String materia, int numPaginas, int cantEjemplares, boolean estaPrestado, ArrayList<String> autores, ArrayList<String> arbitros) {
		super(id, titulo, materia, numPaginas, cantEjemplares, estaPrestado);
		
		setAutores(autores);
		setArbitros(arbitros);
	}
	
	@Override
	public int tiempoMaximoPrestamo(){
		return (numPaginas/30)+cantEjemplares;
	}
}
