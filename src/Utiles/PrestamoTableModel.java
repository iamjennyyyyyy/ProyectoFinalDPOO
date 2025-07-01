package Utiles;

import javax.swing.table.DefaultTableModel;

import Logica.Prestamo;

public class PrestamoTableModel extends DefaultTableModel {

	private static final long serialVersionUID = 1L;

	public PrestamoTableModel(Prestamo[] prestamos, boolean mostrarFechaDev){

		if(mostrarFechaDev){
			String[] columnNames = {"ID Usuario", "ID Publicaci�n", "Pr�stamo", "Devoluci�n", "Fecha M�xima"};
			setColumnIdentifiers(columnNames);
		}
		else{
			String[] columnNames = {"ID Usuario", "ID Publicaci�n", "Pr�stamo", "Fecha M�xima"};
			setColumnIdentifiers(columnNames);
		}

		for (int i = 0; i < prestamos.length; i++) {

			if(mostrarFechaDev){
				if(prestamos[i].getFechaDevolucion() == null){
					Object[] newRow = new Object[]{prestamos[i].getUser().getId(), prestamos[i].getPub().getId(), prestamos[i].getFechaP(), " - ", prestamos[i].getFechaMax()};
					addRow(newRow);
				}
				else{
					Object[] newRow = new Object[]{prestamos[i].getUser().getId(), prestamos[i].getPub().getId(), prestamos[i].getFechaP(), prestamos[i].getFechaDevolucion(), prestamos[i].getFechaMax()};
					addRow(newRow);
				}
			}
			else{
				Object[] newRow = new Object[]{prestamos[i].getUser().getId(), prestamos[i].getPub().getId(), prestamos[i].getFechaP(), prestamos[i].getFechaMax()};
				addRow(newRow);
			}
		}
	}
}