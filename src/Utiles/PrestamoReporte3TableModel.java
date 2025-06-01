package Utiles;

import javax.swing.table.DefaultTableModel;

import Logica.Prestamo;

public class PrestamoReporte3TableModel extends DefaultTableModel {

	private static final long serialVersionUID = 1L;

	public PrestamoReporte3TableModel(Prestamo[] prestamos){

		String[] columnNames = {"Titulo", "Tipo", "Fecha Prestamo", "Fecha Devolucion", "Fecha Maxima"};
		setColumnIdentifiers(columnNames);

		for (int i = 0; i < prestamos.length; i++) {
			Object[] newRow = new Object[]{prestamos[i].getPub().getTitulo(), prestamos[i].getPub().getClass().getSimpleName(), prestamos[i].getFechaP(), prestamos[i].getFechaDevolucion(), prestamos[i].getFechaMax()};
			addRow(newRow);
		}
	}
}