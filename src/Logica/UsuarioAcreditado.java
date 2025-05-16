package Logica;
import java.time.LocalDate;
import java.util.ArrayList;

public class UsuarioAcreditado extends Persona {

	private int numUsuario;
	private String usuarioLogeo;
	private String contrasenia;
	private String info;
	private String materiaPreferida;
	
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getMateriaPreferida() {
		return materiaPreferida;
	}

	public void setMateriaPreferida(String materiaPreferida) {
		this.materiaPreferida = materiaPreferida;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}


	private ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
	
	public String getUsuarioLogeo() {
		return usuarioLogeo;
	}

	public void setUsuarioLogeo(String usuarioLogeo) {
		this.usuarioLogeo = usuarioLogeo;
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

	public void setNumUsuario(int numUsuario) {
		this.numUsuario = numUsuario;
	}


	public UsuarioAcreditado(int id, String nombreCompleto, int edad, char sexo, LocalDate fecha, int numUsuario, LocalDate fechaAcreditacion, String usuarioLogeo, String contrasenia) {
		super(id, nombreCompleto, edad, sexo, fecha);
		setNumUsuario(numUsuario);
		setUsuarioLogeo(usuarioLogeo);
		setContrasenia(contrasenia);
	}
}