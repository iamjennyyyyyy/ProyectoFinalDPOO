package Logica;
import java.time.LocalDate;

public class Persona {

	protected String id;
	protected String nombreCompleto;
	protected int edad;
	protected String sexo;
	protected LocalDate fecha;

	public String getId() {
		return id;
	}
	private void setId(String id) {
		this.id = id;
	}
	
	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		if(edad > 6 && edad < 110)
			this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
			this.sexo = sexo;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public void setFecha(LocalDate fecha) {
		
		this.fecha = fecha;
		
	}
	public Persona(String id,String nombreCompleto, int edad, String sexo) {
		
		setId(id);
		setNombreCompleto(nombreCompleto);
		setEdad(edad);
		setSexo(sexo);
		LocalDate fecha = LocalDate.now();
		setFecha(fecha);
	}
}
