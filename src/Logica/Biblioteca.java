package Logica;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

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
	private ArrayList<Prestamo> prestamosTotales;


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
		prestamosTotales = new ArrayList<Prestamo>();
	}

	public static Biblioteca getInstancia() {
		if (unicaInstancia == null) {
			unicaInstancia = new Biblioteca(
	                1,
	                "Biblioteca Municipal Central",
	                "Barcelona",
	                "Barcelona",
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
	public Prestamo solicitarPrestamo(UsuarioAcreditado user, Publicacion pub, Trabajador trabajador){
		Prestamo prestamoNuevo;

		for(Prestamo p : user.getPrestamos()){
			if(p.getPub().equals(pub) && p.getFechaDevolucion() != null && 
					p.getFechaDevolucion().plusDays(14).isAfter(LocalDate.now())){
				throw new IllegalArgumentException("No han transcurrido dos semanas desde la última devolucion.");
			}
		}
		if(pub.getCantEjemplares() > 2){
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
				return null;
			//throw new IllegalArgumentException("El usuario tiene ya 3 prestamos.");
		}
		else
			return null;
			//throw new IllegalArgumentException("Publicacion no disponible.");

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

	public UsuarioAcreditado buscarUsuarioPorId(String id){
		UsuarioAcreditado usuario = null;

		for (UsuarioAcreditado user : usuarios){
			if(user != null && user.getId().equals(id))
				usuario = user;
		}
		return usuario;
	}

	public Publicacion buscarPublicacionPorId(String id){

		if (libros == null)
			throw new IllegalStateException("Lista de libros no inicializada");
		else if (revistas == null)
			throw new IllegalStateException("Lista de revistas no inicializada");
		else if (articulos == null)
			throw new IllegalStateException("Lista de articulos no inicializada");
			
			for (Libro l : libros){
				if(l != null && l.getId().equals(id))
					return l;
			}
			for (Revista r : revistas){
				if(r != null && r.getId().equals(id))
					return r;
			}
			for (Articulo a : articulos){
				if(a != null && a.getId().equals(id))
					return a;
			}
			return null;
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
		
		public Prestamo[] guardarPrestProximosAVencerse(int cantDias){
			
			//Prestamo[] prest = new Prestamo[prestamosTotales.size()];
			ArrayList<Prestamo> prest = new ArrayList<Prestamo>();
			LocalDate hoyInicio = LocalDate.now();
			LocalDate fechaFinalPeligro = hoyInicio.plusDays(cantDias);
			for(Prestamo p : guardarPrestamosActivos()){
				if(p.getFechaDevolucion() == null){ //si no has devuelto el libro
					if(fechaFinalPeligro.isAfter(p.getFechaMax()) && hoyInicio.isBefore(p.getFechaMax())){
						prest.add(p);
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
		
		
		public void agregarTrabajador(String id,String nombreCompleto, int edad, String sexo, String nivelEscolar, String cargo) {
	        trabajadores.add(new Trabajador(id, nombreCompleto, edad, sexo, nivelEscolar, cargo));
	    }

	    public void crearUsuarioAcreditado(String id, String nombre,int edad, String sexo) {
	        usuarios.add(new UsuarioAcreditado(id, nombre, edad, sexo));
	    }

	    public void agregarLibro(String id, String titulo, String materia, int numPaginas, int cantEjemplares, boolean estaPrestado, ArrayList<String> autores, String editorial) {
	        libros.add(new Libro(id, titulo, materia, numPaginas, cantEjemplares, estaPrestado, autores, editorial));
	    }

	    public void agregarRevista(String id, String titulo, String materia, int numPaginas,
				int cantEjemplares, boolean estaPrestado) {
	        revistas.add(new Revista(id, titulo, materia, numPaginas, cantEjemplares, estaPrestado));
	    }

	    public void agregarArticulo(String id, String titulo, String materia, int numPaginas, int cantEjemplares, boolean estaPrestado, ArrayList<String> autores, ArrayList<String> arbitros) {
	        articulos.add(new Articulo(id, titulo, materia, numPaginas, cantEjemplares, estaPrestado, autores, arbitros));
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
