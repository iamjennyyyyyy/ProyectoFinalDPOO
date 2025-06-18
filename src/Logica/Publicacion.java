package Logica;


public abstract class Publicacion {

	protected String id;
	protected String titulo;
	protected String materia;
	protected int numPaginas;
	protected int cantEjemplares;
	protected boolean estaPrestado;

	public String getId(){
		return id;
	}

	private void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		
		titulo = titulo.trim();
		if (!titulo.isEmpty() && 
		        titulo.length() >= 2 && 
		        !titulo.matches("^[\\s\\d]+$")) {
		        this.titulo = titulo;
		} else {
			throw new IllegalArgumentException("T�tulo no v�lido");
		}
	}
	
	public String getMateria() {
		return materia;
	}

	//Comprueba que no contenga los errores declarados en  el metodo estatico validarCadena
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public int getNumPaginas() {
		return numPaginas;
	}

	//Comprueba que este en el rango especifiado
	public void setNumPaginas(int numPaginas) {
		if(numPaginas >= 1)
			this.numPaginas = numPaginas;
		else
			throw new IllegalArgumentException("Error, el numero de paginas debe ser mayor que 1.\n");
	}
	public int getCantEjemplares() {
		return cantEjemplares;
	}
	public void setCantEjemplares(int cantEjemplares) {

		if(cantEjemplares >= 1 && cantEjemplares <= 1000)
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

	public Publicacion(String id, String titulo, String materia, int numPaginas, int cantEjemplares, boolean estaPrestado) {
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

	public void disminuirStock(){
		cantEjemplares--;
	}

	public abstract int tiempoMaximoPrestamo();

}
