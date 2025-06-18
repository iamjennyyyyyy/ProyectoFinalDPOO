package Logica;
import java.time.LocalDate;
import java.util.ArrayList;

public class UsuarioAcreditado extends Persona {

	private static int numUsuario = 0;
	private LocalDate fechaPenalizacion;
	
	public LocalDate getFechaPenalizacion() {
		return fechaPenalizacion;
	}

	public void setFechaPenalizacion(LocalDate fechaPenalizacion) {
		this.fechaPenalizacion = fechaPenalizacion;
	}
	private ArrayList<Prestamo> prestamos;

	public ArrayList<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(Prestamo prestamo) {
		prestamos.add(prestamo);
	}

	public int getNumUsuario() {
		return numUsuario;
	}

	public static void setNumUsuario() {
		numUsuario++;
	}
	
	public void agregarPrestamo(Prestamo p){
		prestamos.add(p);
	}

	public UsuarioAcreditado(){
		super();
	}
	public UsuarioAcreditado(String id, String nombreCompleto) {
		super(id, nombreCompleto);
		setNumUsuario();
		fechaPenalizacion = null;
		prestamos = new ArrayList<Prestamo>();
	}
}