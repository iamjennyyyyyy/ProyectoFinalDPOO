

public class Validacion {

	public static String validarCadena(String cadena, String tipoDato){
		
		String errores = "";
		
		if(cadena == null)
			errores = "Error, " + tipoDato + " no puede ser null.\n";
		else if(cadena.isEmpty())
			errores = "Error, ingrese un/a " + tipoDato + ".\n";
		else if(cadena.length() < 1 || cadena.length() > 100)
			errores = "Error, " + tipoDato + " debe tener entre 1 y 100 caracteres.\n.";
		else if(cadena.trim().isEmpty())
			errores = "Error, " + tipoDato + " no puede estar vacio/a.\n";
		else if(!cadena.matches("^[\\p{L} .'-]+$"))
			errores = "Error, " + tipoDato + " contiene caracteres inválidos.\n";
		
		return errores;
	}
}
