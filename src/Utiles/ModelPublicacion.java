package Utiles;
import java.util.ArrayList;

import javax.swing.AbstractListModel;

import Logica.*;

public class ModelPublicacion extends AbstractListModel {
	
	private ArrayList <Publicacion> lstPub = new ArrayList<Publicacion>();

	// establece la lista de usuarios al modelo
	public void setlstPub(ArrayList<Publicacion> lstPub) {
		this.lstPub = lstPub;
		this.fireIntervalAdded(this, 0, getSize());
	}

	// devuelve el tamaño de la lista del modelo
	public int getSize() {
		return lstPub.size();
	}

	// devuelve el elemento de la posición index dentro del modelo
	public Object getElementAt(int indice) {
		Publicacion x = null;
		if (indice > -1 && indice < this.getSize())
			x = lstPub.get(indice);
		return x;
	}

	// agrega un usuario al final de la lista del modelo
	public void addPublicacion(Publicacion p) {
		lstPub.add(p);
		this.fireIntervalAdded(this, getSize(), getSize());
	}

	// agrega un usuario al modelo en la posición indice
	public Publicacion getPubAt(int indice) {
		Publicacion x = null;
		if (indice > -1 && indice < this.getSize())
			x = lstPub.get(indice);
		return x;
	}

	// elimina un usuario del modelo que ocupa la posición indice
	public void removePublicacion (int indice) {
		if (indice > -1 && indice < this.getSize()) {
			lstPub.remove(indice);
			this.fireIntervalRemoved(this, indice, indice);
		}
	}
	// modifica en el modelo los valores del usuario en la posición indice
	public void updatePublicacion (int indice, Publicacion c) {
		if (indice > -1 && indice < this.getSize()) {
			lstPub.set(indice, c);
			this.fireContentsChanged(this, indice, indice);
		}
	}
}
