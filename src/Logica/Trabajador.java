package Logica;

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
	
	public Trabajador(){
		super();
	}
	
	public Trabajador(String id, String nombreCompleto, String nivelEscolar, String cargo) {
		super(id,nombreCompleto);
		setNivelEscolar(nivelEscolar);
		setCargo(cargo);
	}
}
