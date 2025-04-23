package Publicacion;

public abstract class Publicacion {

	protected int id;
	protected String titulo;
	protected String materia;
	protected int numPaginas;
	protected int cantEjemplares;
	protected boolean estaPrestado;

	public int getId(){
		return id;
	}
	//Comprueba que tenga exactamente 6 cifras
	public void setId(int id) {
		if(id / 100000 >= 1 && id / 100000 < 10)
			this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	//Comprueba que no contenga los errores declarados en  el metodo estatico validarCadena
	public void setTitulo(String titulo) {

		String errores = Validacion.validarCadena(titulo, "titulo");

		if(errores.isEmpty())
			this.titulo = titulo;
		else throw new IllegalArgumentException(errores);

	}
	public String getMateria() {
		return materia;
	}

	//Comprueba que no contenga los errores declarados en  el metodo estatico validarCadena
	public void setMateria(String materia) {

		String errores = Validacion.validarCadena(materia, "materia");

		if(errores.isEmpty())
			this.materia = materia;
		else throw new IllegalArgumentException(errores);

	}
	public int getNumPaginas() {
		return numPaginas;
	}

	//Comprueba que este en el rango especifiado
	public void setNumPaginas(int numPaginas) {
		if(numPaginas >= 1 && numPaginas <= 500)
			this.numPaginas = numPaginas;
		else
			throw new IllegalArgumentException("Error, el numero de paginas debe estar entre 1 y 500.\n");
	}
	public int getCantEjemplares() {
		return cantEjemplares;
	}
	public void setCantEjemplares(int cantEjemplares) {

		if(cantEjemplares >= 1 && cantEjemplares <= 100000)
			this.cantEjemplares = cantEjemplares;
		else
			throw new IllegalArgumentException("Error, no existe tal capacidad en la biblioteca.\n");
	}
	public boolean isEstaPrestado() {
		return estaPrestado;
	}
	public void setEstaPrestado(boolean estaPrestado) {
		this.estaPrestado = estaPrestado;
	}
	
	public Publicacion(int id, String titulo, String materia, int numPaginas, int cantEjemplares, boolean estaPrestado) {
		super();
		
		setId(id);
		setTitulo(titulo);
		setMateria(materia);
		setNumPaginas(numPaginas);
		setCantEjemplares(cantEjemplares);
		setEstaPrestado(estaPrestado);
		
	}
	@Override
	public String toString() {
		
		String mensaje = "Publicacion " + titulo + "\n Materia: " + materia + "\nNumero de paginas: " + numPaginas + "\nCantidad de ejemplares: " + cantEjemplares;
		if(estaPrestado)
			mensaje += " y no esta disponible.\n";
		else
			mensaje += " y esta disponible.\n";
		
		return mensaje;
	}
	
}
