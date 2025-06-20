package Logica;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
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


		if(pub.getCantEjemplares() < 3){
			throw new IllegalArgumentException("La publicación no tiene suficientes ejemplares disponibles (mínimo 3 requeridos)");
		}

		if(user.getFechaPenalizacion().isBefore(LocalDate.now())){
			user.setFechaPenalizacion(null);
		}
		
		if(user.getFechaPenalizacion() != null){
			throw new IllegalArgumentException("El usuario tiene una penalización actualmente");
		}

		synchronized(user) {

			if(user.getPrestamos().size() >= 3){
				throw new IllegalArgumentException("Usuario ya tiene más de 3 préstamos actualmente");
			}

			for(Prestamo p : prestamosTotales){

				if(p.getPub().equals(pub)){
					if(p.getFechaDevolucion() == null){
						throw new IllegalArgumentException("El usuario ya tiene un préstamo activo de esta publicación.");
					}
					if (p.getFechaDevolucion().plusWeeks(2).isAfter(LocalDate.now())) {
						throw new IllegalArgumentException("No han transcurrido 2 semanas desde la última devolución de esta publicación");
					}
				}
			}

			
			pub.disminuirStock();

			int tiempo = pub.tiempoMaximoPrestamo();

			LocalDate fechaActual = LocalDate.now();
			LocalDate fechaDevolucion = fechaActual.plusDays(tiempo);

			prestamoNuevo = new Prestamo(fechaActual, fechaDevolucion, pub, user, trabajador);
			user.agregarPrestamo(prestamoNuevo);
			prestamosTotales.add(prestamoNuevo);
		}
		return prestamoNuevo;
	}

	public void devolverPublicacion(Prestamo prestamo){
		LocalDate hoy = LocalDate.now();
		if(prestamo.getFechaMax().isBefore(hoy)){
			int atraso = obtenerAtraso(prestamo.getFechaMax());
			LocalDate fechaPenalizacion = hoy.plusDays(atraso);
			prestamo.getUser().setFechaPenalizacion(fechaPenalizacion);
		}
		prestamo.setFechaDevolucion(hoy);
		prestamo.getUser().getPrestamos().remove(prestamo);
	}

	public int obtenerAtraso(LocalDate fecha){
		int dias = Period.between(fecha, LocalDate.now()).getDays();
		return dias*3;
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

		if (publicaciones == null)
			throw new IllegalStateException("Lista de publicaciones no inicializada");

		for (Libro l : obtenerLibros()){
			if(l != null && l.getId().equals(id))
				pub = l;
		}
		for (Revista r : obtenerRevistas()){
			if(r != null && r.getId().equals(id))
				pub = r;
		}
		for (Articulo a : obtenerArticulos()){
			if(a != null && a.getId().equals(id))
				pub = a;
		}
		return pub;
	}

	public ArrayList<Libro> obtenerLibros(){
		ArrayList<Libro> libros = new ArrayList<Libro>();
		for(Publicacion p : publicaciones)
			if(p instanceof Libro)
				libros.add((Libro)p);
		return libros;
	}

	public ArrayList<Revista> obtenerRevistas(){
		ArrayList<Revista> revistas = new ArrayList<Revista>();
		for(Publicacion p : publicaciones)
			if(p instanceof Revista)
				revistas.add((Revista)p);
		return revistas;
	}

	public ArrayList<Articulo> obtenerArticulos(){
		ArrayList<Articulo> articulos = new ArrayList<Articulo>();
		for(Publicacion p : publicaciones)
			if(p instanceof Articulo)
				articulos.add((Articulo)p);
		return articulos;
	}

	public ArrayList<MateriaConCantidadSolicitudes> guardarMateriasMasSolicitadas(){

		ArrayList<MateriaConCantidadSolicitudes> materias = new ArrayList<MateriaConCantidadSolicitudes>(); // materia y cant

		String[] materiasNombres = {"Literatura",
				"Literatura Fantástica",
				"Ciencias Naturales",
				"Tecnología",
				"Ciencias Exactas",
				"Divulgación Científica",
				"Ciencias Sociales",
				"Historia",
				"Economía",
				"Actualidad",};

		int[] contadores = {0,0,0,0,0,0,0,0,0,0};

		for(Prestamo p : prestamosTotales){
			if(p.getPub().getMateria().equals(materiasNombres[0])){ //Literatura
				contadores[0]++;
			}
			else if(p.getPub().getMateria().equals(materiasNombres[1])){ //Literatura Fantástica
				contadores[1]++;
			}
			else if(p.getPub().getMateria().equals(materiasNombres[2])){ //Ciencias Naturales
				contadores[2]++;
			}
			else if(p.getPub().getMateria().equals(materiasNombres[3])){ //Tecnología
				contadores[3]++;
			}
			else if(p.getPub().getMateria().equals(materiasNombres[4])){ //Ciencias Exactas
				contadores[4]++;
			}
			else if(p.getPub().getMateria().equals(materiasNombres[5])){ //Divulgación Científica
				contadores[5]++;
			}
			else if(p.getPub().getMateria().equals(materiasNombres[6])){ //Ciencias Sociales
				contadores[6]++;
			}
			else if(p.getPub().getMateria().equals(materiasNombres[7])){ //Historia
				contadores[7]++;
			}
			else if(p.getPub().getMateria().equals(materiasNombres[8])){ //Economía
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

		Prestamo prestamo = null;
		
		for (Prestamo p : prestamosTotales){
			if(p.getPub().equals(pub) && p.getUser().getId().equals(user.getId())){
				prestamo = p;
			}
		}
		return prestamo;
	}

	public boolean realizarProrroga(String id, Publicacion pub){

		boolean realizada = false;
		UsuarioAcreditado user = buscarUsuarioPorId(id);
		Prestamo p = buscarPrestamoPorPublicacion(user, pub);
		if(p != null){
			p.concederProrroga();
			realizada = true;
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

	public void agregarLibro(String id, String titulo, String materia, int numPaginas, int cantEjemplares, String autor, String editorial) {
		publicaciones.add(new Libro(id, titulo, materia, numPaginas, cantEjemplares, autor, editorial));
	}

	public void agregarRevista(String id, String titulo, String materia, int numPaginas,
			int cantEjemplares, int anno, int num) {
		publicaciones.add(new Revista(id, titulo, materia, numPaginas, cantEjemplares, anno, num));
	}

	public void agregarArticulo(String id, String titulo, String materia, int numPaginas, int cantEjemplares, String autor, String arbitro) {
		publicaciones.add(new Articulo(id, titulo, materia, numPaginas, cantEjemplares, autor, arbitro));
	}

	public void agregarPrestamo(LocalDate fechaP, LocalDate fechaMax, Publicacion pub,
			UsuarioAcreditado user, Trabajador trabPrestamo) {
		Prestamo p = new Prestamo(fechaP, fechaMax, pub, user, trabPrestamo);
		user.agregarPrestamo(p);
		prestamosTotales.add(new Prestamo(fechaP, fechaMax, pub, user, trabPrestamo));
	}

	public void agregarPrestamo(LocalDate fechaP, LocalDate fechaMax, LocalDate fechaDev, Publicacion pub,
			UsuarioAcreditado user, Trabajador trabPrestamo) {
		Prestamo p = new Prestamo(fechaP, fechaMax, fechaDev, pub, user, trabPrestamo);
		prestamosTotales.add(p);
		user.agregarPrestamo(p);
	}

	public int posicionUsuario(UsuarioAcreditado u){
		int posicion = -1;
		boolean encontrado = false;

		for(int i = 0; i < usuarios.size() && !encontrado; i++){
			if(usuarios.get(i).equals(u)){
				posicion = i;
				encontrado = true;
			}
		}
		return posicion;
	}
	public int posicionPublicacion(Publicacion p){

		int posicion = -1;
		boolean encontrado = false;

		for(int i = 0; i < publicaciones.size() && !encontrado; i++){
			if(publicaciones.get(i).equals(p)){
				posicion = i;
				encontrado = true;
			}
		}
		return posicion;
	}

	public UsuarioAcreditado buscarUsuarioPorNombre(String nombre){
		UsuarioAcreditado u = null;

		for(UsuarioAcreditado user : usuarios){
			if(user.getNombreCompleto().equals(nombre))
				u = user;
		}
		return u;
	}
	
	public int buscarPosPublicacion(Publicacion p){
		int pos = -1;
		boolean encontrado = false;
		
		for(int i = 0; i < publicaciones.size() && !encontrado; i++){
			if(publicaciones.get(i).equals(p)){
				pos = i;
				encontrado = true;
			}
		}
		return pos;
	}

	public Publicacion buscarPublicacionPorNombre(String nombre){
		Publicacion u = null;

		for(Publicacion p : publicaciones){
			if(p.getTitulo().equals(nombre))
				u = p;
		}
		return u;
	}
}
