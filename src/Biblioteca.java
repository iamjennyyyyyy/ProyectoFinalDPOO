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
	private ArrayList<Trabajador> trabajadores;
	private ArrayList<UsuarioAcreditado> usuarios;
	private ArrayList<Libro> libros;
	private ArrayList<Revista> revistas;
	private ArrayList<Articulo> articulos;
	private ArrayList<Prestamo> prestamosTotales;

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
		trabajadores = new ArrayList<Trabajador>();
		usuarios = new ArrayList<UsuarioAcreditado>();
		libros = new ArrayList<Libro>();
		revistas = new ArrayList<Revista>();
		articulos = new ArrayList<Articulo>();
		prestamosTotales = new ArrayList<Prestamo>();
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

	//Metodo para realizar o no el prestamo
	public boolean solicitarPrestamo(int id, Publicacion pub, Trabajador trabajador){

		UsuarioAcreditado user = buscarUsuarioPorId(id);

		boolean esUsuario = user != null? true : false;
		boolean dosSemanasTranscurridas = true;
		boolean prestamoRealizado = false;

		if(esUsuario){

			for(Prestamo p : user.getPrestamos()){
				if(p.getPub().equals(pub)){
					if(p.getFechaDevolucion() != null && !p.getFechaDevolucion().plusDays(14).isAfter(LocalDate.now()))
						dosSemanasTranscurridas = false;
				}
			}
			if(dosSemanasTranscurridas){
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
			}
			else
				throw new IllegalArgumentException("No han transcurrido dos semanas de su devolucion de esta publicacion.");
		}
		else
			throw new IllegalArgumentException("Usuario no encontrado.");

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
		for (UsuarioAcreditado user : usuarios){
			if(user.getId() == id)
				usuario = user;
		}
		return usuario;
	}
}
