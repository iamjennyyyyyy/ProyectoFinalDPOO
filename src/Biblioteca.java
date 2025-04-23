import java.util.ArrayList;

import Publicacion.Articulo;
import Publicacion.Libro;
import Publicacion.Revista;


public class Biblioteca {

	private int id;
	private String nombre;
	private String provincia;
	private String municipio;
	private String horario;
	private String nombreCompletoAdmin;
	private int añosEnCargo;
	private ArrayList<Libro> libros = new ArrayList<Libro>();
	private ArrayList<Revista> revistas = new ArrayList<Revista>();
	private ArrayList<Articulo> articulos = new ArrayList<Articulo>();
}
