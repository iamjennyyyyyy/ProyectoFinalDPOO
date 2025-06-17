package Logica;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import Visual.Login;

public class Biblioteca {

	private static Biblioteca unicaInstancia;
	private int id;
	private String nombre;
	private String provincia;
	private String municipio;
	private String horario;
	private static Trabajador admin = Login.obtenerAdmin();
	private int annosEnCargo;
	private ArrayList<Trabajador> trabajadores;
	private ArrayList<UsuarioAcreditado> usuarios;
	private ArrayList<Libro> libros;
	private ArrayList<Revista> revistas;
	private ArrayList<Articulo> articulos;
	private ArrayList<Publicacion> publicaciones;
	private static ArrayList<Prestamo> prestamosTotales;


	private Biblioteca(int id, String nombre, String provincia,
			String municipio, String horario, Trabajador admin,
			int annosEnCargo) {

		this.id = id;
		this.nombre = nombre;
		this.provincia = provincia;
		this.municipio = municipio;
		this.horario = horario;
		this.annosEnCargo = annosEnCargo;
		trabajadores = new ArrayList<Trabajador>();
		usuarios = new ArrayList<UsuarioAcreditado>();
		libros = new ArrayList<Libro>();
		revistas = new ArrayList<Revista>();
		articulos = new ArrayList<Articulo>();
		publicaciones = new ArrayList<Publicacion>();
		prestamosTotales = new ArrayList<Prestamo>();
	}

	public static Biblioteca getInstancia() {
		if (unicaInstancia == null) {
			unicaInstancia = new Biblioteca(
					1,
					"Biblioteca Municipal Central",
					"La Habana",
					"La Habana",
					"09:00-21:00 L-V, 10:00-14:00 S",
					Login.obtenerAdmin(),
					5
					);
		}
		return unicaInstancia;
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
	public Trabajador getAdmin() {
		return admin;
	}
	public int getAnnosEnCargo() {
		return annosEnCargo;
	}
	public void setAnnosEnCargo(int annosEnCargo) {
		this.annosEnCargo = annosEnCargo;
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

	public ArrayList<Publicacion> getPublicaciones() {
		return publicaciones;
	}

	public void setPrestamosTotales(ArrayList<Prestamo> prestamosTotales) {
		this.prestamosTotales = prestamosTotales;
	}

	//Metodo para realizar o no el prestamo
	public Prestamo solicitarPrestamo(UsuarioAcreditado user, Publicacion pub, Trabajador trabajador) throws IllegalArgumentException {
		Prestamo prestamoNuevo = null;

		for(Prestamo p : user.getPrestamos()){
			if(p.getPub().equals(pub) && p.getFechaDevolucion() != null && 
					p.getFechaDevolucion().plusDays(14).isAfter(LocalDate.now())){
				throw new IllegalArgumentException("No han transcurrido dos semanas desde la �ltima devolucion.");
			}
		}
		if(pub.getCantEjemplares() >= 3){
			if(user.getPrestamos().size() < 3){
				pub.disminuirStock();
				LocalDate fechaActual = LocalDate.now();
				int tiempo = pub.tiempoMaximoPrestamo();
				LocalDate fechaDevolucion = fechaActual.plusDays(tiempo);
				prestamoNuevo = new Prestamo(fechaActual, fechaDevolucion, pub, user, trabajador);
				user.getPrestamos().add(prestamoNuevo);
				prestamosTotales.add(prestamoNuevo);
			}
			else 
				throw new IllegalArgumentException("Usuario ya tiene m�s de 3 pr�stamos actualmente");
		}
		else 
			throw new IllegalArgumentException("La cantidad de ejemplares es m�nima");
		
		return prestamoNuevo;
	}

	public void devolverPublicacion(String id, Publicacion pub){

		UsuarioAcreditado user = buscarUsuarioPorId(id);
		if(user != null){
			Prestamo prestamo = buscarPrestamoPorPublicacion(user, pub);
			if(prestamo != null){
				prestamo.setFechaDevolucion(LocalDate.now());
				user.getPrestamos().remove(prestamo);
			}
		}
	}

	public void eliminarUsuario(UsuarioAcreditado u){
		usuarios.remove(u);
	}

	public UsuarioAcreditado buscarUsuarioPorId(String id){
		UsuarioAcreditado usuario = null;

		for (UsuarioAcreditado user : usuarios){
			if(user != null && user.getId().equals(id))
				usuario = user;
		}
		return usuario;
	}

	public Publicacion buscarPublicacionPorId(String id){

		Publicacion pub = null;

		if (libros == null)
			throw new IllegalStateException("Lista de libros no inicializada");
		else if (revistas == null)
			throw new IllegalStateException("Lista de revistas no inicializada");
		else if (articulos == null)
			throw new IllegalStateException("Lista de articulos no inicializada");

		for (Libro l : libros){
			if(l != null && l.getId().equals(id))
				pub = l;
		}
		for (Revista r : revistas){
			if(r != null && r.getId().equals(id))
				pub = r;
		}
		for (Articulo a : articulos){
			if(a != null && a.getId().equals(id))
				pub = a;
		}
		return pub;
	}

	public ArrayList<MateriaConCantidadSolicitudes> guardarMateriasMasSolicitadas(){

		ArrayList<MateriaConCantidadSolicitudes> materias = new ArrayList<MateriaConCantidadSolicitudes>(); // materia y cant

		String[] materiasNombres = {"Literatura",
				"Literatura Fant�stica",
				"Ciencias Naturales",
				"Tecnolog�a",
				"Ciencias Exactas",
				"Divulgaci�n Cient�fica",
				"Ciencias Sociales",
				"Historia",
				"Econom�a",
				"Actualidad",};

		int[] contadores = {0,0,0,0,0,0,0,0,0,0};

		for(Prestamo p : prestamosTotales){
			if(p.getPub().getMateria().equals(materiasNombres[0])){ //Literatura
				contadores[0]++;
			}
			else if(p.getPub().getMateria().equals(materiasNombres[1])){ //Literatura Fant�stica
				contadores[1]++;
			}
			else if(p.getPub().getMateria().equals(materiasNombres[2])){ //Ciencias Naturales
				contadores[2]++;
			}
			else if(p.getPub().getMateria().equals(materiasNombres[3])){ //Tecnolog�a
				contadores[3]++;
			}
			else if(p.getPub().getMateria().equals(materiasNombres[4])){ //Ciencias Exactas
				contadores[4]++;
			}
			else if(p.getPub().getMateria().equals(materiasNombres[5])){ //Divulgaci�n Cient�fica
				contadores[5]++;
			}
			else if(p.getPub().getMateria().equals(materiasNombres[6])){ //Ciencias Sociales
				contadores[6]++;
			}
			else if(p.getPub().getMateria().equals(materiasNombres[7])){ //Historia
				contadores[7]++;
			}
			else if(p.getPub().getMateria().equals(materiasNombres[8])){ //Econom�a
				contadores[8]++;
			}
			else if(p.getPub().getMateria().equals(materiasNombres[9])){ //Actualidad
				contadores[9]++;
			}
		}
		for(int i = 0; i < 10; i++){
			materias.add(new MateriaConCantidadSolicitudes(materiasNombres[i], contadores[i]++));
		}
		Collections.sort(materias);

		return materias;
	}

	public Prestamo buscarPrestamoPorPublicacion(UsuarioAcreditado user, Publicacion pub){

		for (Prestamo p : prestamosTotales){
			if(p.getPub().equals(pub) && user != null)
				return p;
		}
		return null;
	}

	public boolean realizarProrroga(String id, Publicacion pub){

		boolean realizada = false;
		UsuarioAcreditado user = buscarUsuarioPorId(id);
		if(user != null){
			Prestamo p = buscarPrestamoPorPublicacion(user, pub);
			if(p != null){
				p.concederProrroga();
				realizada = true;
			}
		}
		return realizada;
	}
	public ArrayList<Prestamo> guardarPrestamosActivos(){
		ArrayList<Prestamo> prestamosActivos = new ArrayList<Prestamo>();

		for(Prestamo p : prestamosTotales){
			if(p.getFechaDevolucion() == null)
				prestamosActivos.add(p);
		}
		return prestamosActivos;
	}

	public Prestamo[] guardarPrestProximosAVencerse(int cantDias, String tipo){

		//Prestamo[] prest = new Prestamo[prestamosTotales.size()];
		ArrayList<Prestamo> prest = new ArrayList<Prestamo>();
		LocalDate hoyInicio = LocalDate.now();
		LocalDate fechaFinalPeligro = hoyInicio.plusDays(cantDias);
		for(Prestamo p : guardarPrestamosActivos()){
			if(p.getFechaDevolucion() == null){ //si no has devuelto el libro
				if(fechaFinalPeligro.isAfter(p.getFechaMax()) && hoyInicio.isBefore(p.getFechaMax())){
					if(tipo.equals("Todas")){
						prest.add(p);
					}
					else if(tipo.equals("Libro")){
						if(p.getPub() instanceof Libro){
							prest.add(p);
						}
					}
					else if(tipo.equals("Revista")){
						if(p.getPub() instanceof Revista){
							prest.add(p);
						}
					}
					else if(tipo.equals("Articulo")){
						if(p.getPub() instanceof Articulo){
							prest.add(p);
						}
					}
				}
			}
		}

		Prestamo[] prestamosArray = new Prestamo[prest.size()];

		for(int i=0;i<prestamosArray.length;i++){
			prestamosArray[i] = prest.get(i);
		}

		Arrays.sort(prestamosArray, new PrestamoComparador());

		return prestamosArray;
	}

	public Prestamo[] rangoPrestamo (Date fechaInf,Date fechaSup)   {


		LocalDateTime fechaMin = fechaInf.toInstant()  //convierto a ldt pa trabajar con .after
				.atZone(ZoneId.systemDefault())
				.toLocalDateTime();

		LocalDateTime fechaMax = fechaSup.toInstant()  
				.atZone(ZoneId.systemDefault())
				.toLocalDateTime();

		LocalDate fechaMin2 = fechaMin.toLocalDate();
		LocalDate fechaMax2 = fechaMax.toLocalDate();


		ArrayList<Prestamo> result = new ArrayList<Prestamo>();

		for(int i = 0; i < prestamosTotales.size(); i++){
			if (prestamosTotales.get(i).getFechaP().isAfter(fechaMin2) && prestamosTotales.get(i).getFechaP().isBefore(fechaMax2)){
				result.add(prestamosTotales.get(i));
			}    
		}

		Prestamo[] prestamosRango = new Prestamo[result.size()];

		for(int i=0;i<result.size();i++){
			prestamosRango[i] = result.get(i);
		}
		return prestamosRango;  
	}


	public void agregarTrabajador(String id,String nombreCompleto,String nivelEscolar, String cargo) {
		trabajadores.add(new Trabajador(id, nombreCompleto,nivelEscolar, cargo));
	}

	public UsuarioAcreditado crearUsuarioAcreditado(String id, String nombre) {
		UsuarioAcreditado u = new UsuarioAcreditado(id, nombre);
		usuarios.add(new UsuarioAcreditado(id, nombre));
		return u;
	}

	public void agregarLibro(String id, String titulo, String materia, int numPaginas, int cantEjemplares, boolean estaPrestado, String autor, String editorial) {
		publicaciones.add(new Libro(id, titulo, materia, numPaginas, cantEjemplares, estaPrestado, autor, editorial));
	}

	public void agregarRevista(String id, String titulo, String materia, int numPaginas,
			int cantEjemplares, boolean estaPrestado) {
		publicaciones.add(new Revista(id, titulo, materia, numPaginas, cantEjemplares, estaPrestado));
	}

	public void agregarArticulo(String id, String titulo, String materia, int numPaginas, int cantEjemplares, boolean estaPrestado, String autor, String arbitro) {
		publicaciones.add(new Articulo(id, titulo, materia, numPaginas, cantEjemplares, estaPrestado, autor, arbitro));
	}

	public void agregarPrestamo(LocalDate fechaP, LocalDate fechaMax, Publicacion pub,
			UsuarioAcreditado user, Trabajador trabPrestamo) {
		prestamosTotales.add(new Prestamo(fechaP, fechaMax, pub, user, trabPrestamo));
	}

	public void agregarPrestamo(LocalDate fechaP, LocalDate fechaMax, LocalDate fechaDev, Publicacion pub,
			UsuarioAcreditado user, Trabajador trabPrestamo) {
		prestamosTotales.add(new Prestamo(fechaP, fechaMax, fechaDev, pub, user, trabPrestamo));
	}
}
