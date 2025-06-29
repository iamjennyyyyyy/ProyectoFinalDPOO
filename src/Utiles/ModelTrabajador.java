package Utiles;

import java.util.ArrayList;
import javax.swing.AbstractListModel;
import Logica.Trabajador;

public class ModelTrabajador extends AbstractListModel<Trabajador> {
    private ArrayList<Trabajador> lstTrabajadores = new ArrayList<Trabajador>();

    /** Reemplaza el contenido y notifica al JList para repintar */
    public void setlstTrabajadores(ArrayList<Trabajador> lstTrabajadores) {
        this.lstTrabajadores = lstTrabajadores;
        if (getSize() > 0) {
            fireContentsChanged(this, 0, getSize() - 1);
        } else {
            // notifica “vacío”
            fireContentsChanged(this, -1, -1);
        }
    }

    @Override
    public int getSize() {
        return lstTrabajadores.size();
    }

    @Override
    public Trabajador getElementAt(int indice) {
        return (indice >= 0 && indice < getSize())
             ? lstTrabajadores.get(indice)
             : null;
    }

    /** Añade un trabajador y notifica la inserción final */
    public void addTrabajador(Trabajador p) {
        int idx = lstTrabajadores.size();
        lstTrabajadores.add(p);
        fireIntervalAdded(this, idx, idx);
    }

    /** Obtiene el trabajador en la posición indicada */
    public Trabajador getTrabajadorAt(int indice) {
        return (indice >= 0 && indice < getSize())
             ? lstTrabajadores.get(indice)
             : null;
    }
    public boolean contieneCarnet(String id) {
        for (int i = 0; i < getSize(); i++) {
            if (getElementAt(i).getId().equals(id)) {
                return true;
            }
        }
        return false;
    }


    /** Elimina y notifica */
    public void removeTrabajador(int indice) {
        if (indice >= 0 && indice < getSize()) {
            lstTrabajadores.remove(indice);
            fireIntervalRemoved(this, indice, indice);
        }
    }

    /** Actualiza y notifica */
    public void updateTrabajador(int indice, Trabajador c) {
        if (indice >= 0 && indice < getSize()) {
            lstTrabajadores.set(indice, c);
            fireContentsChanged(this, indice, indice);
        }
    }
}