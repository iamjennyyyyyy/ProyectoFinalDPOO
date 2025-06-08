package Logica;
import java.time.LocalDate;
import java.util.Calendar;

public class Persona {

	protected String id;
	protected String nombreCompleto;
	protected int edad;
	protected String sexo;
	protected LocalDate fecha;

	public String getId() {
		return id;
	}
	public void setId(String id) {
//		// Variables necesarias
//		int anioReal = 0;
//		int mes = 0;
//		int dia = 0;
//		int anioMinimo = 0;
//		int anioMaximo = 0;
//		int anioNacimiento = 0;
//		String siglo;
//		boolean valido = true;
//
//		// Definir estas constantes según tus necesidades
//		final int EDAD_MAX = 25;
//		final int EDAD_MIN = 20;
//
//		// Validación básica de entrada
//		if (id == null || id.isEmpty() || id.charAt(0) == ' ') {
//			valido = false;
//		} else {
//			// Obtener fecha actual
//			Calendar calendar = Calendar.getInstance();
//			anioReal = calendar.get(Calendar.YEAR);
//			anioMinimo = anioReal - EDAD_MAX;
//			anioMaximo = anioReal - EDAD_MIN;
//
//			siglo = id.charAt(6);
//			String digitosAnio = id.substring(0, 2);
//			anioNacimiento = Integer.parseInt(digitosAnio);
//
//			// Determinar siglo
//			if (siglo >= '0' && siglo <= '5') {
//				anioNacimiento += 1900;
//			} else if (siglo >= '6' && siglo <= '8') {
//				anioNacimiento += 2000;
//			} else {
//				valido = false;
//			}
//
//			// Validar rango de años
//			if (valido && (anioNacimiento > anioMaximo || anioNacimiento < anioMinimo)) {
//				valido = false;
//			}
//
//			// Validar mes
//			if (valido) {
//				String digitosMes = id.substring(2, 4);
//				mes = Integer.parseInt(digitosMes);
//
//				if (mes < 1 || mes > 12) {
//					valido = false;
//				}
//			}
//
//			// Validar día
//			if (valido) {
//				String digitosDia = id.substring(4, 6);
//				dia = Integer.parseInt(digitosDia);
//
//				if (dia == 0) {
//					valido = false;
//				} else {
//					// Validar días según mes
//					if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30) {
//						valido = false;
//					} else if ((mes == 1 || mes == 3 || mes == 5 || mes == 7 || 
//							mes == 8 || mes == 10 || mes == 12) && dia > 31) {
//						valido = false;
//					} else if (mes == 2) {
//						boolean esBisiesto = (anioNacimiento % 4 == 0);
//						if ((esBisiesto && dia > 29) || (!esBisiesto && dia > 28)) {
//							valido = false;
//						}
//					}
//				}
//			}
//		}
//		if(!valido){
//			throw new IllegalArgumentException("Carnet incorrecto. Verifique por favor");
//		}
//		else{
			this.id = id;
//		}
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

	@Override
	public String toString ()
	{
		return nombreCompleto;
	}
}
