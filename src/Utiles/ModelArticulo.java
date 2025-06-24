package Utiles;
import java.util.ArrayList;

import javax.swing.AbstractListModel;

import Logica.*;

public class ModelArticulo extends AbstractListModel {
    
    private ArrayList <Articulo> lstArticulo = new ArrayList<Articulo>();

    // establece la lista de artículos al modelo
    public void setlstArticulo(ArrayList<Articulo> lstArticulo) {
        this.lstArticulo = lstArticulo;
        this.fireIntervalAdded(this, 0, getSize());
    }

    // devuelve el tamaño de la lista del modelo
    public int getSize() {
        return lstArticulo.size();
    }

    // devuelve el elemento de la posición index dentro del modelo
    public Object getElementAt(int indice) {
        Articulo x = null;
        if (indice > -1 && indice < this.getSize())
            x = lstArticulo.get(indice);
        return x;
    }

    // agrega un artículo al final de la lista del modelo
    public void addArticulo(Articulo p) {
        lstArticulo.add(p);
        this.fireIntervalAdded(this, getSize(), getSize());
    }

    // agrega un artículo al modelo en la posición indice
    public Articulo getArticuloAt(int indice) {
        Articulo x = null;
        if (indice > -1 && indice < this.getSize())
            x = lstArticulo.get(indice);
        return x;
    }

    // elimina un artículo del modelo que ocupa la posición indice
    public void removeArticulo(int indice) {
        if (indice > -1 && indice < this.getSize()) {
            lstArticulo.remove(indice);
            this.fireIntervalRemoved(this, indice, indice);
        }
    }
    // modifica en el modelo los valores del artículo en la posición indice
    public void updateArticulo(int indice, Articulo c) {
        if (indice > -1 && indice < this.getSize()) {
            lstArticulo.set(indice, c);
            this.fireContentsChanged(this, indice, indice);
        }
    }
}