package Logica;
import java.time.LocalDate;

public class Persona {

	protected int id;
	protected String nombreCompleto;
	protected int edad;
	protected char sexo;
	protected LocalDate fecha;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {

		String errores = Validacion.validarCadena(nombreCompleto, "nombre");

		if(errores.isEmpty())
			this.nombreCompleto = nombreCompleto;
		else throw new IllegalArgumentException(errores);
	}

	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		if(edad > 6 && edad < 110)
			this.edad = edad;
		else throw new IllegalArgumentException("Edad no admitida.\n");
	}

	public char getSexo() {
		return sexo;
	}
	
	public void setSexo(char sexo) {
		if(sexo == 'f' || sexo == 'F' || sexo == 'm' || sexo == 'M')
			this.sexo = sexo;
		else throw new IllegalArgumentException("Caracter de sexo no valido");
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public void setFecha(LocalDate fecha) {
		
		this.fecha = fecha;
		
	}
	public Persona(int id, String nombreCompleto, int edad, char sexo, LocalDate fecha) {
		setId(id);
		setNombreCompleto(nombreCompleto);
		setEdad(edad);
		setSexo(sexo);
		setFecha(fecha);
	}
}
