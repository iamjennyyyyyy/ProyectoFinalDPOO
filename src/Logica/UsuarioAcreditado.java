package Logica;
import java.time.LocalDate;
import java.util.ArrayList;

public class UsuarioAcreditado extends Persona {

	private static int numUsuario = 0;
	private LocalDate fechaPenalizacion;
	private ArrayList<Prestamo> prestamos;

	public LocalDate getFechaPenalizacion() {
		return fechaPenalizacion;
	}

	public void setFechaPenalizacion(LocalDate fechaPenalizacion) {
		
		this.fechaPenalizacion = fechaPenalizacion;
	}

	public ArrayList<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(Prestamo prestamo) {
		prestamos.add(prestamo);
	}

	public int getNumUsuario() {
		return numUsuario;
	}

	public void setNumUsuario() {
		numUsuario++;
	}

	public void agregarPrestamo(Prestamo p){
		prestamos.add(p);
	}

	public void eliminarPrestamo(Prestamo p){
		int pos = -1;
		for (int i = 0; i < prestamos.size() && pos == -1; i++) {
			if (prestamos.get(i).equals(p)) {
				pos = i;
			}
		}
		prestamos.remove(pos);
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