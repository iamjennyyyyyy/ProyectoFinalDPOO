package Utiles;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class PrestamoTableModel extends DefaultTableModel {
	
	private static final long serialVersionUID = 1L;

	public PrestamoTableModel(){
	
	String[] columnNames = {"ID Usuario", "ID Publicacion", "Fecha Prestamo", "Fecha Maxima", "Fecha Devolucion"};
	setColumnIdentifiers(columnNames);
	this.setColumnIdentifiers(columnNames);
	}

	public void adicionar(String idUsuario ,String idPublicacion, String
			fechaPrestamo, String fechaMaxima, String fechaDevolucion){ 
		boolean vacio = fechaDevolucion == null;
		Object fechaDev;
		if(vacio)
			fechaDev = "-";
		else
			fechaDev = fechaDevolucion;
			Object[] newRow = new Object[]{idUsuario , idPublicacion, fechaPrestamo, fechaMaxima,fechaDev};
			addRow(newRow);
	} 
}
