import java.time.LocalDate;
import java.util.ArrayList;

public class UsuarioAcreditado extends Persona {

	private int numUsuario;
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

	public void setNumUsuario(int numUsuario) {
		this.numUsuario = numUsuario;
	}


	public UsuarioAcreditado(int id, String nombreCompleto, int edad, char sexo, String fecha, int numUsuario, LocalDate fechaAcreditacion) {
		super(id, nombreCompleto, edad, sexo, fecha);
		setNumUsuario(numUsuario);
	}
	
}