package Logica;
import java.time.LocalDate;
import java.util.ArrayList;

public class UsuarioAcreditado extends Persona {

	private static int numUsuario = 0;
//	private String usuarioLogeo;
//	private String contrasenia;
//	private String info;
//	private String materiaPreferida;
	private ArrayList<Prestamo> prestamos;
	
//	public String getInfo() {
//		return info;
//	}
//
//	public void setInfo(String info) {
//		this.info = info;
//	}
//
//	public String getMateriaPreferida() {
//		return materiaPreferida;
//	}
//
//	public void setMateriaPreferida(String materiaPreferida) {
//		this.materiaPreferida = materiaPreferida;
//	}
//
//	public String getContrasenia() {
//		return contrasenia;
//	}
//
//	public void setContrasenia(String contrasenia) {
//		this.contrasenia = contrasenia;
//	}
//	
//	public String getUsuarioLogeo() {
//		return usuarioLogeo;
//	}
//
//	public void setUsuarioLogeo(String usuarioLogeo) {
//		this.usuarioLogeo = usuarioLogeo;
//	}

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
//		setUsuarioLogeo(usuarioLogeo);
//		setContrasenia(contrasenia);
		prestamos = new ArrayList<Prestamo>();
	}
}