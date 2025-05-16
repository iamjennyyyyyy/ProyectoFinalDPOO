package Logica;
import java.time.LocalDate;



public class Trabajador extends Persona {

	private String nivelEscolar;
	private String cargo;
	
	public String getNivelEscolar() {
		return nivelEscolar;
	}
	public void setNivelEscolar(String nivelEscolar) {
		this.nivelEscolar = nivelEscolar;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public Trabajador(int id, String nombreCompleto, int edad, char sexo, LocalDate fecha, String nivelEscolar, String cargo) {
		super(id, nombreCompleto, edad, sexo, fecha);
		
		setNivelEscolar(nivelEscolar);
		setNivelEscolar(cargo);
	}
	
	
}
