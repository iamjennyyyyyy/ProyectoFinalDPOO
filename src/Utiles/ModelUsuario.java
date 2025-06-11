package Utiles;
import java.util.ArrayList;

import javax.swing.AbstractListModel;

import Logica.*;

public class ModelUsuario extends AbstractListModel {
	
	private ArrayList <UsuarioAcreditado> lstUsuarios = new ArrayList<UsuarioAcreditado>();

	// establece la lista de usuarios al modelo
	public void setlstUsuarios(ArrayList<UsuarioAcreditado> lstUsuarios) {
		this.lstUsuarios = lstUsuarios;
		this.fireIntervalAdded(this, 0, getSize());
	}

	// devuelve el tamaño de la lista del modelo
	public int getSize() {
		return lstUsuarios.size();
	}

	// devuelve el elemento de la posición index dentro del modelo
	public Object getElementAt(int indice) {
		UsuarioAcreditado x = null;
		if (indice > -1 && indice < this.getSize())
			x = lstUsuarios.get(indice);
		return x;
	}

	// agrega un usuario al final de la lista del modelo
	public void addUsuario(UsuarioAcreditado p) {
		lstUsuarios.add(p);
		this.fireIntervalAdded(this, getSize(), getSize());
	}

	// agrega un usuario al modelo en la posición indice
	public UsuarioAcreditado getUsuarioAt(int indice) {
		UsuarioAcreditado x = null;
		if (indice > -1 && indice < this.getSize())
			x = lstUsuarios.get(indice);
		return x;
	}

	// elimina un usuario del modelo que ocupa la posición indice
	public void removeUsuario (int indice) {
		if (indice > -1 && indice < this.getSize()) {
			lstUsuarios.remove(indice);
			this.fireIntervalRemoved(this, indice, indice);
		}
	}
	// modifica en el modelo los valores del usuario en la posición indice
	public void updateUsuario (int indice, UsuarioAcreditado c) {
		if (indice > -1 && indice < this.getSize()) {
			lstUsuarios.set(indice, c);
			this.fireContentsChanged(this, indice, indice);
		}
	}
}
