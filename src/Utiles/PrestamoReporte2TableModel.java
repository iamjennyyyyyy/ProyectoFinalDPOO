package Utiles;

import javax.swing.table.DefaultTableModel;

import Logica.Prestamo;

public class PrestamoReporte2TableModel extends DefaultTableModel {

	private static final long serialVersionUID = 1L;

	public PrestamoReporte2TableModel(Prestamo[] prestamos){

		String[] columnNames = {"Titulo", "Fecha Prestamo", "Fecha Maxima"};
		setColumnIdentifiers(columnNames);

		for (int i = 0; i < prestamos.length; i++) {
			Object[] newRow = new Object[]{prestamos[i].getPub().getTitulo(), prestamos[i].getFechaP(), prestamos[i].getFechaMax()};
			addRow(newRow);
		}
	}
}