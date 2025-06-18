package Logica;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
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

	public void setId(String numId) throws IllegalArgumentException {
	    // Validaci�n b�sica de entrada
	    if (numId == null || numId.trim().isEmpty()) {
	        throw new IllegalArgumentException("El carnet no puede estar vac�o");
	    }

	    // Validar formato num�rico y longitud
	    if (!numId.matches("\\d{11}")) {
	        throw new IllegalArgumentException("El carnet debe tener exactamente 11 d�gitos num�ricos");
	    }

	    // Convertir a array de caracteres
	    char[] cadena = numId.toCharArray();

	    // Extraer componentes de fecha
	    int anio = (cadena[0] - '0') * 10 + (cadena[1] - '0'); 
	    int mes = (cadena[2] - '0') * 10 + (cadena[3] - '0');
	    int dia = (cadena[4] - '0') * 10 + (cadena[5] - '0');

	    // Validar d�gito del siglo (7mo d�gito)
	    int sigloDigito = cadena[6] - '0';
	    if (sigloDigito < 0 || sigloDigito > 9) {
	        throw new IllegalArgumentException("D�gito de siglo inv�lido (debe ser 0-9)");
	    }

	    // Ajustar a�o seg�n siglo
	    if (sigloDigito == 9) {
	        anio += 1800; // Siglo XIX
	    } else if (sigloDigito <= 5) {
	        anio += 1900; // Siglo XX
	    } else {
	        anio += 2000; // Siglo XXI
	    }

	    // Validar rango de fecha (sin try-catch)
	    if (mes < 1 || mes > 12) {
	        throw new IllegalArgumentException("Mes de nacimiento inv�lido");
	    }
	    if (dia < 1 || dia > 31) {
	        throw new IllegalArgumentException("D�a de nacimiento inv�lido");
	    }
	    if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30) {
	        throw new IllegalArgumentException("D�a inv�lido para este mes");
	    }
	    if (mes == 2) {
	        boolean esBisiesto = (anio % 4 == 0 && (anio % 100 != 0 || anio % 400 == 0));
	        if (dia > (esBisiesto ? 29 : 28)) {
	            throw new IllegalArgumentException("D�a inv�lido para febrero");
	        }
	    }

	    LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
	    LocalDate hoy = LocalDate.now();

	    // Validar mayor�a de edad (18 a�os)
	    if (fechaNacimiento.plusYears(18).isAfter(hoy)) {
	        throw new IllegalArgumentException("El carnet indica que es menor de 18 a�os");
	    }

	    // Validar d�gito de sexo (10mo d�gito)
	    int digitoSexo = cadena[9] - '0';
	    if (digitoSexo < 0 || digitoSexo > 9) {
	        throw new IllegalArgumentException("D�gito de sexo inv�lido");
	    }

	    // Asignar valores derivados
	    setEdad(Period.between(fechaNacimiento, hoy).getYears());
	    setSexo((digitoSexo % 2 == 0) ? "M" : "F");

	    // Si todo est� correcto, asignar el ID
	    this.id = numId;
	}


	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombre) {
		if (!(nombre.replaceAll(" ", "").equalsIgnoreCase("")) && !nombre.matches(".*\\d.*")) 
		{
			nombreCompleto = nombre;
		}
		else throw new IllegalArgumentException("El nombre no es v�lido.");
	}

	public int getEdad() {
		return edad;
	}

	private void setEdad(int edad) {
		if(edad >= 18 && edad < 110)
			this.edad = edad;
		else throw new IllegalArgumentException("Edad incorrecta");
	}

	public String getSexo() {
		return sexo;
	}

	private void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Persona(String id,String nombreCompleto) {

		setId(id);
		setNombreCompleto(nombreCompleto);
		LocalDate fecha = LocalDate.now();
		setFecha(fecha);
	}
	
	public Persona(){
		
	}

	@Override
	public String toString ()
	{
		return nombreCompleto;
	}
}
