package Logica;


public class Revista extends Publicacion {

	private int anno;
	private int num;

	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
			this.anno = anno;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		if(num >= 0 && num <= 100000)
			this.num = num;
		else throw new IllegalArgumentException("Numero de revista incorrecto");
	}

	public Revista(String id, String titulo, String materia, int numPaginas,
			int cantEjemplares, boolean estaPrestado) {

		super(id, titulo, materia, numPaginas, cantEjemplares, estaPrestado);
		setAnno(anno);
		setNum(num);
	}

	@Override
	public int tiempoMaximoPrestamo(){
		return cantEjemplares*2;
	}

}
