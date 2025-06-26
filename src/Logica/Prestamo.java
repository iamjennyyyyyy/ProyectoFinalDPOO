package Logica;
import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.Objects;

public class Prestamo {

	private LocalDate fechaP;
	private LocalDate fechaMax;
	private LocalDate fechaDevolucion = null;
	private Publicacion pub;
	private UsuarioAcreditado user;
	private Trabajador trabPrestamo;

	public LocalDate getFechaP() {
		return fechaP;
	}
	public void setFechaP(LocalDate fechaP) {
		this.fechaP = fechaP;
	}
	public LocalDate getFechaMax() {
		return fechaMax;
	}
	public void setFechaMax(LocalDate fechaMax) {
		this.fechaMax = fechaMax;
	}
	public Publicacion getPub() {
		return pub;
	}
	public void setPub(Publicacion pub) {
		if(pub != null)
			this.pub = pub;
		else throw new IllegalArgumentException("Publicacion no válida");
	}
	public UsuarioAcreditado getUser() {
		return user;
	}
	public void setUser(UsuarioAcreditado user) {
		if(user != null)
			this.user = user;
		else throw new IllegalArgumentException("Usuario no válido");
	}
	public Trabajador getTrabPrestamo() {
		return trabPrestamo;
	}
	public void setTrabPrestamo(Trabajador trabPrestamo) {
		if(trabPrestamo != null)
			this.trabPrestamo = trabPrestamo;
		else throw new IllegalArgumentException("Trabajador no valida");
	}
	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}
	public void setFechaDevolucion(LocalDate fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
	public Prestamo(LocalDate fechaP, LocalDate fechaMax, Publicacion pub,
			UsuarioAcreditado user, Trabajador trabPrestamo) {

		setFechaP(fechaP);
		setFechaMax(fechaMax);
		setPub(pub);
		setUser(user);
		setTrabPrestamo(trabPrestamo);
	}

	public Prestamo(LocalDate fechaP, LocalDate fechaMax, LocalDate fechaDev, Publicacion pub,
			UsuarioAcreditado user, Trabajador trabPrestamo) {

		setFechaP(fechaP);
		setFechaMax(fechaMax);
		setFechaDevolucion(fechaDev);
		setPub(pub);
		setUser(user);
		setTrabPrestamo(trabPrestamo);
		if(fechaDev.isAfter(fechaMax)){
			Period p = Period.between(fechaMax, fechaDev);
			int dias = p.getDays();

			dias *= 3;

			LocalDate fechaPenalizacion = fechaDev.plusDays(dias);

			user.setFechaPenalizacion(fechaPenalizacion);

		}

	}

	public void concederProrroga(){
		int tiempoMax = pub.tiempoMaximoPrestamo();
		this.fechaMax = fechaMax.plusDays(tiempoMax/2);
	}
	@Override
	public String toString() {

		String tipoPublicacion;
		if(pub instanceof Libro)
			tipoPublicacion = "Libro";
		else if(pub instanceof Revista)
			tipoPublicacion = "Revista";
		else
			tipoPublicacion = "Articulo";

		String mensaje = tipoPublicacion + ": " + pub.getTitulo() + 
				"\n" + "Usuario: " + user.getNombreCompleto() + 
				"\n" + "Gestor: " + trabPrestamo.getNombreCompleto() + 
				"\n" + "Fecha prestamo: " + fechaP + 
				"\n" + "Fecha maxima: " + fechaMax + 
				"\n";

		if(fechaDevolucion != null)
			mensaje += "Devuelta en la fecha " + fechaDevolucion;
		else
			mensaje += "Aun no devuelto ";

		return mensaje;
	}
	
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;
	    Prestamo prestamo = (Prestamo) o;
	    return Objects.equals(fechaP, prestamo.fechaP) &&
	           Objects.equals(user, prestamo.user) &&
	           Objects.equals(pub, prestamo.pub);
	}
}
