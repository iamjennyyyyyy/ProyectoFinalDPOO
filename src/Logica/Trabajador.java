package Logica;

public class Trabajador extends Persona {

	private String nivelEscolar;
	private String cargo;
	
	public String getNivelEscolar() {
		return nivelEscolar;
	}
	public void setNivelEscolar(String nivelEscolar) {
		if (!(nivelEscolar.replaceAll(" ", "").equalsIgnoreCase("")) && !nivelEscolar.matches(".*\\d.*")) 
		{
			this.nivelEscolar = nivelEscolar;
		}
		else throw new IllegalArgumentException("El nivel escolar no es válido.");
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		if (!(cargo.replaceAll(" ", "").equalsIgnoreCase("")) && !cargo.matches(".*\\d.*")) 
		{
			this.cargo = cargo;
		}
		else throw new IllegalArgumentException("El cargo no es válido.");
	}
	
	public Trabajador(String id,String nombreCompleto, String nivelEscolar, String cargo) {
		super(id,nombreCompleto);
		setNivelEscolar(nivelEscolar);
		setNivelEscolar(cargo);
	}
}
