package Logica;
import java.util.ArrayList;

public class UsuarioAcreditado extends Persona {

	private static int numUsuario = 0;
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


	public UsuarioAcreditado(String id, String nombreCompleto, int edad, String sexo) {
		super(id, nombreCompleto, edad, sexo);
		setNumUsuario();
		prestamos = new ArrayList<Prestamo>();
	}
}