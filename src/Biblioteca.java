import java.time.LocalDate;
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
	private ArrayList<Trabajador> trabajadores = new ArrayList<Trabajador>();
	private ArrayList<UsuarioAcreditado> usuarios = new ArrayList<UsuarioAcreditado>();
	private ArrayList<Libro> libros = new ArrayList<Libro>();
	private ArrayList<Revista> revistas = new ArrayList<Revista>();
	private ArrayList<Articulo> articulos = new ArrayList<Articulo>();
	private ArrayList<Prestamo> prestamosTotales = new ArrayList<Prestamo>();

	public Biblioteca(int id, String nombre, String provincia,
			String municipio, String horario, String nombreCompletoAdmin,
			int annosEnCargo, ArrayList<Trabajador> trabajadores,
			ArrayList<UsuarioAcreditado> usuarios, ArrayList<Libro> libros,
			ArrayList<Revista> revistas, ArrayList<Articulo> articulos,
			ArrayList<Prestamo> prestamosTotales) {

		this.id = id;
		this.nombre = nombre;
		this.provincia = provincia;
		this.municipio = municipio;
		this.horario = horario;
		this.nombreCompletoAdmin = nombreCompletoAdmin;
		this.annosEnCargo = annosEnCargo;
		this.trabajadores = trabajadores;
		this.usuarios = usuarios;
		this.libros = libros;
		this.revistas = revistas;
		this.articulos = articulos;
		this.prestamosTotales = prestamosTotales;
	}

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

	public ArrayList<Trabajador> getTrabajadores() {
		return trabajadores;
	}

	public void setTrabajadores(ArrayList<Trabajador> trabajadores) {
		this.trabajadores = trabajadores;
	}

	public ArrayList<UsuarioAcreditado> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<UsuarioAcreditado> usuarios) {
		this.usuarios = usuarios;
	}

	public ArrayList<Prestamo> getPrestamosTotales() {
		return prestamosTotales;
	}

	public void setPrestamosTotales(ArrayList<Prestamo> prestamosTotales) {
		this.prestamosTotales = prestamosTotales;
	}

	//Metodo para realizar o no el prestamo
	public boolean solicitarPrestamo(int id, Publicacion pub, Trabajador trabajador){

		if (pub == null || trabajador == null) {
			throw new IllegalArgumentException("Publicacion o trabajador no pueden ser null");
		}

		UsuarioAcreditado user = buscarUsuarioPorId(id);
		if (user == null) {
			throw new IllegalArgumentException("Usuario no encontrado.");
		}

		boolean prestamoRealizado = false;

		for(Prestamo p : user.getPrestamos()){
			if(p.getPub().equals(pub) && p.getFechaDevolucion() != null && 
					p.getFechaDevolucion().plusDays(14).isAfter(LocalDate.now())){
				throw new IllegalArgumentException("No han transcurrido dos semanas desde la última devolucion.");
			}
		}
		if(pub.getCantEjemplares() > 2){
			if(user.getPrestamos().size() < 3){
				pub.disminuirStock();
				LocalDateTime fechaActual = LocalDateTime.now();
				int tiempo = pub.tiempoMaximoPrestamo();
				LocalDateTime fechaDevolucion = fechaActual.plusDays(tiempo);
				Prestamo p = new Prestamo(fechaActual,fechaDevolucion,pub,user,trabajador);
				user.getPrestamos().add(p);
				prestamosTotales.add(p);
				prestamoRealizado = true;
			}
			else
				throw new IllegalArgumentException("El usuario tiene ya 3 prestamos.");
		}
		else
			throw new IllegalArgumentException("Publicacion no disponible.");
	return prestamoRealizado;
}

public void devolverPublicacion(int id, Publicacion pub){

	UsuarioAcreditado user = buscarUsuarioPorId(id);

	if(user != null){
		for(Prestamo p : user.getPrestamos()){
			if(p.getPub().equals(pub)){
				LocalDate fechaActual = LocalDate.now();
				p.setFechaDevolucion(fechaActual);
				prestamosTotales.add(p);
				user.getPrestamos().remove(p);
			}
		}
	}
}

public UsuarioAcreditado buscarUsuarioPorId(int id){
	UsuarioAcreditado usuario = null;

	if (usuarios == null) {
		throw new IllegalStateException("Lista de usuarios no inicializada");
	}
	for (UsuarioAcreditado user : usuarios){
			if(user != null && user.getId() == id)
				usuario = user;
		}
	return usuario;
}

public Prestamo buscarPrestamoPorPublicacion(Publicacion pub){

	for (Prestamo p : prestamosTotales){
		if(p.getPub().equals(pub))
			return p;
	}
	return null;
}

public boolean realizarProrroga(int id, Publicacion pub){
	boolean realizada = false;
	UsuarioAcreditado user = buscarUsuarioPorId(id);
	if(user != null){
		Prestamo p = buscarPrestamoPorPublicacion(pub);
		if(p != null && p.getUser().equals(user)){
			p.concederProrroga();
			realizada = true;
		}
	}
	return realizada;
}
}
