package Logica;

import java.time.LocalDate;


public class Revista extends Publicacion {

	private int anno;
	private int num;

	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		if(anno > LocalDate.now().getYear())
			throw new IllegalArgumentException("Año incorrecto");
		else if(anno < 1930)
			throw new IllegalArgumentException("Año incorrecto");
		else
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

	public Revista(){
		super();
	}

	public Revista(String id, String titulo, String materia, int numPaginas,
			int cantEjemplares, int anno, int num) {

		super(id, titulo, materia, numPaginas, cantEjemplares);
		setAnno(anno);
		setNum(num);
	}

	@Override
	public int tiempoMaximoPrestamo(){
		return cantEjemplares*2;
	}

}
