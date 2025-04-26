import java.time.LocalDateTime;
import java.util.ArrayList;

public class Biblioteca {

	private int id;
	private String nombre;
	private String provincia;
	private String municipio;
	private String horario;
	private String nombreCompletoAdmin;
	private int annosEnCargo;
	private ArrayList<UsuarioAcreditado> usuarios = new ArrayList<UsuarioAcreditado>();
	private ArrayList<Libro> libros = new ArrayList<Libro>();
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
	public int getAnnosEnCargo() {
		return annosEnCargo;
	}
	public void setAnnosEnCargo(int annosEnCargo) {
		this.annosEnCargo = annosEnCargo;
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

	//Metodo para realizar o no el prestamo
	public boolean solicitarPrestamo(int id, Publicacion pub){

		UsuarioAcreditado user = buscarUsuarioPorId(id);

		boolean esUsuario = user != null? true : false;

		boolean prestamoRealizado = false;

		if(esUsuario){
			if(pub.getCantEjemplares() > 2){
				if(user.getPrestamos().size() < 3){
					pub.disminuirStock();
					LocalDateTime fechaActual = LocalDateTime.now();
					int tiempo = pub.tiempoMaximoPrestamo();
					LocalDateTime fechaDevolucion = fechaActual.plusDays(tiempo);
					user.setPrestamos(new Prestamo(fechaActual,fechaDevolucion,pub,user,nombreCompletoAdmin));
					prestamoRealizado = true;
				}
				else
					throw new IllegalArgumentException("El usuario tiene ya 3 prestamos.");
			}
			else
				throw new IllegalArgumentException("Publicacion no disponible.");
		}
		else
			throw new IllegalArgumentException("Usuario no encontrado.");

		return prestamoRealizado;
	}

	public UsuarioAcreditado buscarUsuarioPorId(int id){

		UsuarioAcreditado usuario = null;
		for (UsuarioAcreditado user : usuarios){
			if(user.getId() == id)
				usuario = user;
		}
		return usuario;
	}
}
