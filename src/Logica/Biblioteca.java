package Logica;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

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

		if (pub == null) {
			throw new IllegalArgumentException("Publicacion no encontrada");
		}

		if (user == null) {
			throw new IllegalArgumentException("Usuario no encontrado.");
		}
		
		if (trabajador == null) {
			throw new IllegalArgumentException("Trabajador no encontrado.");
		}

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
				LocalDateTime fechaActual = LocalDateTime.now();
				int tiempo = pub.tiempoMaximoPrestamo();
				LocalDateTime fechaDevolucion = fechaActual.plusDays(tiempo);
				prestamoNuevo = new Prestamo(fechaActual,fechaDevolucion,pub,user,trabajador);
				user.getPrestamos().add(prestamoNuevo);
				prestamosTotales.add(prestamoNuevo);
			}
			else
				throw new IllegalArgumentException("El usuario tiene ya 3 prestamos.");
		}
		else
			throw new IllegalArgumentException("Publicacion no disponible.");

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

		if (usuarios == null) {
			throw new IllegalStateException("Lista de usuarios no inicializada");
		}
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
		public int contarPrestamosActivos(){
			int cont = 0;

			for(Prestamo p : prestamosTotales){
				if(p.getFechaDevolucion() == null)
					cont++;
			}
			return cont;
		}
		
		public void agregarTrabajador(Trabajador t) {
	        trabajadores.add(t);
	    }

	    public void crearUsuarioAcreditado(String id, String nombre,int edad, String sexo) {
	        usuarios.add(new UsuarioAcreditado(id, nombre, edad, sexo));
	    }

	    public void agregarLibro(Libro l) {
	        libros.add(l);
	    }

	    public void agregarRevista(Revista r) {
	        revistas.add(r);
	    }

	    public void agregarArticulo(Articulo a) {
	        articulos.add(a);
	    }

	    public void agregarPrestamo(Prestamo p) {
	        prestamosTotales.add(p);
	    }
	}
