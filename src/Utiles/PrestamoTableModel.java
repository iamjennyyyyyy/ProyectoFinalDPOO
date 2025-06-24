package Utiles;

import javax.swing.table.DefaultTableModel;

import Logica.Prestamo;

public class PrestamoTableModel extends DefaultTableModel {

	private static final long serialVersionUID = 1L;

	public PrestamoTableModel(Prestamo[] prestamos, boolean mostrarFechaDev){

		if(mostrarFechaDev){
			String[] columnNames = {"ID Usuario", "ID Publicacion", "Fecha Prestamo", "Fecha Devolucion", "Fecha Maxima", "Penalizacion"};
			setColumnIdentifiers(columnNames);
		}
		else{
			String[] columnNames = {"ID Usuario", "ID Publicacion", "Fecha Prestamo", "Fecha Maxima", "Penalizacion"};
			setColumnIdentifiers(columnNames);
		}

		for (int i = 0; i < prestamos.length; i++) {

			boolean tienePenalizacion = prestamos[i].getUser().getFechaPenalizacion() != null;

			if(mostrarFechaDev){
				if(prestamos[i].getFechaDevolucion() == null){
					if(tienePenalizacion){
						Object[] newRow = new Object[]{prestamos[i].getUser().getId(), prestamos[i].getPub().getId(), prestamos[i].getFechaP(), " - ", prestamos[i].getFechaMax(), prestamos[i].getUser().getFechaPenalizacion()};
						addRow(newRow);
					}
					else{
						Object[] newRow = new Object[]{prestamos[i].getUser().getId(), prestamos[i].getPub().getId(), prestamos[i].getFechaP(), " - ", prestamos[i].getFechaMax(), " - "};
						addRow(newRow);
					}
				}
				else{
					if(tienePenalizacion){
						Object[] newRow = new Object[]{prestamos[i].getUser().getId(), prestamos[i].getPub().getId(), prestamos[i].getFechaP(), prestamos[i].getFechaDevolucion(), prestamos[i].getFechaMax(),prestamos[i].getUser().getFechaPenalizacion()};
						addRow(newRow);
					}
					else{
						Object[] newRow = new Object[]{prestamos[i].getUser().getId(), prestamos[i].getPub().getId(), prestamos[i].getFechaP(), prestamos[i].getFechaDevolucion(), prestamos[i].getFechaMax()," - "};
						addRow(newRow);
					}
				}
			}
			else{
				Object[] newRow = new Object[]{prestamos[i].getUser().getId(), prestamos[i].getPub().getId(), prestamos[i].getFechaP(), prestamos[i].getFechaMax()};
				addRow(newRow);
			}
		}
	}
}