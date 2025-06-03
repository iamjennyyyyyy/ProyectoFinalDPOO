package Utiles;
import java.util.ArrayList;

import javax.swing.AbstractListModel;

import Logica.Biblioteca;
import Logica.UsuarioAcreditado;

public class ModelUsuario extends AbstractListModel {
	private ArrayList <UsuarioAcreditado> usuarios = new ArrayList<UsuarioAcreditado>();

	public void setListaUsuarios(ArrayList <UsuarioAcreditado> usuarios) {
		this.usuarios = usuarios;
		this.fireIntervalAdded(this, 0, getSize());
		this.fireContentsChanged(this, 0, getSize()-1);
	}
	public int getSize() {
		return usuarios.size();
	}
	public Object getElementAt(int indice) {
		UsuarioAcreditado x = null;
		if (indice > -1 && indice < this.getSize())
			x = usuarios.get(indice);
		return x;
	}
	public void addUsuario(UsuarioAcreditado u) {
		usuarios.add(u);
		this.fireIntervalAdded(this, getSize(), getSize());
	}

	// devuelve el candidato en la posición del indice dado en el modelo
	public UsuarioAcreditado getUsuarioAt(int indice) {
		UsuarioAcreditado x = null;
		if (indice > -1 && indice < this.getSize())
			x = usuarios.get(indice);
		return x;
	}

	// elimina un candidato del modelo que ocupa la posición indice
	public void removeUsuario (int indice) {
		if (indice > -1 && indice < this.getSize()) {
			usuarios.remove(indice);
			this.fireIntervalRemoved(this, indice, indice);
		}
	}
	// modifica en el modelo los valores del candidato en la posición dada
	public void updateUsuarioAcreditado (int indice, UsuarioAcreditado c) {
		if (indice > -1 && indice < this.getSize()) {
			usuarios.set(indice, c);
			this.fireContentsChanged(this, indice, indice);
		}
	}
}
