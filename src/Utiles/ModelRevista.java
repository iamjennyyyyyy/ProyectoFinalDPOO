package Utiles;
import java.util.ArrayList;

import javax.swing.AbstractListModel;

import Logica.*;

public class ModelRevista extends AbstractListModel {
    
    private ArrayList <Revista> lstRevista = new ArrayList<Revista>();

    // establece la lista de revistas al modelo
    public void setlstRevista(ArrayList<Revista> lstRevista) {
        this.lstRevista = lstRevista;
        this.fireIntervalAdded(this, 0, getSize());
    }

    // devuelve el tamaño de la lista del modelo
    public int getSize() {
        return lstRevista.size();
    }

    // devuelve el elemento de la posición index dentro del modelo
    public Object getElementAt(int indice) {
        Revista x = null;
        if (indice > -1 && indice < this.getSize())
            x = lstRevista.get(indice);
        return x;
    }

    // agrega una revista al final de la lista del modelo
    public void addRevista(Revista p) {
        lstRevista.add(p);
        this.fireIntervalAdded(this, getSize(), getSize());
    }

    // agrega una revista al modelo en la posición indice
    public Revista getRevistaAt(int indice) {
        Revista x = null;
        if (indice > -1 && indice < this.getSize())
            x = lstRevista.get(indice);
        return x;
    }

    // elimina una revista del modelo que ocupa la posición indice
    public void removeRevista(int indice) {
        if (indice > -1 && indice < this.getSize()) {
            lstRevista.remove(indice);
            this.fireIntervalRemoved(this, indice, indice);
        }
    }
    // modifica en el modelo los valores de la revista en la posición indice
    public void updateRevista(int indice, Revista c) {
        if (indice > -1 && indice < this.getSize()) {
            lstRevista.set(indice, c);
            this.fireContentsChanged(this, indice, indice);
        }
    }
}