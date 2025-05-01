import java.time.LocalDate;
import java.time.LocalDateTime;

public class Prestamo {

	private LocalDateTime fechaP;
	private LocalDateTime fechaMax;
	private Publicacion pub;
	private UsuarioAcreditado user;
	private Trabajador trabPrestamo;
	private LocalDate fechaDevolucion = null;
	
	public LocalDateTime getFechaP() {
		return fechaP;
	}
	public void setFechaP(LocalDateTime fechaP) {
		this.fechaP = fechaP;
	}
	public LocalDateTime getFechaMax() {
		return fechaMax;
	}
	public void setFechaMax(LocalDateTime fechaMax) {
		this.fechaMax = fechaMax;
	}
	public Publicacion getPub() {
		return pub;
	}
	public void setPub(Publicacion pub) {
		this.pub = pub;
	}
	public UsuarioAcreditado getUser() {
		return user;
	}
	public void setUser(UsuarioAcreditado user) {
		this.user = user;
	}
	public Trabajador getTrabPrestamo() {
		return trabPrestamo;
	}
	public void setTrabPrestamo(Trabajador trabPrestamo) {
		this.trabPrestamo = trabPrestamo;
	}
	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}
	public void setFechaDevolucion(LocalDate fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
	
	public Prestamo(LocalDateTime fechaP, LocalDateTime fechaMax, Publicacion pub,
			UsuarioAcreditado user, Trabajador trabPrestamo) {
		
		setFechaP(fechaP);
		setFechaMax(fechaMax);
		setPub(pub);
		setUser(user);
		setTrabPrestamo(trabPrestamo);
	}
	public Prestamo(Prestamo p, LocalDate fechaDevolucion){
		p.fechaDevolucion = fechaDevolucion;
	}
}
