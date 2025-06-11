package Utiles;
import java.util.ArrayList;

import javax.swing.AbstractListModel;

import Logica.*;

public class ModelPrestamo extends AbstractListModel {
	
	private ArrayList <Prestamo> lstPrestamos = new ArrayList<Prestamo>();

	// establece la lista de usuarios al modelo
	public void setlstPrestamos(ArrayList<Prestamo> lstPrestamos) {
		this.lstPrestamos = lstPrestamos;
		this.fireIntervalAdded(this, 0, getSize());
	}

	// devuelve el tamaño de la lista del modelo
	public int getSize() {
		return lstPrestamos.size();
	}

	// devuelve el elemento de la posición index dentro del modelo
	public Object getElementAt(int indice) {
		Prestamo x = null;
		if (indice > -1 && indice < this.getSize())
			x = lstPrestamos.get(indice);
		return x;
	}

	// agrega un usuario al final de la lista del modelo
	public void addPrestamo(Prestamo p) {
		lstPrestamos.add(p);
		this.fireIntervalAdded(this, getSize(), getSize());
	}

	// agrega un usuario al modelo en la posición indice
	public Prestamo getPrestamoAt(int indice) {
		Prestamo x = null;
		if (indice > -1 && indice < this.getSize())
			x = lstPrestamos.get(indice);
		return x;
	}

	// elimina un usuario del modelo que ocupa la posición indice
	public void removePrestamo (int indice) {
		if (indice > -1 && indice < this.getSize()) {
			lstPrestamos.remove(indice);
			this.fireIntervalRemoved(this, indice, indice);
		}
	}
	// modifica en el modelo los valores del usuario en la posición indice
	public void updatePrestamo (int indice, Prestamo c) {
		if (indice > -1 && indice < this.getSize()) {
			lstPrestamos.set(indice, c);
			this.fireContentsChanged(this, indice, indice);
		}
	}
}
