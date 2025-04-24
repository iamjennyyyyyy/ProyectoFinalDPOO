import java.time.LocalDateTime;

public class Prestamo {

	private LocalDateTime fechaP;
	private LocalDateTime fechaMax;
	private Publicacion pub;
	private UsuarioAcreditado user;
	private String trabPrestamo;
	
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
	public String getTrabPrestamo() {
		return trabPrestamo;
	}
	public void setTrabPrestamo(String trabPrestamo) {
		this.trabPrestamo = trabPrestamo;
	}
	
	public Prestamo(LocalDateTime fechaP, LocalDateTime fechaMax, Publicacion pub,
			UsuarioAcreditado user, String trabPrestamo) {
		
		setFechaP(fechaP);
		setFechaMax(fechaMax);
		setPub(pub);
		setUser(user);
		setTrabPrestamo(trabPrestamo);
	}
	
	
}
