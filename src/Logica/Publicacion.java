package Logica;

import javax.swing.ImageIcon;


public abstract class Publicacion {

	protected String id = "" + 0;
	protected String titulo;
	protected String materia;
	protected int numPaginas;
	protected int cantEjemplares;
	protected String direccionImagen;
	protected ImageIcon image;
	protected boolean estaPrestado;

	public String getId(){
		return id;
	}

	public void setId(String id) {
		if(id.isEmpty()){
			throw new IllegalArgumentException("Ingrese un identificador");
		}
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {

		if(titulo.isEmpty())
			throw new IllegalArgumentException("Título no válido");
		else{	
			this.titulo = titulo;
		}
	}

	public void setDireccionImagen(String direccion){
		this.direccionImagen = direccion;
	}

	public ImageIcon getImage(){
		return new ImageIcon(direccionImagen);
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
		if(numPaginas >= 2)
			this.numPaginas = numPaginas;
		else
			throw new IllegalArgumentException("Error, el numero de paginas debe ser mayor que 1.\n");
	}
	public int getCantEjemplares() {
		return cantEjemplares;
	}
	public void setCantEjemplares(int cantEjemplares) {

		if(cantEjemplares >= 2 && cantEjemplares <= 1000)
			this.cantEjemplares = cantEjemplares;
		else
			throw new IllegalArgumentException("Error, no existe tal capacidad en la biblioteca.\n");
	}
	public boolean isEstaPrestado() {
		return estaPrestado;
	}
	public void setEstaPrestado() {
		this.estaPrestado = false;
	}

	public Publicacion(){

	}

	public Publicacion(String id, String titulo, String materia, int numPaginas, int cantEjemplares) {
		super();

		setId(id);
		setTitulo(titulo);
		setMateria(materia);
		setNumPaginas(numPaginas);
		setCantEjemplares(cantEjemplares);
		setEstaPrestado();

	}
	@Override
	public String toString() {

		return titulo;
	}
	
	

	public void disminuirStock(){
		cantEjemplares--;
	}
	
	public void aumentarStock(){
		cantEjemplares++;
	}

	public abstract int tiempoMaximoPrestamo();

}
