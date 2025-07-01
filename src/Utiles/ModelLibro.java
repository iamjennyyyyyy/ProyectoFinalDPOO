package Utiles;
import java.util.ArrayList;

import javax.swing.AbstractListModel;

import Logica.*;

public class ModelLibro extends AbstractListModel {
    
    private ArrayList <Libro> lstLibro = new ArrayList<Libro>();

    // establece la lista de libros al modelo
    public void setlstLibro(ArrayList<Libro> lstLibro) {
        this.lstLibro = lstLibro;
        this.fireIntervalAdded(this, 0, getSize());
    }

    // devuelve el tamaño de la lista del modelo
    public int getSize() {
        return lstLibro.size();
    }
    
    public void eliminarLibro(Libro p){
    	int indice = -1;
    	for(int i = 0; i < lstLibro.size() && indice == -1; i++){
    		if(lstLibro.get(i).equals(p))
    			indice = i;
    	}
    	lstLibro.remove(indice);
    }

    // devuelve el elemento de la posición index dentro del modelo
    public Object getElementAt(int indice) {
        Libro x = null;
        if (indice > -1 && indice < this.getSize())
            x = lstLibro.get(indice);
        return x;
    }

    // agrega un libro al final de la lista del modelo
    public void addLibro(Libro p) {
        lstLibro.add(p);
        this.fireIntervalAdded(this, getSize(), getSize());
    }

    // agrega un libro al modelo en la posición indice
    public Libro getLibroAt(int indice) {
        Libro x = null;
        if (indice > -1 && indice < this.getSize())
            x = lstLibro.get(indice);
        return x;
    }

    // elimina un libro del modelo que ocupa la posición indice
    public void removeLibro(int indice) {
        if (indice > -1 && indice < this.getSize()) {
            lstLibro.remove(indice);
            this.fireIntervalRemoved(this, indice, indice);
        }
    }
    // modifica en el modelo los valores del libro en la posición indice
    public void updateLibro(int indice, Libro c) {
        if (indice > -1 && indice < this.getSize()) {
            lstLibro.set(indice, c);
            this.fireContentsChanged(this, indice, indice);
        }
    }
}