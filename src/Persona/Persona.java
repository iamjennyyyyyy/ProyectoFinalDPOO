package Persona;

import Publicacion.Validacion;

public abstract class Persona {

	protected int id;
	protected String nombreCompleto;
	protected int edad;
	protected char sexo;
	protected String fecha;

	public int getId() {
		return id;
	}
	//Implementar
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
		if(edad > 12 && edad < 100)
			this.edad = edad;
		else throw new IllegalArgumentException("Edad insuficiente.\n");
	}

	public char getSexo() {
		return sexo;
	}
	
	public void setSexo(char sexo) {
		if(sexo == 'f' || sexo == 'F' || sexo == 'm' || sexo == 'M')
			this.sexo = sexo;
		else throw new IllegalArgumentException("Caracter de sexo no valido");
	}
	
	public String getFecha() {
		return fecha;
	}
	//Implementar
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


}
