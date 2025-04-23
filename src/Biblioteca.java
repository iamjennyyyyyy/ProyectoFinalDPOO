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
	private int annosEnCargo;
	private ArrayList<Libro> libros = new ArrayList<Libro>(); // no se incializan aca
	private ArrayList<Revista> revistas = new ArrayList<Revista>();
	private ArrayList<Articulo> articulos = new ArrayList<Articulo>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getNombreCompletoAdmin() {
		return nombreCompletoAdmin;
	}
	public void setNombreCompletoAdmin(String nombreCompletoAdmin) {
		this.nombreCompletoAdmin = nombreCompletoAdmin;
	}
	public ArrayList<Libro> getLibros() {
		return libros;
	}
	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}
	public ArrayList<Revista> getRevistas() {
		return revistas;
	}
	public void setRevistas(ArrayList<Revista> revistas) {
		this.revistas = revistas;
	}
	public ArrayList<Articulo> getArticulos() {
		return articulos;
	}
	public void setArticulos(ArrayList<Articulo> articulos) {
		this.articulos = articulos;
	}
     public int getAnnosEnCargo() {
          return annosEnCargo;
     }
     public void setAnnosEnCargo(int annosEnCargo) {
          this.annosEnCargo = annosEnCargo;
     }

	
}
